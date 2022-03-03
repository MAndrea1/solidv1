package com.example.products;

import java.util.Scanner;

public class NewProduct {

    public static Product newProduct(Scanner scanner) {
        System.out.println("Which type of product you'd like to add?");
        System.out.println("1- Home Appliance");
        System.out.println("2- DesignFurniture");
        System.out.println("0- Return");
        int option = Integer.parseInt(scanner.nextLine());

        switch (option) {
            case 1:
                return createNewHomeAppliance(scanner);
            case 2:
                return createNewDesignFurniture(scanner);
            default:
                return null;
        }
    }

    private static Product createNewHomeAppliance(Scanner scanner) {
        System.out.println("Product name:");
        String name = scanner.nextLine();
        System.out.println("Product price");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Product id: ");
        int id = Integer.parseInt(scanner.nextLine());
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
        System.out.println("Product price");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Product id: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Product color: ");
        String color = scanner.nextLine();
        System.out.println("Product material: ");
        String material = scanner.nextLine();
        Product product = new DesignFurniture(id, name, price, color, material);
        return product;
    }
}
