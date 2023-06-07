package org.example.view;

import static org.example.controller.ConsoleViewController.control;

public class ConsoleView {

    public static void main(String[] args) {
        System.out.println("Cosmetics Warehouse (Created on April 29, 2023)");
        System.out.println("Developer:  (Biloliddin_Fayzullayev@student.itpu.uz)");


        System.out.println("\nAvailable commands:");
        System.out.println("1. Search products");
        System.out.println("2. List all products");
        System.out.println("3. Exit");
        control();
    }
}
