import java.util.HashMap;
import java.util.Map;

public class InventoryManagementSystem {
    private Map<String, Product> inventory;

    public InventoryManagementSystem() {
        inventory = new HashMap<>();
    }

    public void addProduct(Product product) {
        inventory.put(product.getProductId(), product);
    }

    public void updateProduct(String productId, Product updatedProduct) {
        inventory.put(productId, updatedProduct);
    }

    public void deleteProduct(String productId) {
        inventory.remove(productId);
    }

    public Product getProduct(String productId) {
        return inventory.get(productId);
    }

    public int getInventorySize() {
        return inventory.size();
    }

    public static void main(String[] args) {
        InventoryManagementSystem ims = new InventoryManagementSystem();

        Product product1 = new Product("1", "Laptop", 10, 999.99);
        Product product2 = new Product("2", "Smartphone", 50, 499.99);

        ims.addProduct(product1);
        ims.addProduct(product2);

        System.out.println("Inventory Size: " + ims.getInventorySize());

        Product fetchedProduct = ims.getProduct("1");
        System.out.println("Fetched Product: " + fetchedProduct.getProductName());

        ims.updateProduct("1", new Product("1", "Gaming Laptop", 5, 1999.99));
        fetchedProduct = ims.getProduct("1");
        System.out.println("Updated Product: " + fetchedProduct.getProductName());

        ims.deleteProduct("2");
        System.out.println("Inventory Size after deletion: " + ims.getInventorySize());
    }
}

class Product {
    private String productId;
    private String productName;
    private int quantity;
    private double price;

    public Product(String productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters and Setters
    public String getProductId() { return productId; }
    public void setProductId(String productId) { this.productId = productId; }

    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}
