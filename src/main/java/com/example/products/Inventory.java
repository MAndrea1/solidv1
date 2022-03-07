package com.example.products;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    //map to mock database
    Map<Product, Integer> inventoryList = new HashMap<>();
    Map<Integer, Product> catalogue = new HashMap<>();

    //Helper inner class to call single instance of the Inventory class
    private static class SingleInventory {
        public static final Inventory instance = new Inventory();
    }

    //Private constructor cannot be called from outside the class
    private Inventory() {
        //mock products
        addProduct(new HomeAppliance(1001, "Blender", 150.00, "Red", "BL01", "Lindell"), 40);
        addProduct(new HomeAppliance(1002, "Toaster", 50.00, "White", "TS50", "Frez&Co"), 20);
        addProduct(new HomeAppliance(1003, "Bread Maker", 350.00, "White", "BM101", "Lindell"), 30);
        addProduct(new HomeAppliance(1004, "Hand Mixer", 150.00, "Silver", "HM15", "Lindell"), 50);
        addProduct(new DesignFurniture(2001, "Desk", 650.00, "Black", "Melamine"), 5);
        addProduct(new DesignFurniture(2002, "Couch", 1500.00, "Brown", "Fabric"), 2);
    }

    //Public getInstance method to call the single instance from outside the class
    public static Inventory getInstance() {
        return SingleInventory.instance;
    }

    public Product getProduct(int id) {
        return catalogue.get(id);
    }

    public boolean validID(int id) {
        return catalogue.containsKey(id);
    }

    public void addProduct(Product product, int quantity) {
        inventoryList.put(product, quantity);
        catalogue.put(product.getId(), product);
    }

    public void removeProduct(int id) {
        Product product = catalogue.get(id);
        inventoryList.remove(product);
        catalogue.remove(id);
    }

    public void setProductStock(int id, int quantity) {
        Product product = catalogue.get(id);
        inventoryList.put(product, quantity);
    }

    public int getProductStock(int id) {
        Product product = catalogue.get(id);
        return inventoryList.get(product);
    }

    public String getAllInventory() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<Product, Integer> entry: inventoryList.entrySet()) {
            stringBuilder.append(entry.getKey().getData());
            stringBuilder.append("\nquantity: ");
            stringBuilder.append(entry.getValue());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

}

