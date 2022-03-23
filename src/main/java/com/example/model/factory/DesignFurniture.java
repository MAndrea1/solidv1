package com.example.model.factory;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @EqualsAndHashCode
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

    //For mocking the database and testing
    public DesignFurniture(int id, String name, double price, String color, String material) {
        super(id);
        super.setName(name);
        super.setPrice(price);
        this.color = color;
        this.material = material;
        super.setType("Design Furniture");
    }

}
