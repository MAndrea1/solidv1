package com.example.model.factory;

import static org.junit.Assert.*;
import java.io.*;
import org.junit.*;

public class FurnitureSetterTest {
    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    private String getOutput() {
        return testOut.toString();
    }


    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    @Test
    public void furnitureSetterShouldPrintMenuAndAddAttributes() {
        setUpOutput();
        final String testString = "Rounded Table\n1000.00\nDark Brown\nOak";
        provideInput(testString);

        FurnitureSetter furnitureSetter = new FurnitureSetter(1000);

        String optionMenu = "Product name: \nProduct price: \nProduct color: \nProduct material: \n";

        assertEquals(optionMenu, getOutput().replaceAll("\r", ""));
        assertEquals("Rounded Table", furnitureSetter.returnProduct().getName());
        assertEquals(String.valueOf(1000.00), String.valueOf(furnitureSetter.returnProduct().getPrice()));
        assertEquals("Dark Brown", furnitureSetter.returnProduct().getAttributes()[0]);
        assertEquals("Oak", furnitureSetter.returnProduct().getAttributes()[1]);
        restoreSystemInputOutput();
    }

    @Test
    public void furnitureSetterShouldAcceptDesignFurniture() {
        DesignFurniture designFurniture = new DesignFurniture(2001, "Desk", 650.00, "Black", "Melamine");
        FurnitureSetter furnitureSetter = new FurnitureSetter(designFurniture);

        assertEquals(designFurniture, furnitureSetter.returnProduct());
    }

    @Test
    public void modifyAttributesShouldPrintMenuAndModifyAttributes() {
        setUpOutput();
        final String testString = "1\nNewName\n2\n9999.99\n3\nNewColor\n4\nNewMaterial\n0";
        provideInput(testString);

        DesignFurniture designFurniture = new DesignFurniture(2001, "Desk", 650.00, "Black", "Melamine");
        FurnitureSetter furnitureSetter = new FurnitureSetter(designFurniture);
        furnitureSetter.modifyAttributes();

        assertEquals("NewName", furnitureSetter.returnProduct().getName());
        assertEquals(String.valueOf(9999.99), String.valueOf(furnitureSetter.returnProduct().getPrice()));
        assertEquals("NewColor", furnitureSetter.returnProduct().getAttributes()[0]);
        assertEquals("NewMaterial", furnitureSetter.returnProduct().getAttributes()[1]);
        assertEquals(designFurniture, furnitureSetter.returnProduct());
        restoreSystemInputOutput();
    }

    @Test
    public void getNameShouldPrintMenuAndAddNameAttribute() {
        setUpOutput();
        final String testString = "NewName\n";
        provideInput(testString);

        DesignFurniture designFurniture = new DesignFurniture(2001, "Desk", 650.00, "Black", "Melamine");
        FurnitureSetter furnitureSetter = new FurnitureSetter(designFurniture);
        furnitureSetter.getName();

        String optionMenu = "Product name: \n";

        assertEquals(optionMenu, getOutput().replaceAll("\r", ""));
        assertEquals("NewName", furnitureSetter.returnProduct().getName());
        restoreSystemInputOutput();
    }

    @Test
    public void getPriceShouldPrintMenuAndAddPriceAttribute() {
        setUpOutput();
        final String testString = "7777.77\n";
        provideInput(testString);

        DesignFurniture designFurniture = new DesignFurniture(2001, "Desk", 650.00, "Black", "Melamine");
        FurnitureSetter furnitureSetter = new FurnitureSetter(designFurniture);
        furnitureSetter.getPrice();

        String optionMenu = "Product price: \n";

        assertEquals(optionMenu, getOutput().replaceAll("\r", ""));
        assertEquals(String.valueOf(7777.77), String.valueOf(furnitureSetter.returnProduct().getPrice()));
        restoreSystemInputOutput();
    }

    @Test
    public void getColorShouldPrintMenuAndAddColorAttribute() {
        setUpOutput();
        final String testString = "NewColor\n";
        provideInput(testString);

        DesignFurniture designFurniture = new DesignFurniture(2001, "Desk", 650.00, "Black", "Melamine");
        FurnitureSetter furnitureSetter = new FurnitureSetter(designFurniture);
        furnitureSetter.getColor();

        String optionMenu = "Product color: \n";

        assertEquals(optionMenu, getOutput().replaceAll("\r", ""));
        assertEquals("NewColor", furnitureSetter.returnProduct().getAttributes()[0]);
        restoreSystemInputOutput();
    }

    @Test
    public void getMaterialShouldPrintMenuAndAddMaterialAttribute() {
        setUpOutput();
        final String testString = "NewMaterial\n";
        provideInput(testString);

        DesignFurniture designFurniture = new DesignFurniture(2001, "Desk", 650.00, "Black", "Melamine");
        FurnitureSetter furnitureSetter = new FurnitureSetter(designFurniture);
        furnitureSetter.getMaterial();

        String optionMenu = "Product material: \n";

        assertEquals(optionMenu, getOutput().replaceAll("\r", ""));
        assertEquals("NewMaterial", furnitureSetter.returnProduct().getAttributes()[1]);
        restoreSystemInputOutput();
    }
}