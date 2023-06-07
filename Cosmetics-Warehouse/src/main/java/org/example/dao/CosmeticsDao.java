package org.example.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CosmeticsDao {

    public static List<Cosmetics> search(List<Cosmetics> inventory, String parameter, String value, List<Cosmetics> results) {
        for (Cosmetics cosmetics : inventory) {
            switch (parameter) {
                case "id":
                    if (cosmetics.getId() == Integer.parseInt(value)) {
                        results.add(cosmetics);
                    }
                    break;
                case "name":
                    if (cosmetics.getName().toLowerCase().contains(value)) {
                        results.add(cosmetics);
                    }
                    break;
                case "category":
                    if (cosmetics.getCategory().toLowerCase().contains(value)) {
                        results.add(cosmetics);
                    }
                    break;
                case "price":
                    if (cosmetics.getPrice() == Double.parseDouble(value)) {
                        results.add(cosmetics);
                    }
                    break;
                case "quantity":
                    if (cosmetics.getQuantity() == Integer.parseInt(value)) {
                        results.add(cosmetics);
                    }
                    break;
                default:
                    System.out.println("Invalid search parameter.");
            }
        }
        return results;
    }

    public static List<Cosmetics> list(String order, List<Cosmetics> cosmetics) {
        List<Cosmetics> sorted = new ArrayList<>(cosmetics);
        switch (order) {
            case "id":
                Collections.sort(sorted, Comparator.comparingInt(Cosmetics::getId));
                break;
            case "name":
                Collections.sort(sorted, Comparator.comparing(Cosmetics::getName));
                break;
            case "category":
                Collections.sort(sorted, Comparator.comparing(Cosmetics::getCategory));
                break;
            case "price":
                Collections.sort(sorted, Comparator.comparingDouble(Cosmetics::getPrice));
                break;
            case "quantity":
                Collections.sort(sorted, Comparator.comparingInt(Cosmetics::getQuantity));
                break;
            default:
                System.out.println("Invalid sort order.");
        }
        return sorted;
    }
}
