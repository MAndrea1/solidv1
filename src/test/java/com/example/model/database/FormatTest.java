package com.example.model.database;

import com.example.model.factory.HomeAppliance;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FormatTest {
    HomeAppliance testProduct = new HomeAppliance(1001, "Blender", 150.00, "Red", "BL01", "Lindell");
    Inventory testInventory = new Inventory();
    Format format = new Format();

    @Test
    public void testFormatProductShouldReturnProductFormattedString() {
        String output = format.formatProduct(testProduct);
        String model = "ID: \t1001\nName: \tBlender\nColor: \tRed\nModel: \tBL01\nBrand: \tLindell\nPrice: \t$150.0\n";

        assertEquals(model, output);
    }

    @Test
    public void testFormatInventoryShouldReturnInventoryFormattedString() {
        testInventory.removeAll();
        testInventory.addProduct(testProduct, 10);
        String output = format.formatInventory(testInventory);
        String model = "ID \t\tName\t\t\tPrice ($)\tStock\t\tDetails \n1001\tBlender     \t150.0\t\t10\t\t\tColor: Red      \tModel: BL01     \tBrand: Lindell  \t\n";
        assertEquals(model, output);
    }

}