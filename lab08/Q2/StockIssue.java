import java.util.*;

// Custom checked exception
class OutOfStockException extends Exception {

    OutOfStockException(String message) {
        super(message);
    }
}

// Custom checked exception
class InvalidQuantityException extends Exception {

    InvalidQuantityException(String message) {
        super(message);
    }
}

// Warehouse class
class Warehouse {

    int stock = 50;

    public void issue(String item, int qty)
            throws OutOfStockException, InvalidQuantityException {

        // Check invalid quantity
        if (qty <= 0) {
            throw new InvalidQuantityException(
                "Quantity must be greater than zero!"
            );
        }

        // Check available stock
        if (qty > stock) {
            throw new OutOfStockException(
                "Not enough stock for item: " + item
            );
        }

        stock = stock - qty;

        System.out.println(
            "Successfully issued " + qty + " units of " + item
        );

        System.out.println("Remaining stock: " + stock);
    }
}

// Main class
public class StockIssue {

    public static void main(String[] args) {

        Warehouse warehouse = new Warehouse();

        // List of requests
        String[] items = {
            "Laptop",
            "Mobile",
            "Keyboard",
            "Mouse"
        };

        int[] quantities = {
            10,
            60,
            -5,
            15
        };

        // Process every request
        for (int i = 0; i < items.length; i++) {

            try {

                warehouse.issue(items[i], quantities[i]);

            }

            catch (OutOfStockException e) {

                System.out.println("Stock Error: " + e.getMessage());

            }

            catch (InvalidQuantityException e) {

                System.out.println("Quantity Error: " + e.getMessage());

            }

            finally {

                System.out.println("Request processing completed.");
                System.out.println("-----------------------------");

            }
        }

        System.out.println("All requests processed.");
    }
}