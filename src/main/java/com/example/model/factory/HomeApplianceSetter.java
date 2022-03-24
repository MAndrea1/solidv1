package com.example.model.factory;

public class HomeApplianceSetter extends FactorySetter{
    HomeAppliance homeAppliance;

    HomeApplianceSetter(int id) {
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
        homeAppliance.setName(factoryDialogue.getProductName());
    }

    @Override
    void getPrice() {
        homeAppliance.setPrice(factoryDialogue.getProductPrice());
    }

    public void getColor() {
        homeAppliance.setColor(factoryDialogue.getProductColor());
    }

    public void getModel() {
        homeAppliance.setModel(factoryDialogue.getProductModel());
    }

    public void getBrand() {
        homeAppliance.setBrand(factoryDialogue.getProductBrand());
    }

    @Override
    public Product returnProduct() {
        return homeAppliance;
    }
}
