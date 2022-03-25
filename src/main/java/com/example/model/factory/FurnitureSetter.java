package com.example.model.factory;
import org.apache.log4j.Logger;

public class FurnitureSetter extends FactorySetter {
    DesignFurniture designFurniture;
    private static Logger logger = Logger.getLogger(FurnitureSetter.class);


    FurnitureSetter(int id) {
        logger.debug("Creating new Design Furniture");
        this.designFurniture = new DesignFurniture(id);
        getName();
        getPrice();
        getColor();
        getMaterial();
    }

    FurnitureSetter(DesignFurniture designFurniture) {
        this.designFurniture = designFurniture;
    }

    @Override
    void modifyAttributes() {
        while (true) {
            factoryDialogue.modifyProduct(1, "Name");
            factoryDialogue.modifyProduct(2, "Price");
            factoryDialogue.modifyProduct(3, "Color");
            factoryDialogue.modifyProduct(4, "Material");
            int option = factoryDialogue.changeAttributeDialogue();
            switch (option) {
                case 0:
                    return;
                case 1:
                    getName();
                    break;
                case 2:
                    getPrice();
                    break;
                case 3:
                    getColor();
                    break;
                case 4:
                    getMaterial();
                    break;
                default:
                    factoryDialogue.noValidOption();
            }
        }
    }

    @Override
    public void getName() {
        logger.debug("Setting new Name");
        designFurniture.setName(factoryDialogue.getProductName());
    }

    @Override
    public void getPrice() {
        logger.debug("Setting new Price");
        designFurniture.setPrice(factoryDialogue.getProductPrice());
    }

    public void getColor() {
        logger.debug("Setting new Color");
        designFurniture.setColor(factoryDialogue.getProductColor());
    }

    public void getMaterial() {
        logger.debug("Setting new Material");
        designFurniture.setMaterial(factoryDialogue.getProductMaterial());
    }

    @Override
    public Product returnProduct() {
        logger.debug("Returning Design Furniture");
        return designFurniture;
    }
}
