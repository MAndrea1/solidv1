package com.example.model.database;

import com.example.model.factory.DesignFurniture;
import com.example.model.factory.HomeAppliance;
import com.example.model.factory.Product;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class InventoryTest {
    Inventory inventory = new Inventory();

    @Test
    public void testGetProductShouldReturnProductWithSameID() {
        assertEquals(1001, inventory.getProduct(1001).getId());
    }

    @Test
    public void testValidIDShouldReturnFalse() {
        assertEquals(false, inventory.validID(9999));
    }

    @Test
    public void testValidIDShouldReturnTrue() {
        assertEquals(true, inventory.validID(1004));
    }

    @Test
    public void testAddProductShouldAddProductToInventory() {
        HomeAppliance testHA = new HomeAppliance(8888, "TestProduct", 999.99, "TestColor", "TestModel", "TestBrand");
        inventory.addProduct(new HomeAppliance(8888, "TestProduct", 999.99, "TestColor", "TestModel", "TestBrand"), 999);

        assertEquals(testHA, inventory.getProduct(8888));
    }

    @Test
    public void testRemoveProductShouldRemoveProductFromInventory() {
        inventory.removeProduct(1004);
        assertEquals(false, inventory.validID(1004));
    }

    @Test
    public void testGetProductStockShouldReturnProductStock() {
        inventory.addProduct(new HomeAppliance(2222, "TestProduct", 999.99, "TestColor", "TestModel", "TestBrand"), 999);
        assertEquals(999, inventory.getProductStock(2222));
    }

    @Test
    public void testSetProductStockShouldChangeProductStock() {
        inventory.setProductStock(2222, 2);
        assertEquals(2, inventory.getProductStock(2222));
    }

    @Test
    public void testGetInventoryListShouldReturnInventoryList() {
        Map<Product, Integer> testList = new HashMap<>();
        testList.put(new HomeAppliance(1001, "Blender", 150.00, "Red", "BL01", "Lindell"), 40);
        testList.put(new HomeAppliance(1002, "Toaster", 50.00, "White", "TS50", "Frez&Co"), 20);
        testList.put(new HomeAppliance(1003, "Bread Maker", 350.00, "White", "BM101", "Lindell"), 30);
        testList.put(new HomeAppliance(1004, "Hand Mixer", 150.00, "Silver", "HM15", "Lindell"), 50);
        testList.put(new DesignFurniture(2001, "Desk", 650.00, "Black", "Melamine"), 5);
        testList.put(new DesignFurniture(2002, "Couch", 1500.00, "Brown", "Fabric"), 2);

        assertEquals(testList, inventory.getInventoryList());
    }

}