package com.example.view;

import java.util.Scanner;

public final class CheckValid {
    static final Scanner scanner = new Scanner(System.in);

    private CheckValid() {}

    public static int validInt() {
        int i;
        while(true) {
            try {
                i = Integer.parseInt(scanner.nextLine());
                if (i >= 0) {
                    break;
                }
            }
            catch(NumberFormatException ex ) {
                System.out.println("Please enter a number");
            }
        }
        return i;
    }

    public static int validPositiveInt() {
        int i;
        while(true) {
            try {
                i = Integer.parseInt(scanner.nextLine());
                if(i >= 0){
                    break;
                }
            }
            catch(NumberFormatException ex ) {
                System.out.println("Please enter a non negative number");
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
            catch(NumberFormatException ex) {
                System.out.println("Please enter a number");
            }
        }
        return d;
    }

    public static String validString() {
        while (true) {
            String string = scanner.nextLine().trim();
            if (!string.equals("")) {
                return string;
            }
            System.out.println("Entry cannot be empty");
        }
    }

    public static boolean validBoolean() {
        while (true) {
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes")) {
                return true;
            } else if (answer.equalsIgnoreCase("n") || answer.equalsIgnoreCase("no")) {
                return false;
            } else {
                System.out.println("Invalid answer. Please answer yes (y) or no (n)");
            }
        }
    }

    public static void closeScanner() {
        scanner.close();
    }
}
