package org.example.controller;

import org.example.dao.Cosmetics;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.example.service.CosmeticsService.searchEquipment;
import static org.example.service.CosmeticsService.storeEquipments;


public class SearchCosmeticsController {
    public static void searchProducts() {
        List<Cosmetics> inventory = storeEquipments();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter search parameter (ID, name, category, price, or quantity): ");
        String parameter = scanner.nextLine().trim().toLowerCase();
        System.out.print("Enter search value: ");
        String value = scanner.nextLine().trim().toLowerCase();
        List<Cosmetics> results = new ArrayList<>();
        searchEquipment(inventory, parameter, value, results);
    }

}
