package com.example.model.factory;

import static org.junit.Assert.*;
import java.io.*;
import org.junit.*;

public class HomeApplianceSetterTest {
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
    public void homeApplianceSetterShouldPrintMenuAndAddAttributes() {
        setUpOutput();
        final String testString = "Floor Polisher\n1000.00\nDark Red\nModel01\nBranded";
        provideInput(testString);

        HomeApplianceSetter homeApplianceSetter = new HomeApplianceSetter(1000);

        String optionMenu = "Product name: \nProduct price: \nProduct color: \nProduct model: \nProduct brand: \n";

        assertEquals(optionMenu, getOutput().replaceAll("\r", ""));
        assertEquals("Floor Polisher", homeApplianceSetter.returnProduct().getName());
        assertEquals(String.valueOf(1000.00), String.valueOf(homeApplianceSetter.returnProduct().getPrice()));
        assertEquals("Dark Red", homeApplianceSetter.returnProduct().getAttributes()[0]);
        assertEquals("Model01", homeApplianceSetter.returnProduct().getAttributes()[1]);
        assertEquals("Branded", homeApplianceSetter.returnProduct().getAttributes()[1]);
        restoreSystemInputOutput();
    }

    @Test
    public void homeApplianceSetterShouldAcceptHomeAppliance() {
        HomeAppliance homeAppliance = new HomeAppliance(1001, "Blender", 150.00, "Red", "BL01", "Lindell");
        HomeApplianceSetter homeApplianceSetter = new HomeApplianceSetter(homeAppliance);

        assertEquals(homeAppliance, homeApplianceSetter.returnProduct());
    }

    @Test
    public void modifyAttributesShouldPrintMenuAndModifyAttributes() {
        setUpOutput();
        final String testString = "1\nNewName\n2\n9999.99\n3\nNewColor\n4\nNewModel\n5\nNewBrand\n0";
        provideInput(testString);

        HomeAppliance homeAppliance = new HomeAppliance(1001, "Blender", 150.00, "Red", "BL01", "Lindell");
        HomeApplianceSetter homeApplianceSetter = new HomeApplianceSetter(homeAppliance);
        homeApplianceSetter.modifyAttributes();

        assertEquals("NewName", homeApplianceSetter.returnProduct().getName());
        assertEquals(String.valueOf(9999.99), String.valueOf(homeApplianceSetter.returnProduct().getPrice()));
        assertEquals("NewColor", homeApplianceSetter.returnProduct().getAttributes()[0]);
        assertEquals("NewModel", homeApplianceSetter.returnProduct().getAttributes()[1]);
        assertEquals("NewBrand", homeApplianceSetter.returnProduct().getAttributes()[2]);
        assertEquals(homeAppliance, homeApplianceSetter.returnProduct());
        restoreSystemInputOutput();
    }

    @Test
    public void getNameShouldPrintMenuAndAddNameAttribute() {
        setUpOutput();
        final String testString = "NewName\n";
        provideInput(testString);

        HomeAppliance homeAppliance = new HomeAppliance(1001, "Blender", 150.00, "Red", "BL01", "Lindell");
        HomeApplianceSetter homeApplianceSetter = new HomeApplianceSetter(homeAppliance);
        homeApplianceSetter.getName();

        String optionMenu = "Product name: \n";

        assertEquals(optionMenu, getOutput().replaceAll("\r", ""));
        assertEquals("NewName", homeApplianceSetter.returnProduct().getName());
        restoreSystemInputOutput();
    }

    @Test
    public void getPriceShouldPrintMenuAndAddPriceAttribute() {
        setUpOutput();
        final String testString = "7777.77\n";
        provideInput(testString);

        HomeAppliance homeAppliance = new HomeAppliance(1001, "Blender", 150.00, "Red", "BL01", "Lindell");
        HomeApplianceSetter homeApplianceSetter = new HomeApplianceSetter(homeAppliance);
        homeApplianceSetter.getPrice();

        String optionMenu = "Product price: \n";

        assertEquals(optionMenu, getOutput().replaceAll("\r", ""));
        assertEquals(String.valueOf(7777.77), String.valueOf(homeApplianceSetter.returnProduct().getPrice()));
        restoreSystemInputOutput();
    }

    @Test
    public void getColorShouldPrintMenuAndAddColorAttribute() {
        setUpOutput();
        final String testString = "NewColor\n";
        provideInput(testString);

        HomeAppliance homeAppliance = new HomeAppliance(1001, "Blender", 150.00, "Red", "BL01", "Lindell");
        HomeApplianceSetter homeApplianceSetter = new HomeApplianceSetter(homeAppliance);
        homeApplianceSetter.getColor();

        String optionMenu = "Product color: \n";

        assertEquals(optionMenu, getOutput().replaceAll("\r", ""));
        assertEquals("NewColor", homeApplianceSetter.returnProduct().getAttributes()[0]);
        restoreSystemInputOutput();
    }

    @Test
    public void getModelrShouldPrintMenuAndAddModelAttribute() {
        setUpOutput();
        final String testString = "NewModel\n";
        provideInput(testString);

        HomeAppliance homeAppliance = new HomeAppliance(1001, "Blender", 150.00, "Red", "BL01", "Lindell");
        HomeApplianceSetter homeApplianceSetter = new HomeApplianceSetter(homeAppliance);
        homeApplianceSetter.getModel();

        String optionMenu = "Product model: \n";

        assertEquals(optionMenu, getOutput().replaceAll("\r", ""));
        assertEquals("NewModel", homeApplianceSetter.returnProduct().getAttributes()[1]);
        restoreSystemInputOutput();
    }

    @Test
    public void getBrandrShouldPrintMenuAndAddBrandAttribute() {
        setUpOutput();
        final String testString = "NewBrand\n";
        provideInput(testString);

        HomeAppliance homeAppliance = new HomeAppliance(1001, "Blender", 150.00, "Red", "BL01", "Lindell");
        HomeApplianceSetter homeApplianceSetter = new HomeApplianceSetter(homeAppliance);
        homeApplianceSetter.getBrand();

        String optionMenu = "Product brand: \n";

        assertEquals(optionMenu, getOutput().replaceAll("\r", ""));
        assertEquals("NewBrand", homeApplianceSetter.returnProduct().getAttributes()[2]);
        restoreSystemInputOutput();
    }
}