public class SortingOrders {

    public static void main(String[] args) {
        Order[] orders = {
            new Order(1, "Alice", 150.75),
            new Order(2, "Bob", 85.50),
            new Order(3, "Charlie", 120.00),
            new Order(4, "Diana", 200.00)
        };

        // Bubble Sort
        System.out.println("Bubble Sort:");
        bubbleSort(orders);
        for (Order order : orders) {
            System.out.println(order);
        }

        // Resetting array for Quick Sort
        orders = new Order[]{
            new Order(1, "Alice", 150.75),
            new Order(2, "Bob", 85.50),
            new Order(3, "Charlie", 120.00),
            new Order(4, "Diana", 200.00)
        };

        // Quick Sort
        System.out.println("\nQuick Sort:");
        quickSort(orders, 0, orders.length - 1);
        for (Order order : orders) {
            System.out.println(order);
        }
    }

    // Bubble Sort implementation
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].getTotalPrice() > orders[j + 1].getTotalPrice()) {
                    // Swap orders[j] and orders[j + 1]
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no two elements were swapped in the inner loop, then the array is sorted
            if (!swapped) break;
        }
    }

    // Quick Sort implementation
    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].getTotalPrice();
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (orders[j].getTotalPrice() < pivot) {
                i++;
                // Swap orders[i] and orders[j]
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        // Swap orders[i + 1] and orders[high]
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;
        return i + 1;
    }

    // Order class
    public static class Order {
        private int orderId;
        private String customerName;
        private double totalPrice;

        // Constructor
        public Order(int orderId, String customerName, double totalPrice) {
            this.orderId = orderId;
            this.customerName = customerName;
            this.totalPrice = totalPrice;
        }

        // Getters
        public int getOrderId() { return orderId; }
        public String getCustomerName() { return customerName; }
        public double getTotalPrice() { return totalPrice; }

        // Setters
        public void setOrderId(int orderId) { this.orderId = orderId; }
        public void setCustomerName(String customerName) { this.customerName = customerName; }
        public void setTotalPrice(double totalPrice) { this.totalPrice = totalPrice; }

        @Override
        public String toString() {
            return "Order{" +
                    "orderId=" + orderId +
                    ", customerName='" + customerName + '\'' +
                    ", totalPrice=" + totalPrice +
                    '}';
        }
    }
}
