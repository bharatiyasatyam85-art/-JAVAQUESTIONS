import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Product {
    int productId;
    String productName;
    double price;
    int quantity;

    Product(int productId, String productName, double price, int quantity) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    double getTotalPrice() {
        return price * quantity;
    }

    void display() {
        System.out.println(
                "Product ID: " + productId +
                ", Name: " + productName +
                ", Price: Rs. " + price +
                ", Quantity: " + quantity +
                ", Total: Rs. " + getTotalPrice()
        );
    }
}

public class OnlineShoppingCart {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        HashMap<Integer, Product> cart = new HashMap<>();

        cart.put(101, new Product(101, "Laptop", 55000, 1));
        cart.put(102, new Product(102, "Mouse", 800, 2));
        cart.put(103, new Product(103, "Keyboard", 1500, 1));

        System.out.println("Shopping Cart:");
        System.out.println("-----------------------------");

        for (Product product : cart.values()) {
            product.display();
        }

        System.out.println("\nUpdating Quantity of Product 102...");
        Product product = cart.get(102);

        if (product != null) {
            product.quantity = 3;
            System.out.println("Quantity Updated Successfully.");
        }

        System.out.println("\nRemoving Product 103...");

        if (cart.remove(103) != null) {
            System.out.println("Product Removed Successfully.");
        }

        System.out.println("\nUpdated Shopping Cart:");
        System.out.println("-----------------------------");

        double totalCartAmount = 0;

        for (Map.Entry<Integer, Product> entry : cart.entrySet()) {
            Product p = entry.getValue();
            p.display();
            totalCartAmount += p.getTotalPrice();
        }

        System.out.println("-----------------------------");
        System.out.println("Total Cart Amount: Rs. " + totalCartAmount);

        sc.close();
    }
}
