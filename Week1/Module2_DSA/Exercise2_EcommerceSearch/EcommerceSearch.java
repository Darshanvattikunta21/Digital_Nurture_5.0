import java.util.Arrays;
import java.util.Comparator;

class Product {
    private final int productId;
    private final String productName;
    private final String category;

    Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    int getProductId() {
        return productId;
    }

    String getProductName() {
        return productName;
    }

    @Override
    public String toString() {
        return productId + " - " + productName + " (" + category + ")";
    }
}

public class EcommerceSearch {
    public static Product linearSearch(Product[] products, String productName) {
        for (Product product : products) {
            if (product.getProductName().equalsIgnoreCase(productName)) {
                return product;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, int productId) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            int currentId = products[middle].getProductId();

            if (currentId == productId) {
                return products[middle];
            }

            if (currentId < productId) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product(103, "Laptop", "Electronics"),
            new Product(101, "Shoes", "Fashion"),
            new Product(105, "Coffee Mug", "Home"),
            new Product(102, "Phone", "Electronics")
        };

        System.out.println("Linear search result: " + linearSearch(products, "Phone"));

        Arrays.sort(products, Comparator.comparingInt(Product::getProductId));
        System.out.println("Binary search result: " + binarySearch(products, 105));
    }
}
