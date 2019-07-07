package com.epam.automation.threads;

public class CarPlace {

    private int numberOfCarPlace;

    public int getNumberOfCarPlace() {
        return numberOfCarPlace;
    }

    public void setNumberOfCarPlace(int numberOfCarPlace) {
        this.numberOfCarPlace = numberOfCarPlace;
    }

    public CarPlace(int numberOfCarPlace) {
        this.numberOfCarPlace = numberOfCarPlace;
    }

    public void using() {
        try {
            Thread.sleep(new java.util.Random().nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
