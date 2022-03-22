package com.example.view;

import com.example.model.database.Inventory;
import com.example.model.factory.Product;

public class FormatInventory {
    Inventory inventory;

    public FormatInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public void formatInventory() {
        inventory.getAllInventory();
    }

    public void formatProduct(int id) {
        Product product = inventory.getProduct(id);
    }
}
