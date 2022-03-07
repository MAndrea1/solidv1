package com.example.products;

import com.example.utilidades.CheckValid;
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
    public void setDetailedData(Scanner scanner) {
        while (true) {
            System.out.println(getDetailedData());
            System.out.println("Data to change:");
            System.out.println("1- Name\n2- Price\n3- Color\n4- Material\n0- Exit");
            int option = Integer.parseInt(scanner.nextLine());
            switch (option) {
                case 0:
                    return;
                case 1:
                    System.out.print("Name: ");
                    setName(scanner.nextLine());
                    break;
                case 2:
                    System.out.print("Price: ");
                    setPrice(CheckValid.validDouble(scanner));
                    break;
                case 3:
                    System.out.print("Color: ");
                    setColor(scanner.nextLine());
                    break;
                case 4:
                    System.out.print("Material: ");
                    setMaterial(scanner.nextLine());
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }
}
