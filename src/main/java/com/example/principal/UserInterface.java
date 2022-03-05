package com.example.principal;

import com.example.products.Inventory;
import com.example.products.NewProduct;
import com.example.products.Product;
import com.example.utilidades.SendMail;

import javax.mail.MessagingException;
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
        System.out.println("1- Agregar nuevo producto al inventario");
        System.out.println("2- Mostrar todos los productos");
        System.out.println("3- Seleccionar producto");
        System.out.println("4- Generar archivo pdf");
        System.out.println("5- E-Mail");
        System.out.println("0- Salir");
    }
    
    public void start() {
        int option;
        do {
            mainMenu();
            option = Integer.parseInt(scanner.nextLine());
            switch (option){
                case 1:
                    addNewProduct();
                    break;
                case 2:
                    System.out.println(inventory.getAllInventory());
                    break;
                case 3:
                    selectProduct();
                    break;
                case 4:
                    generateReport();
                    break;
                case 5:
                    generateEmail();
                    break;
                case 0:
                    return;
                default:
                    break;
            }
        } while (option != 0);
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
        System.out.println("Product id:");
        int productID = Integer.parseInt(scanner.nextLine());
        System.out.println(inventory.getProduct(productID).getDetailedData());
        int option;

        while (true) {
            System.out.println("1- Change product stock");
            System.out.println("2- Update product data");
            System.out.println("3- Remove product from inventory");
            System.out.println("0- return to main menu");
            option = Integer.parseInt(scanner.nextLine());
            switch (option){
                case 1:
                    System.out.println("Quantity: " + inventory.getProductStock(productID));
                    System.out.print("New quantity:");
                    int newQuantity = Integer.parseInt(scanner.nextLine());
                    inventory.setProductStock(productID, newQuantity);
                    System.out.println("");
                    break;
                case 2:
                    inventory.getProduct(productID).setDetailedData(scanner);
                    break;
                case 3:
                    inventory.removeProduct(productID);
                    break;
                case 0:
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
            System.out.println("Password: ");
            String password = scanner.nextLine();

            File file = createReport("report.pdf", inventory.getAllInventory());
            sendMail(file, username, password);
        } catch (MessagingException e) {
            System.out.println("Email couldn't be sent");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
