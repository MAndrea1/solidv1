package com.example.principal;

import com.example.products.Inventory;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Inventory inventory = Inventory.getInstance();
        Scanner scanner = new Scanner(System.in);

        UserInterface userInterface = new UserInterface(inventory, scanner);
        userInterface.start();
    }
}
