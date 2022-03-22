package com.example.model.factory;

import com.example.model.factory.Product;
import com.example.view.CheckValid;
import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;

@Getter @Setter
public class DesignFurniture extends Product {

    private String color;
    private String material;

    public DesignFurniture(int id) {
        super(id);
        super.setType("Design Furniture");
    }

    @Override
    public String[] getAttributes() {
        return new String[]{getColor(), getMaterial()};
    }

    @Override
    public String[] getAttributesHeader() {
        return new String[]{"Color", "Material"};
    }

    //For mocking the database
    public DesignFurniture(int id, String name, double price, String color, String material) {
        super(id);
        super.setName(name);
        super.setPrice(price);
        this.color = color;
        this.material = material;
        super.setType("Design Furniture");
    }

}
