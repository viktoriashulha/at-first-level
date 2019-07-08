package com.epam.automation.threads;

import java.util.LinkedList;

public class Runner {
    public static void main(String[] args) {
        LinkedList<CarPlace> carPlaceList = new LinkedList<>();
        carPlaceList.add(new CarPlace(1));
        carPlaceList.add(new CarPlace(2));
        carPlaceList.add(new CarPlace(3));

        startThread(carPlaceList);
    }

    public static void startThread(LinkedList<CarPlace> carPlaceList){
        Parking parking = new Parking(carPlaceList);
        for (int i = 1; i < 10; i++) {
            Car car = new Car(parking);
            car.start();
        }
    }
}
