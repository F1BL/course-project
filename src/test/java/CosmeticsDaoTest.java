import org.example.dao.Cosmetics;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.example.dao.CosmeticsDao.list;
import static org.example.dao.CosmeticsDao.search;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CosmeticsDaoTest {

    @Test
    void testListSortById() {
        // Arrange
        List<Cosmetics> cosmetics = new ArrayList<>();
        cosmetics.add(new Cosmetics(2, "Lipstick", "Makeup", 12.99, 50));
        cosmetics.add(new Cosmetics(1, "Shampoo", "Haircare", 8.99, 20));
        cosmetics.add(new Cosmetics(3, "Perfume", "Fragrance", 24.99, 10));

        // Act
        List<Cosmetics> sortedList = list("id", cosmetics);

        // Assert
        assertEquals(1, sortedList.get(0).getId());
        assertEquals(2, sortedList.get(1).getId());
        assertEquals(3, sortedList.get(2).getId());
    }


    @Test
    void testSearchById() {
        // Arrange
        List<Cosmetics> inventory = new ArrayList<>();
        inventory.add(new Cosmetics(1, "Lipstick", "Makeup", 12.99, 50));
        inventory.add(new Cosmetics(2, "Shampoo", "Haircare", 8.99, 20));
        inventory.add(new Cosmetics(3, "Perfume", "Fragrance", 24.99, 10));

        List<Cosmetics> results = new ArrayList<>();

        // Act
        List<Cosmetics> searchResults = search(inventory, "id", "2", results);

        // Assert
        assertEquals(1, searchResults.size());
        assertEquals(2, searchResults.get(0).getId());
    }
}
