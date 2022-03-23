package com.example.model.factory;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class HomeApplianceTest {
    HomeAppliance homeApplianceFull = new HomeAppliance(1001, "Blender", 150.00, "Red", "BL01", "Lindell");
    HomeAppliance homeApplianceIDOnly = new HomeAppliance(1002);

    @Test
    void getAttributesWithFull() {
        String[] equal = {"Red", "BL01", "Lindell"};
        assertArrayEquals(equal, homeApplianceFull.getAttributes());
    }

    @Test
    void getAttributesWithIDOnly() {
        String[] equal = {null, null, null};
        assertArrayEquals(equal, homeApplianceIDOnly.getAttributes());
    }

    @Test
    void getAttributesHeaderWithFull() {
        String[] equal = {"Color", "Model", "Brand"};
        assertArrayEquals(equal, homeApplianceFull.getAttributesHeader());
    }

    @Test
    void getAttributesHeaderWithIDOnly() {
        String[] equal = {"Color", "Model", "Brand"};
        assertArrayEquals(equal, homeApplianceIDOnly.getAttributesHeader());
    }


}