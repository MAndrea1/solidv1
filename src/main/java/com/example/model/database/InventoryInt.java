package com.example.model.database;

import com.example.model.factory.Product;

public interface InventoryInt {

    Product getProduct(int id);
    void addProduct(Product product, int quantity);
    void removeProduct(int id);

    void setProductStock(int id, int quantity);
    int getProductStock(int id);

    boolean validID(int id);
}
