package com.example.model.factory;

import com.example.model.factory.Product;
import com.example.view.CheckValid;
import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;

@Getter @Setter
public class DesignFurniture extends Product {

    private String color;
    private String material;

    public DesignFurniture(int id) {
        super(id);
        super.setType("Design Furniture");
    }

    //For mocking the database
    public DesignFurniture(int id, String name, double price, String color, String material) {
        super(id);
        super.setName(name);
        super.setPrice(price);
        this.color = color;
        this.material = material;
        super.setType("Design Furniture");
    }

    @Override
    public String getDetailedData() {
        return getData() + "\nColor: " + color + " - Material: " + material;
    }
//
//    @Override
//    public void setDetailedData(Scanner scanner) {
//        while (true) {
//            System.out.println(getDetailedData());
//            System.out.println();
//            System.out.println("Data to change:");
//            System.out.println("1- Name\n2- Price\n3- Color\n4- Material\n0- Exit");
//            String option = scanner.nextLine();
//            switch (option) {
//                case "0":
//                    return;
//                case "1":
//                    System.out.print("Name: ");
//                    setName(scanner.nextLine());
//                    break;
//                case "2":
//                    System.out.println("Price: ");
//                    setPrice(CheckValid.validDouble());
//                    break;
//                case "3":
//                    System.out.print("Color: ");
//                    setColor(scanner.nextLine());
//                    break;
//                case "4":
//                    System.out.print("Material: ");
//                    setMaterial(scanner.nextLine());
//                    break;
//                default:
//                    System.out.println("Invalid option");
//                    break;
//            }
//        }
//    }
}
