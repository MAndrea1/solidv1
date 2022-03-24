package com.example.model.factory;

public class FurnitureSetter extends FactorySetter {
    DesignFurniture designFurniture;

    FurnitureSetter(int id) {
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
        designFurniture.setName(factoryDialogue.getProductName());
    }

    @Override
    public void getPrice() {
        designFurniture.setPrice(factoryDialogue.getProductPrice());
    }

    public void getColor() {
        designFurniture.setColor(factoryDialogue.getProductColor());
    }

    public void getMaterial() {
        designFurniture.setMaterial(factoryDialogue.getProductMaterial());
    }

    @Override
    public Product returnProduct() {
        return designFurniture;
    }
}
