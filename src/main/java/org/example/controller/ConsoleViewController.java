package org.example.controller;

import java.util.Scanner;

import static org.example.controller.CosmeticsController.listProducts;
import static org.example.controller.SearchCosmeticsController.searchProducts;

public class ConsoleViewController {

    public static void control() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("\nEnter command (1-3): ");
            int command = scanner.nextInt();
            if (command == 1) {
                searchProducts();
            } else if (command == 2) {
                listProducts();
            } else if (command == 3) {
                System.out.println("Exiting the program. Goodbye!");
                scanner.close();
                return;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
