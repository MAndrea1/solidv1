package com.example.model.database;

import com.example.model.factory.Product;

import java.util.Map;

public class Format {
    static StringBuilder stringBuilder = new StringBuilder();

    public String formatProduct(Product product) {
        stringBuilder.setLength(0);
        stringBuilder.append("ID: \t");
        stringBuilder.append(product.getId());
        stringBuilder.append("\nName: \t");
        stringBuilder.append(product.getName());
        for (int i = 0; i < product.getAttributes().length; i++) {
            stringBuilder.append("\n");
            stringBuilder.append(product.getAttributesHeader()[i]);
            stringBuilder.append(": \t");
            stringBuilder.append(product.getAttributes()[i]);
        }
        stringBuilder.append("\nPrice: \t$");
        stringBuilder.append(product.getPrice());
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }

    public String formatInventory(Inventory inventory){
        stringBuilder.setLength(0);
        stringBuilder.append("ID ");
        stringBuilder.append("\t\tName");
        stringBuilder.append("\t\t\tPrice ($)");
        stringBuilder.append("\tStock");
        stringBuilder.append("\t\tDetails ");
        stringBuilder.append("\n");
        for (Map.Entry<Product, Integer> entry : inventory.getInventoryList().entrySet()) {
            stringBuilder.append(entry.getKey().getId());
            stringBuilder.append("\t");
            int space = 12 - entry.getKey().getName().length();
            String fill = new String(new char[Math.max(space, 0)]).replace("\0", " ");
            stringBuilder.append(entry.getKey().getName());
            stringBuilder.append(fill);
            stringBuilder.append("\t");
            stringBuilder.append(entry.getKey().getPrice());
            stringBuilder.append("\t\t");
            stringBuilder.append(entry.getValue());
            stringBuilder.append("\t\t\t");
            for (int i = 0; i < entry.getKey().getAttributes().length; i++) {
                stringBuilder.append(entry.getKey().getAttributesHeader()[i]);
                stringBuilder.append(": ");
                space = 9 - entry.getKey().getAttributes()[i].length();
                fill = new String(new char[Math.max(space, 0)]).replace("\0", " ");
                stringBuilder.append(entry.getKey().getAttributes()[i]);
                stringBuilder.append(fill);
                stringBuilder.append("\t");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}