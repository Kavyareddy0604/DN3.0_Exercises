import java.util.ArrayList;
import java.util.List;

// Subject Interface
interface Stock {
    void registerObserver(Observer observer);
    void deregisterObserver(Observer observer);
    void notifyObservers();
}

// Concrete Subject
class StockMarket implements Stock {
    private List<Observer> observers = new ArrayList<>();
    private double stockPrice;

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void deregisterObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(stockPrice);
        }
    }

    public void setStockPrice(double stockPrice) {
        this.stockPrice = stockPrice;
        notifyObservers();
    }
}

// Observer Interface
interface Observer {
    void update(double stockPrice);
}

// Concrete Observers
class MobileApp implements Observer {
    @Override
    public void update(double stockPrice) {
        System.out.println("MobileApp: Stock price updated to $" + stockPrice);
    }
}

class WebApp implements Observer {
    @Override
    public void update(double stockPrice) {
        System.out.println("WebApp: Stock price updated to $" + stockPrice);
    }
}

// Test Class
public class ObserverPatternExample {
    public static void main(String[] args) {
        // Create the stock market (subject)
        StockMarket stockMarket = new StockMarket();

        // Create observers
        Observer mobileApp = new MobileApp();
        Observer webApp = new WebApp();

        // Register observers
        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);

        // Update stock price
        stockMarket.setStockPrice(150.00);

        // Unregister an observer and update stock price again
        stockMarket.deregisterObserver(mobileApp);
        stockMarket.setStockPrice(155.00);
    }
}
