package com.example.products;

import com.example.utilidades.CheckValid;

import java.util.Scanner;

public class NewProduct {

    private NewProduct() {}

    public static Product newProduct(Scanner scanner) {

        while (true) {
            System.out.println("Which type of product you'd like to add?");
            System.out.println("1- Home Appliance");
            System.out.println("2- DesignFurniture");
            System.out.println("0- Return");
            String option = scanner.nextLine();

            switch (option) {
                case "0":
                    return null;
                case "1":
                    return createNewHomeAppliance(scanner);
                case "2":
                    return createNewDesignFurniture(scanner);
                default:
                    System.out.println("Please choose again.");
            }
        }
    }

    private static Product createNewHomeAppliance(Scanner scanner) {
        System.out.println("Product name:");
        String name = scanner.nextLine();

        double price = CheckValid.validDouble(scanner);

        int id;
        while (true) {
            id = CheckValid.validInt(scanner);
            if (!Inventory.getInstance().validID(id)) {
                break;
            }
            System.out.println("this ID number already exists");
        }

        System.out.println("Product color: ");
        String color = scanner.nextLine();

        System.out.println("Product model: ");
        String model = scanner.nextLine();

        System.out.println("Product brand: ");
        String brand = scanner.nextLine();

        Product product = new HomeAppliance(id, name, price, color, model, brand);
        return product;
    }

    private static Product createNewDesignFurniture(Scanner scanner) {
        System.out.println("Product name:");
        String name = scanner.nextLine();

        double price = CheckValid.validDouble(scanner);

        int id;
        while (true) {
            id = CheckValid.validInt(scanner);
            if (!Inventory.getInstance().validID(id)) {
                break;
            }
            System.out.println("this ID number already exists");
        }

        System.out.println("Product color: ");
        String color = scanner.nextLine();

        System.out.println("Product material: ");
        String material = scanner.nextLine();

        Product product = new DesignFurniture(id, name, price, color, material);
        return product;
    }
}
