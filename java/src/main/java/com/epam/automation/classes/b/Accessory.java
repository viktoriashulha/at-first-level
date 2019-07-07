package com.epam.automation.classes.b;

public class Accessory {

    private int price;

    public Accessory(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Accessory prise: " + price + "$";
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}

