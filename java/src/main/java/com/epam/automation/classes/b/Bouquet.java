package com.epam.automation.classes.b;

import java.util.ArrayList;
import java.util.Comparator;

public  class Bouquet{

    private ArrayList<Flower> flowers = new ArrayList<>();
    private ArrayList<Accessory> accessories = new ArrayList<>();

    public void fillBouquet(int rose, int iris, int mimosa, boolean wrapper, boolean ribbon){
        for (int i = 0; i < rose; i++) {
            flowers.add(new Rose());
        }
        for (int i = 0; i < mimosa; i++) {
            flowers.add(new Mimosa());
        }
        for (int i = 0; i < iris; i++) {
            flowers.add(new Iris());
        }
        if (wrapper) {
            accessories.add(new Wrapper());
        }
        if (ribbon) {
            accessories.add(new Ribbon());
        }
    }


    @Override
    public String toString() {
        String bouqet = "My bouquet: ";
        for (int i = 0; i < flowers.size(); i++) {
            bouqet += flowers.get(i);
        }
        for (int i = 0; i < accessories.size(); i++) {
            bouqet += accessories.get(i);
        }
        return bouqet;
    }

    public ArrayList getFlowers() {
        return flowers;
    }

    public int getPrice() {
        int price = 0;
        for (int i = 0; i < flowers.size(); i++) {
            price += flowers.get(i).getPrice();
        }
        for (int i = 0; i < accessories.size(); i++) {
            price += accessories.get(i).getPrice();
        }
        return price;
    }

    public ArrayList sortFlowers() {
        for (int i = flowers.size() - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (flowers.get(j).getFreshness() > flowers.get(j + 1).getFreshness()) {
                    Flower temp = flowers.get(j);
                    flowers.set(j, flowers.get(j + 1));
                    flowers.set(j + 1, temp);
                }
            }
        }
        return flowers;
    }


    public String findStemLength(int minLength, int maxLength) {
        String result = "Length of stem: " + minLength + "-"  + maxLength + " cm \n";
        for (int i = 0; i < flowers.size(); i++) {
            if (flowers.get(i).getStemLength() >= minLength && flowers.get(i).getStemLength() <= maxLength) {
                result += flowers.get(i);
            }
        }
        return result;
    }

}

