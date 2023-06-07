package org.example.controller;

import org.example.dao.Cosmetics;

import java.util.List;
import java.util.Scanner;

import static org.example.service.CosmeticsService.listEquipment;
import static org.example.service.CosmeticsService.storeEquipments;

public class CosmeticsController {

    public static void listProducts() {
        List<Cosmetics> cosmetics = storeEquipments();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter sort order (ID, name, category, price, or quantity): ");
        String order = scanner.nextLine().trim().toLowerCase();
        listEquipment(order, cosmetics);
    }
}
