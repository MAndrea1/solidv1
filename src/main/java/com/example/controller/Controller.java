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
import org.apache.log4j.Logger;



public class Controller implements Mediator{
    private static Logger logger = Logger.getLogger(Controller.class);
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
        logger.debug("Starting Controller");
        userInterface.start();
    }

    @Override
    public void notify(String sender, String event) {
        logger.debug("Recived sender " + sender + ", event " + event);
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
        logger.debug("Handling ShowMenu options");
        switch (event) {
            case "1":
                logger.debug("Option 1: Add new product");
                int id = handleNotValidID();
                if (id == 0) {
                    logger.debug("Add new product cancelled by user");
                    return;}
                Product product = factoryController.startFactory(id);
                inventory.addProduct(product, userInterface.enterQuantity());
                break;
            case "2":
                logger.debug("Option 2: Show all products");
                userInterface.displayProduct(formatter.formatInventory((Inventory) inventory));
                break;
            case "3":
                logger.debug("Option 3: Select product");
                int validID = handleValidID();
                if (validID == 0) {
                    logger.debug("Select product cancelled by user");
                    return;};
                productID = validID;
                userInterface.displayProduct(formatter.formatProduct(inventory.getProduct(productID)));
                userInterface.selectProduct();
                break;
            case "4":
                logger.debug("Option 4: Generate report");
                String filename = userInterface.generateReport();
                String content = formatter.formatInventory((Inventory) inventory);
                CreateReport.createReport(filename, content);
                break;
            case "5":
                logger.debug("Option 5: E-mail report");
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
        logger.debug("Handling SelectProduct options");
        switch (event) {
            case "1":
                logger.debug("Option 1: Change product stock");
                int quantity = userInterface.enterQuantity();
                inventory.setProductStock(productID, quantity);
                userInterface.successful();
                userInterface.selectProduct();
                break;
            case "2":
                logger.debug("Option 2: Update product data");
                factoryController.modifyProduct(inventory.getProduct(productID));
                break;
            case "3":
                logger.debug("Option 3: Remove product from inventory");
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
        logger.debug("Exit program");
        CheckValid.closeScanner();
        System.exit(0);
    }
}