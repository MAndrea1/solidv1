package com.example.controller;

import com.example.model.CreateReport;
import com.example.model.SendMail;
import com.example.model.factory.FactoryController;
import com.example.model.factory.Product;
import com.example.view.FormatInventory;
import com.example.view.UserInterface;
import com.example.model.database.Inventory;
import com.example.view.CheckValid;

public class Controller implements Mediator{
    UserInterface userInterface;
    Inventory inventory;
    FactoryController factoryController;
    FormatInventory formatInventory;
    int productID;

    public Controller() {
        this.userInterface = new UserInterface(this);
        this.inventory = new Inventory();
        this.factoryController = new FactoryController();
        this.formatInventory = new FormatInventory(inventory);
        userInterface.start();
    }

    @Override
    public void notify(String sender, String event) {
        switch (sender) {
            case"showMenu":
                handleShowMenu(event);
                break;
            case"selectProduct":
                handleSelectProduct(event);
                break;
            default:
        }
        userInterface.mainMenu();
    }

    private void handleShowMenu(String event) {
        switch (event) {
            case "1":
                Product product = factoryController.startFactory();
                if (product == null) {
                    return;
                }
                inventory.addProduct(product, userInterface.enterQuantity());
                break;
            case "2":
                System.out.println(inventory.getAllInventory());
                break;
            case "3":
                int id = handleValidateID();
                if (id == 0) {
                    return;
                }
                productID = id;
                formatInventory.formatProduct(productID);
                userInterface.selectProduct();
                break;
            case "4":
                String filename = userInterface.generateReport();
                CreateReport.createReport(filename, inventory.getAllInventory());
                break;
            case "5":
                String[] data = userInterface.generateEmail().split(" ");
                int sent = SendMail.sendMail(CreateReport.createReport("report.pdf", inventory.getAllInventory()), data[0], data[1]);
                if (sent == -1) {
                    System.out.println("Email couldn't be sent. Please check username and password.");
                }
                if (sent == -2) {
                    System.out.println("Email couldn't be sent");
                }
                break;
            default:
                exit();
        }
        userInterface.mainMenu();
    }

    private void handleSelectProduct(String event) {
        switch (event) {
            case "1":
                int quantity = userInterface.enterQuantity();
                inventory.setProductStock(productID, quantity);
                userInterface.successful();
                userInterface.selectProduct();
                break;
            case "2":
                factoryController.modifyProduct(inventory.getProduct(productID));
                break;
            case "3":
                if (userInterface.confirm()) {
                    inventory.removeProduct(productID);
                    userInterface.successful();
                    return;
                }
            default:
                userInterface.mainMenu();
        }
        userInterface.selectProduct();
    }

    private int handleValidateID() {
        while (true) {
            int id = userInterface.validateIdUI();
            if(id == 0) {
                return 0;
            }
            if(inventory.validID(id)) {
                return id;
            }
            userInterface.validateIdUINeg(id);
        }
    }

    private void exit() {
        CheckValid.closeScanner();
        System.exit(0);
    }
}
