package com.example.principal;

import com.example.products.Inventory;
import com.example.products.NewProduct;
import com.example.products.Product;
import com.example.utilidades.CheckValid;

import javax.mail.MessagingException;
import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import static com.example.utilidades.CreateRepoprt.createReport;
import static com.example.utilidades.SendMail.sendMail;

public class UserInterface {
    Inventory inventory;
    Scanner scanner;
    
    public UserInterface (Inventory inventory, Scanner scanner) {
        this.inventory = inventory;
        this.scanner = scanner;
    }

    static void mainMenu(){
        System.out.println("1- Add new product");
        System.out.println("2- Show all products");
        System.out.println("3- Select product");
        System.out.println("4- Generate report");
        System.out.println("5- E-Mail report");
        System.out.println("0- Exit");
    }
    
    public void start() {
        System.out.println("  --- Welcome ---");
        System.out.println("Please choose an option.");
        System.out.println();
        String option;
        while (true) {
            mainMenu();
            option = scanner.nextLine();
            switch (option){
                case "1":
                    addNewProduct();
                    break;
                case "2":
                    System.out.println(inventory.getAllInventory());
                    break;
                case "3":
                    selectProduct();
                    break;
                case "4":
                    generateReport();
                    break;
                case "5":
                    generateEmail();
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Please choose again");
                    break;
            }
        }
    }

    private void addNewProduct(){
        Product product = NewProduct.newProduct(scanner);
        if (product != null) {
            System.out.println("Enter quantity:");
            int quantity = Integer.parseInt(scanner.nextLine());
            inventory.addProduct(product, quantity);
        }
    }

    private void selectProduct() {
        int productID = CheckValid.validInt(scanner, "Product id: ");
        if (!inventory.validID(productID)) {
            System.out.println("Product not found.\n");
            return;
        }
        while (true) {
            System.out.println(inventory.getProduct(productID).getDetailedData());
            System.out.println("Stock: " + inventory.getProductStock(productID) + "\n");
            System.out.println("1- Change product stock");
            System.out.println("2- Update product data");
            System.out.println("3- Remove product from inventory");
            System.out.println("0- return to main menu");
            String option = scanner.nextLine();
            switch (option){
                case "1":
                    System.out.println("Stock: " + inventory.getProductStock(productID));
                    int newQuantity = CheckValid.validInt(scanner, "New quantity: ");
                    inventory.setProductStock(productID, newQuantity);
                    break;
                case "2":
                    inventory.getProduct(productID).setDetailedData(scanner);
                    break;
                case "3":
                    inventory.removeProduct(productID);
                    System.out.println("Product " + productID + " removed.\n");
                    return;
                case "0":
                    return;
                default:
                    break;
            }
        }
    }

    private void generateReport() {
        System.out.println("Write file name: ");
        String filename = scanner.nextLine() + ".pdf";
        createReport(filename, inventory.getAllInventory());
        System.out.println("File created");
    }

    private void generateEmail() {
        try {
            System.out.println("Username: ");
            String username = scanner.nextLine();

            //doesn't work in IDE
            Console console = System.console();
            char[] ch = console.readPassword("Password : ");
            String password = String.valueOf(ch);

            //For testing in IDE
//            System.out.println("Password: ");
//            String password = scanner.nextLine();

            File file = createReport("report.pdf", inventory.getAllInventory());
            sendMail(file, username, password);
        } catch (MessagingException e) {
            System.out.println("Email couldn't be sent. Please check your username and password.");
        } catch (IOException e) {
            System.out.println("Email couldn't be sent");
        }
    }
}
