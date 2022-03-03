package com.example.products;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class HomeAppliance extends Product {

    private String color;
    private String model;
    private String brand;

    public HomeAppliance(int id, String name, double price, String color, String model, String brand) {
        super(id, name, price);
        this.color = color;
        this.model = model;
        this.brand = brand;
    }

    @Override
    public String getDetailedData() {
        return getData() + "\nColor: " + color + "\nModel: " + model + "\nBrand: " + brand;
    }
}
