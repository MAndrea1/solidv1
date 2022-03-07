package com.example.utilidades;

import java.util.Scanner;

public class CheckValid {

    public static int validInt(Scanner scanner) {
        int i;
        while(true) {
            try {
                System.out.println("Product id: ");
                i = Integer.parseInt(scanner.nextLine());
                break;
            }
            catch(NumberFormatException ex ) {
                System.out.println("Please enter a number");
            }
        }

        return i;
    }

    public static double validDouble(Scanner scanner) {
        double d;
        while(true) {
            try {
                System.out.println("Product price");
                d = Double.parseDouble(scanner.nextLine());
                break;
            }
            catch(NumberFormatException ex ) {
                System.out.println("Please enter a number");
            }
        }
        return d;
    }
}
