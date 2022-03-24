package com.example.view;

import com.example.model.factory.DesignFurniture;
import com.example.model.factory.FurnitureSetter;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class CheckValidTest {

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
    public void testValidIntShouldPromptForNumberAndReturnIt() {
        setUpOutput();
        final String testString = "8\n";
        provideInput(testString);

        assertEquals(8, CheckValid.validInt());
        restoreSystemInputOutput();
    }

    @Test
    public void testValidIntWithStringInputShouldCatchErrorAndRePrompt() {
        setUpOutput();
        final String testString = "ocho\nOCHO\n8\n";
        provideInput(testString);

        assertEquals(8, CheckValid.validInt());
        restoreSystemInputOutput();
    }

    @Test
    public void testValidIPositiveIntShouldPromptForNumberAndReturnIt() {
        setUpOutput();
        final String testString = "8\n";
        provideInput(testString);

        assertEquals(8, CheckValid.validPositiveInt());
        restoreSystemInputOutput();
    }

    @Test
    public void testValidPositiveIntWithStringInputShouldCatchErrorAndRePrompt() {
        setUpOutput();
        final String testString = "Ocho\nOCHO\n8\n";
        provideInput(testString);

        assertEquals(8, CheckValid.validPositiveInt());
        restoreSystemInputOutput();
    }

    @Test
    public void testValidPositiveIntWithNegativeInputShouldRePrompt() {
        setUpOutput();
        final String testString = "-8\n-8\n8\n";
        provideInput(testString);

        assertEquals(8, CheckValid.validPositiveInt());
        restoreSystemInputOutput();
    }

    @Test
    public void testValidDoubleShouldPromptForNumberAndReturnIt() {
        setUpOutput();
        final String testString = "8.8\n";
        provideInput(testString);

        assertEquals(8.8, CheckValid.validDouble(), 0);
        restoreSystemInputOutput();
    }

    @Test
    public void testValidDoubleWithStringInputShouldCatchErrorAndRePrompt() {
        setUpOutput();
        final String testString = "Ocho\nOCHO\n8.8\n";
        provideInput(testString);

        assertEquals(8.8, CheckValid.validDouble(), 0);
        restoreSystemInputOutput();
    }

    @Test
    public void testValidStringShouldPromptForStringAndReturnIt() {
        setUpOutput();
        final String testString = "AString\n";
        provideInput(testString);

        assertEquals("AString", CheckValid.validString());
        restoreSystemInputOutput();
    }

    @Test
    public void testValidStringWithEmptyInputShouldPromptForStringAndRePrompt() {
        setUpOutput();
        final String testString = "\n \n    \nAString\n";
        provideInput(testString);

        assertEquals("AString", CheckValid.validString());
        restoreSystemInputOutput();
    }

    @Test
    public void testValidBooleanShouldPromptForBooleanAndReturnTrue() {
        setUpOutput();
        final String testString = "YES\n";
        provideInput(testString);

        assertEquals(true, CheckValid.validBoolean());
        restoreSystemInputOutput();
    }

    @Test
    public void testValidBooleanShouldPromptForBooleanAndReturnFalse() {
        setUpOutput();
        final String testString = "n\n";
        provideInput(testString);

        assertEquals(false, CheckValid.validBoolean());
        restoreSystemInputOutput();
    }

    @Test
    public void testValidBooleanShouldPromptForBooleanAndRePrompt() {
        setUpOutput();
        final String testString = "Si\n1\nok\nYes\n";
        provideInput(testString);

        assertEquals(true, CheckValid.validBoolean());
        restoreSystemInputOutput();
    }

}