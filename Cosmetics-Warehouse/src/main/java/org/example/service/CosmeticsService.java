package org.example.service;

import org.example.dao.Cosmetics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.example.dao.CosmeticsDao.list;
import static org.example.dao.CosmeticsDao.search;

public class CosmeticsService {

    public static void searchEquipment(List<Cosmetics> inventory, String parameter, String value, List<Cosmetics> results) {
        search(inventory, parameter, value, results);
        if (results.isEmpty()) {
            System.out.println("No products found.");
            return;
        }
        System.out.println("Search results:");
        for (Cosmetics cosmetics : results) {
            System.out.println(cosmetics);
        }
    }

    public static void listEquipment(String order, List<Cosmetics> cosmetics) {
        List<Cosmetics> sorted = list(order, cosmetics);
        System.out.println("Product list:");
        for (Cosmetics equipment : sorted) {
            System.out.println(equipment);
        }
    }

    public static List<Cosmetics> storeEquipments() {
        List<Cosmetics> inventory = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/java/org/example/dao/Cosmetics.csv"))) {
            String line = reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                int id = Integer.parseInt(fields[0]);
                String name = fields[1];
                String category = fields[2];
                double price = Double.parseDouble(fields[3]);
                int quantity = Integer.parseInt(fields[4]);
                Cosmetics cosmetics = new Cosmetics(id, name, category, price, quantity);
                inventory.add(cosmetics);
            }
        } catch (IOException e) {
            System.err.println("Error reading Cosmetics.csv file: " + e.getMessage());
        }
        return inventory;
    }
}
