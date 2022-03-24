package com.example.view;

import com.example.controller.Controller;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class UserInterfaceTest {
    UserInterface userInterface = new UserInterface(new Controller());

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
    public void testGenerateReportShouldReturnReportName() {
        final String testString = "NewReportName\n";
        provideInput(testString);

        assertEquals("NewReportName.pdf", userInterface.generateReport());
    }

    @Test
    public void testGenerateEmailShouldReturnEmailData() {
        final String testString = "UserUsername\nUserPassword\n";
        provideInput(testString);

        assertEquals("UserUsername UserPassword", userInterface.generateEmail());
    }

    @Test
    public void testConfirmYShouldReturnTrue() {
        final String testString = "Y\n";
        provideInput(testString);

        assertEquals(true, userInterface.confirm());
    }

    @Test
    public void testConfirmShouldRePrompt() {
        final String testString = "0\nok\nn";
        provideInput(testString);

        assertEquals(false, userInterface.confirm());
    }

    @Test
    public void testEnterQuantityShouldReturnPositiveInt() {
        final String testString = "Positive\n-80\n8";
        provideInput(testString);

        assertEquals(8, userInterface.enterQuantity());
    }

    @Test
    public void testValidateIdUINegShouldPrintNotValidId() {
        userInterface.validateIdUINeg(8);
        String optionMenu = "8 is not a valid id\n";

        assertEquals(optionMenu, getOutput().replaceAll("\r", ""));
    }

    @Test
    public void testValidateIdRepeatedShouldPrintIdIsUsed() {
        userInterface.validateIdRepeated(8);
        String optionMenu = "8 is already being used\n";

        assertEquals(optionMenu, getOutput().replaceAll("\r", ""));
    }

    @Test
    public void testSuccessfulShouldPrintSuccessMessage() {
        userInterface.successful();
        String optionMenu = "Operation successful\n";

        assertEquals(optionMenu, getOutput().replaceAll("\r", ""));
    }

    @Test
    public void testDisplayProductShouldReturnString() {
        userInterface.displayProduct("Product to display");
        String optionMenu = "Product to display\n";

        assertEquals(optionMenu, getOutput().replaceAll("\r", ""));
    }

    @Test
    public void testMailSendResult0ShouldReturnSuccess() {
        userInterface.mailSendResult(0);
        String optionMenu = "Email sent successfully.\n";

        assertEquals(optionMenu, getOutput().replaceAll("\r", ""));
    }

    @Test
    public void testMailSendResult1ShouldReturnUserOrPassError() {
        userInterface.mailSendResult(-1);
        String optionMenu = "Email couldn't be sent. Please check username and password.\n";

        assertEquals(optionMenu, getOutput().replaceAll("\r", ""));
    }

    @Test
    public void testMailSendResult2ShouldReturnError() {
        userInterface.mailSendResult(-2);
        String optionMenu = "Email couldn't be sent.\n";

        assertEquals(optionMenu, getOutput().replaceAll("\r", ""));
    }

}