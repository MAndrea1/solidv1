package com.example.model.factory;

import com.example.view.FactoryDialogue;
import org.apache.log4j.Logger;

public class FactoryController {
    FactoryDialogue factoryDialogue;
    FactorySetter factorySetter;
    private static Logger logger = Logger.getLogger(FactoryController.class);

    public FactoryController() {
        this.factoryDialogue = new FactoryDialogue();
    }

    public Product startFactory(int id) {
        logger.debug("Starting Factory");
        int option = factoryDialogue.getProductType();
        if (option == 0) {
            logger.debug("Creation cancelled by user");
            return null;}
        switch (option) {
            case 1:
                logger.debug("Option 1: new Furniture");
                factorySetter = new FurnitureSetter(id);
                break;
            case 2:
                logger.debug("Option 2: new Home Appliance");
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
