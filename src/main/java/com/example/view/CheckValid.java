package com.example.view;

import java.util.Scanner;

public class CheckValid {
    static Scanner scanner = new Scanner(System.in);

    public static int validInt() {
        int i;
        while(true) {
            try {
                i = Integer.parseInt(scanner.nextLine());
                break;
            }
            catch(NumberFormatException ex ) {
                System.out.println("Please enter a number");
            }
        }
        return i;
    }

    public static double validDouble() {
        double d;
        while(true) {
            try {
                d = Double.parseDouble(scanner.nextLine());
                break;
            }
            catch(NumberFormatException ex ) {
                System.out.println("Please enter a number");
            }
        }
        return d;
    }

    public static String validString() {
        return scanner.nextLine();
    }

    public static boolean validBoolean() {
        while (true) {
            String answer = scanner.nextLine();
            if (answer.equals("y") || answer.equals("yes")) {
                return true;
            } else if (answer.equals("n") || answer.equals("no")) {
                return false;
            } else {
                System.out.println("Invalid answer. Please answer yes (y) or no (n)");
            }
        }
    }

    public static void closeScanner() {
        scanner.close();
        return;
    }
}
