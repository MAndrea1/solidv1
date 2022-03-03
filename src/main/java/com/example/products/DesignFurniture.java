package com.example.products;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DesignFurniture extends Product{

    private String color;
    private String material;

    public DesignFurniture(int id, String name, Double price, String color, String material) {
        super(id, name, price);
        this.color = color;
        this.material = material;
    }

    @Override
    public String getDetailedData() {
        return getData() + "\nColor: " + color + "\nMaterial: " + material;
    }
}
