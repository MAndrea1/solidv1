package com.example.model.factory;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @EqualsAndHashCode
public class HomeAppliance extends Product {
    private String color;
    private String model;
    private String brand;

    public HomeAppliance(int id) {
        super(id);
        super.setType("Home Appliance");
    }

    @Override
    public String[] getAttributes() {
        return new String[]{getColor(), getModel(), getBrand()};
    }

    @Override
    public String[] getAttributesHeader() {
        return new String[]{"Color", "Model", "Brand"};
    }

    //For mocking the database and testing
    public HomeAppliance(int id, String name, double price, String color, String model, String brand) {
        super(id);
        super.setName(name);
        super.setPrice(price);
        this.color = color;
        this.model = model;
        this.brand = brand;
        super.setType("Home Appliance");
    }

}
