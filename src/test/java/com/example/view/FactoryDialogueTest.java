package com.example.view;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class FactoryDialogueTest {
    FactoryDialogue factoryDialogue = new FactoryDialogue();

    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    @Before
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

    @After
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    @Test
    public void testGetProductTypeShouldReturnValidInt() {
        final String testString = "1\n";
        provideInput(testString);

        assertEquals(1, factoryDialogue.getProductType());
    }

    @Test
    public void testGetProductTypeShouldRePrompt() {
        final String testString = "Two\n9\n1";
        provideInput(testString);

        assertEquals(1, factoryDialogue.getProductType());
    }

    @Test
    public void testModifyProductShouldPrintString() {
        factoryDialogue.modifyProduct(1, "attribute");
        String optionMenu = "1 - Modify attribute\n";

        assertEquals(optionMenu, getOutput().replaceAll("\r", ""));
    }

    @Test
    public void testChangeAttributeDialogueShouldReturnValidInt() {
        final String testString = "3\n";
        provideInput(testString);

        assertEquals(3, factoryDialogue.changeAttributeDialogue());
    }

    @Test
    public void testChangeAttributeDialogueShouldRePrompt() {
        final String testString = "Two\n2";
        provideInput(testString);

        assertEquals(2, factoryDialogue.changeAttributeDialogue());
    }

    @Test
    public void testNoValidOptionShouldPrintString() {
        factoryDialogue.noValidOption();
        String optionMenu = "Please choose a valid option\n";

        assertEquals(optionMenu, getOutput().replaceAll("\r", ""));
    }

    @Test
    public void testGetProductNameShouldReturnName() {
        final String testString = "NewName\n";
        provideInput(testString);

        assertEquals("NewName", factoryDialogue.getProductName());
    }

    @Test
    public void testGetProductPriceShouldReturnPrice() {
        final String testString = "100.00\n";
        provideInput(testString);

        assertEquals(100.00, factoryDialogue.getProductPrice(), 0);
    }

    @Test
    public void testGetProductColorShouldReturnColor() {
        final String testString = "NewColor\n";
        provideInput(testString);

        assertEquals("NewColor", factoryDialogue.getProductColor());
    }

    @Test
    public void testGetProductModelShouldReturnModel() {
        final String testString = "NewModel\n";
        provideInput(testString);

        assertEquals("NewModel", factoryDialogue.getProductModel());
    }

    @Test
    public void testGetProductModelShouldReturnMaterial() {
        final String testString = "NewMaterial\n";
        provideInput(testString);

        assertEquals("NewMaterial", factoryDialogue.getProductMaterial());
    }

    @Test
    public void testGetProductModelShouldReturnBrand() {
        final String testString = "NewBrand\n";
        provideInput(testString);

        assertEquals("NewBrand", factoryDialogue.getProductBrand());
    }
}