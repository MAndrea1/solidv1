package com.example.view;

public class FactoryDialogue {

    public int getProductType() {
        while (true) {
        System.out.println("Which type of product you'd like to add?");
        System.out.println("1- Home Appliance");
        System.out.println("2- DesignFurniture");
        System.out.println("0- Return");
        int option = CheckValid.validInt();
        if(option >= 0 && option <= 2) {
            return option;
        }
        System.out.println("Please choose a valid option");
        }
    }

    public int changeAttributeDialogue() {
        System.out.println("Which attribute you'd like to change?\n0 to exit.");
        return CheckValid.validInt();
    }

    public void noValidOption() {
        System.out.println("Please choose a valid option");
    }

    public int getProductID() {
        System.out.println("Product id: ");
        return CheckValid.validInt();
    }

    public String getProductName() {
        System.out.println("Product name: ");
        return CheckValid.validString();
    }

    public void modifyProductName(int card){
        System.out.println(card + " - Modify name");
    }

    public double getProductPrice() {
        System.out.println("Product price: ");
        return CheckValid.validDouble();
    }

    public void modifyProductPrice(int card){
        System.out.println(card + " - Modify price");
    }

    public String getProductColor() {
        System.out.println("Product color: ");
        return CheckValid.validString();
    }

    public void modifyProductColor(int card){
        System.out.println(card + " - Modify color");
    }

    public String getProductModel() {
        System.out.println("Product model: ");
        return CheckValid.validString();
    }

    public void modifyProductModel(int card){
        System.out.println(card + " - Modify model");
    }

    public String getProductMaterial() {
        System.out.println("Product material: ");
        return CheckValid.validString();
    }

    public void modifyProductMaterial(int card){
        System.out.println(card + " - Modify material");
    }

    public String getProductBrand() {
        System.out.println("Product brand: ");
        return CheckValid.validString();
    }

    public void modifyProductBrand(int card){
        System.out.println(card + " - Modify brand");
    }
}
