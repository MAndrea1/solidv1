package com.example.products;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;

@Getter
@Setter
public abstract class Product {

    //ID cannot be changed.
    @Setter(AccessLevel.NONE)
    private int id;

    private String name;
    private Double price;

    protected Product(int id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getData() {
        return "\n" + name + "\nID: " + id + " - Price: " + price;
    }

    @Override
    public String toString() {
        return "Product {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public abstract String getDetailedData();

    public abstract void setDetailedData(Scanner scanner);

}
