package com.epam.automation.threads;

public class Car extends Thread {

    private Parking parking;

    public Car(Parking parking) {
        this.parking = parking;
    }

    public void run() {

        CarPlace carPlace = null;
        try {
            carPlace = (CarPlace) parking.getResource(100);

            System.out.println("Car № " + this.getId() + " occupied place №" + carPlace.getNumberOfCarPlace());
            carPlace.using();
        } catch (ResourceException e) {
            System.out.println("Car № " + this.getId() + " stopped waiting" + e.getMessage());
        } finally {
            if (carPlace != null) {

                System.out.println("Car № " + this.getId() + " left place №" + carPlace.getNumberOfCarPlace());
                parking.returnResource(carPlace);
            }
        }
    }
}
