package com.example.controller;

import com.example.model.CreateReport;
import com.example.model.SendMail;
import com.example.model.database.InventoryInt;
import com.example.model.factory.FactoryController;
import com.example.model.factory.Product;
import com.example.view.UserInterface;
import com.example.model.database.Inventory;
import com.example.model.database.Format;
import com.example.view.CheckValid;

import java.util.Arrays;

public class Controller implements Mediator{
    UserInterface userInterface;
    InventoryInt inventory;
    FactoryController factoryController;
    Format formatter;
    int productID;

    public Controller() {
        this.userInterface = new UserInterface(this);
        this.inventory = new Inventory();
        this.factoryController = new FactoryController();
        this.formatter = new Format();
    }

    public void start(){
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
                int id = handleNotValidID();
                if (id == 0) {return;}
                Product product = factoryController.startFactory(id);
                inventory.addProduct(product, userInterface.enterQuantity());
                break;
            case "2":
                userInterface.displayProduct(formatter.formatInventory((Inventory) inventory));
                break;
            case "3":
                int validID = handleValidID();
                if (validID == 0) {return;};
                productID = validID;
                userInterface.displayProduct(formatter.formatProduct(inventory.getProduct(productID)));
                userInterface.selectProduct();
                break;
            case "4":
                String filename = userInterface.generateReport();
                String content = formatter.formatInventory((Inventory) inventory);
                CreateReport.createReport(filename, content);
                break;
            case "5":
                String[] data = userInterface.generateEmail().split(" ");
                int sent = SendMail.sendMail(CreateReport.createReport("report.pdf", formatter.formatInventory((Inventory) inventory)), data[0], data[1]);
                userInterface.mailSendResult(sent);
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
                break;
            default:
                userInterface.mainMenu();
        }
        userInterface.selectProduct();
    }

    private int handleNotValidID() {
        while (true) {
            int id = userInterface.validateIdUI();
            if(id == 0) {return 0;}
            if(!inventory.validID(id)) {
                return id;
            }
            userInterface.validateIdRepeated(id);
        }
    }

    private int handleValidID() {
        while (true) {
            int id = userInterface.validateIdUI();
            if(id == 0) {return 0;}
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