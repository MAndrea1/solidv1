package com.example.model.factory;

import com.example.view.FactoryDialogue;

public class FactoryController {
    FactoryDialogue factoryDialogue;
    FactorySetter factorySetter;

    public FactoryController() {
        this.factoryDialogue = new FactoryDialogue();
    }

    public Product startFactory() {
        int option = factoryDialogue.getProductType();
        if (option == 0) {return null;}
        int id = factoryDialogue.getProductID();
        switch (option) {
            case 1:
                factorySetter = new FurnitureSetter(id);
                break;
            case 2:
                factorySetter = new HomeApplianceSetter(id);
                break;
            default:
                return null;
        }
        return factorySetter.returnProduct();
    }

    public Product modifyProduct(Product product) {
        if (product.getType().equals("Home Appliance")) {
            factorySetter = new HomeApplianceSetter((HomeAppliance) product);
        }
        if (product.getType().equals("Furniture")) {
            factorySetter = new FurnitureSetter((DesignFurniture) product);
        }
        factorySetter.modifyAttributes();
        return factorySetter.returnProduct();
    }
}
