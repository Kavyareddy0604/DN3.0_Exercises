public class AdapterPatternExample {

    // Target Interface
    interface PaymentProcessor {
        void processPayment(double amount);
    }

    // Adaptee Classes
    static class PayPal {
        public void makePayment(double amount) {
            System.out.println("Processing payment of $" + amount + " through PayPal.");
        }
    }

    static class Stripe {
        public void charge(double amount) {
            System.out.println("Charging $" + amount + " through Stripe.");
        }
    }

    static class Square {
        public void pay(double amount) {
            System.out.println("Paying $" + amount + " through Square.");
        }
    }

    // Adapter Classes
    static class PayPalAdapter implements PaymentProcessor {
        private PayPal payPal;

        public PayPalAdapter(PayPal payPal) {
            this.payPal = payPal;
        }

        @Override
        public void processPayment(double amount) {
            payPal.makePayment(amount);
        }
    }

    static class StripeAdapter implements PaymentProcessor {
        private Stripe stripe;

        public StripeAdapter(Stripe stripe) {
            this.stripe = stripe;
        }

        @Override
        public void processPayment(double amount) {
            stripe.charge(amount);
        }
    }

    static class SquareAdapter implements PaymentProcessor {
        private Square square;

        public SquareAdapter(Square square) {
            this.square = square;
        }

        @Override
        public void processPayment(double amount) {
            square.pay(amount);
        }
    }

    // Test Class
    public static void main(String[] args) {
        PaymentProcessor paypalProcessor = new PayPalAdapter(new PayPal());
        PaymentProcessor stripeProcessor = new StripeAdapter(new Stripe());
        PaymentProcessor squareProcessor = new SquareAdapter(new Square());

        // Process payments through different gateways
        paypalProcessor.processPayment(100.00);
        stripeProcessor.processPayment(200.00);
        squareProcessor.processPayment(300.00);
    }
}
