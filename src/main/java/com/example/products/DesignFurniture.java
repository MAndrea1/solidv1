package com.example.products;

import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;

@Getter @Setter
public class DesignFurniture extends Product{

    private String color;
    private String material;

    public DesignFurniture(int id, String name, Double price, String color, String material) {
        super(id, name, price);
        this.color = color;
        this.material = material;
    }

    @Override
    public String getDetailedData() {
        return getData() + "\nColor: " + color + "    - Material: " + material;
    }


    @Override
    public boolean setDetailedData(Scanner scanner) {
        System.out.println(getDetailedData());
        System.out.println("Data to change:");
        System.out.println("1- Name\n2- Price\n3- Color\n4- Material\n0- Exit");
        int option = Integer.parseInt(scanner.nextLine());
        switch (option) {
            case 0:
                return false;
            case 1:
                setName(scanner.nextLine());
                return true;
            case 2:
                setPrice(Double.parseDouble(scanner.nextLine()));
                return true;
            case 3:
                setColor(scanner.nextLine());
                return true;
            case 4:
                setMaterial(scanner.nextLine());
                return true;
            default:
                return false;
        }
    }
}
