package com.example.products;

import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;

@Getter @Setter
public class HomeAppliance extends Product {

    private String color;
    private String model;
    private String brand;

    public HomeAppliance(int id, String name, double price, String color, String model, String brand) {
        super(id, name, price);
        this.color = color;
        this.model = model;
        this.brand = brand;
    }

    @Override
    public String getDetailedData() {
        return getData() + "\nColor: " + color + "    - Model: " + model + "    - Brand: " + brand;
    }

    @Override
    public boolean setDetailedData(Scanner scanner) {
        System.out.println(getDetailedData());
        System.out.println("Data to change:");
        System.out.println("1- Name\n2- Price\n3- Color\n4- Model\n5- Brand\n0- Exit");
        int option = Integer.parseInt(scanner.nextLine());
        switch (option) {
            case 0:
                return false;
            case 1:
                System.out.print("Name: ");
                setName(scanner.nextLine());
                return true;
            case 2:
                System.out.print("Price: ");
                setPrice(Double.parseDouble(scanner.nextLine()));
                return true;
            case 3:
                System.out.print("Color: ");
                setColor(scanner.nextLine());
                return true;
            case 4:
                System.out.print("Model: ");
                setModel(scanner.nextLine());
                return true;
            case 5:
                System.out.print("Brand: ");
                setBrand(scanner.nextLine());
                return true;
            default:
                return false;
        }
    }
}
