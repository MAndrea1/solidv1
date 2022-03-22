package com.example.model.factory;

import com.example.view.FactoryDialogue;

public abstract class FactorySetter {
    FactoryDialogue factoryDialogue = new FactoryDialogue();

    abstract void getName();
    abstract void getPrice();
    abstract void modifyAttributes();
    abstract public Product returnProduct();
}
