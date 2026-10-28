package com.discount.app;

import com.discount.engine.DiscountEngine;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DiscountEngine engine = new DiscountEngine();

        System.out.println("=== Welcome to the Lambda Discount Engine ===");
        
        
        System.out.println("\nSelect a discount rule:");
        System.out.println("1. 10% Off Everything");
        System.out.println("2. Flat $5 Off");
        System.out.println("3. VIP half price");
        System.out.print("Enter choice (1-3): ");
        int choice = scanner.nextInt();

        Function<Double, Double> chosenRule;
        switch (choice) {
            case 1 -> chosenRule = DiscountEngine.TEN_PERCENT_OFF;
            case 2 -> chosenRule = DiscountEngine.FLAT_FIVE_OFF;
            case 3 -> chosenRule = DiscountEngine.VIP_HALF_PRICE;
            default -> {
                System.out.println("Invalid choice. Defaulting to No Discount.");
                chosenRule = price -> price;
            }
        }

       
        System.out.print("\nEnter how many items you have: ");
        int count = scanner.nextInt();
        
        List<Double> prices = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            System.out.print("Enter price for item " + (i + 1) + ": ");
            prices.add(scanner.nextDouble());
        }

        
        List<Double> discountedPrices = engine.applyDiscount(prices, chosenRule);
        
        System.out.println("\n=== Final Receipt ===");
        System.out.printf("%-15s %-15s%n", "Original Price", "Discounted Price");
        for (int i = 0; i < prices.size(); i++) {
            System.out.printf("$%-14.2f $%-14.2f%n", prices.get(i), discountedPrices.get(i));
        }
        
        scanner.close();
    }
}
