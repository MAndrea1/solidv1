package com.example.model.factory;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class DesignFurnitureTest {
    DesignFurniture designFurnitureFull = new DesignFurniture(2001, "Desk", 650.00, "Black", "Melamine");
    DesignFurniture designFurnitureIDOnly = new DesignFurniture(2002);

    @Test
    void getAttributesWithFull() {
        String[] equal = {"Black", "Melamine"};
        assertArrayEquals(equal, designFurnitureFull.getAttributes());
    }

    @Test
    void getAttributesWithIDOnly() {
        String[] equal = {null, null};
        assertArrayEquals(equal, designFurnitureIDOnly.getAttributes());
    }

    @Test
    void getAttributesHeaderWithFull() {
        String[] equal = {"Color", "Material"};
        assertArrayEquals(equal, designFurnitureFull.getAttributesHeader());
    }

    @Test
    void getAttributesHeaderWithIDOnly() {
        String[] equal = {"Color", "Material"};
        assertArrayEquals(equal, designFurnitureIDOnly.getAttributesHeader());
    }
}