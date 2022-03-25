package com.example.model.factory;
import org.apache.log4j.Logger;

public class HomeApplianceSetter extends FactorySetter{
    HomeAppliance homeAppliance;
    private static Logger logger = Logger.getLogger(HomeApplianceSetter.class);

    HomeApplianceSetter(int id) {
        logger.debug("Creating new Home Appliance");
        this.homeAppliance = new HomeAppliance(id);
        getName();
        getPrice();
        getColor();
        getModel();
        getBrand();
    }

    HomeApplianceSetter(HomeAppliance homeAppliance) {
        this.homeAppliance = homeAppliance;
    }

    @Override
    void modifyAttributes() {
        logger.debug("Modifying attributes");
        while (true) {
            factoryDialogue.modifyProduct(1, "Name");
            factoryDialogue.modifyProduct(2, "Price");
            factoryDialogue.modifyProduct(3, "Color");
            factoryDialogue.modifyProduct(4, "Model");
            factoryDialogue.modifyProduct(5, "Brand");
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
                    getModel();
                    break;
                case 5:
                    getBrand();
                    break;
                default:
                    factoryDialogue.noValidOption();
            }
        }
    }

    @Override
    void getName() {
        logger.debug("Setting new Name");
        homeAppliance.setName(factoryDialogue.getProductName());
    }

    @Override
    void getPrice() {
        logger.debug("Setting new Price");
        homeAppliance.setPrice(factoryDialogue.getProductPrice());
    }

    public void getColor() {
        logger.debug("Setting new Color");
        homeAppliance.setColor(factoryDialogue.getProductColor());
    }

    public void getModel() {
        logger.debug("Setting new Model");
        homeAppliance.setModel(factoryDialogue.getProductModel());
    }

    public void getBrand() {
        logger.debug("Setting new Brand");
        homeAppliance.setBrand(factoryDialogue.getProductBrand());
    }

    @Override
    public Product returnProduct() {
        logger.debug("Returning Home Appliance");
        return homeAppliance;
    }
}
