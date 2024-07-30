import java.util.Arrays;

public class Search {

    public static void main(String[] args) {
        Product[] products = {
            new Product("1", "Laptop", "Electronics"),
            new Product("2", "Smartphone", "Electronics"),
            new Product("3", "Tablet", "Electronics")
        };

        // Sort products by productName for binary search
        Arrays.sort(products, (p1, p2) -> p1.getProductName().compareTo(p2.getProductName()));

        // Linear Search
        Product foundProductLinear = linearSearch(products, "Smartphone");
        if (foundProductLinear != null) {
            System.out.println("Linear Search Found: " + foundProductLinear.getProductName());
        } else {
            System.out.println("Product not found with Linear Search.");
        }

        // Binary Search
        Product foundProductBinary = binarySearch(products, "Smartphone");
        if (foundProductBinary != null) {
            System.out.println("Binary Search Found: " + foundProductBinary.getProductName());
        } else {
            System.out.println("Product not found with Binary Search.");
        }
    }

    public static Product linearSearch(Product[] products, String productName) {
        for (Product product : products) {
            if (product.getProductName().equals(productName)) {
                return product;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, String productName) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = products[mid].getProductName().compareTo(productName);

            if (comparison == 0) {
                return products[mid];
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }
}

class Product {
    private String productId;
    private String productName;
    private String category;

    public Product(String productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    // Getters and Setters
    public String getProductId() { return productId; }
    public void setProductId(String productId) { this.productId = productId; }

    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
}
