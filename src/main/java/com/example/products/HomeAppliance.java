package com.example.products;

import com.example.utilidades.CheckValid;
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
        return getData() + "\nColor: " + color + " - Model: " + model + " - Brand: " + brand;
    }

    @Override
    public void setDetailedData(Scanner scanner) {
        while (true) {
            System.out.println(getDetailedData());
            System.out.println();
            System.out.println("Data to change:");
            System.out.println("1- Name\n2- Price\n3- Color\n4- Model\n5- Brand\n0- Exit");
            String option = scanner.nextLine();
            switch (option) {
                case "0":
                    return;
                case "1":
                    System.out.print("Name: ");
                    setName(scanner.nextLine());
                    break;
                case "2":
                    setPrice(CheckValid.validDouble(scanner, "Price: "));
                    break;
                case "3":
                    System.out.print("Color: ");
                    setColor(scanner.nextLine());
                    break;
                case "4":
                    System.out.print("Model: ");
                    setModel(scanner.nextLine());
                    break;
                case "5":
                    System.out.print("Brand: ");
                    setBrand(scanner.nextLine());
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }
}
