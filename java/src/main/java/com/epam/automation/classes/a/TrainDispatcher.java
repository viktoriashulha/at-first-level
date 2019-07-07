package com.epam.automation.classes.a;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TrainDispatcher {
    List<Train> filteredTrains = new ArrayList<>();

    public List<Train> getTrainsWithSameDestination(List<Train> trains, String destination){
        filteredTrains.clear();
        for (Train train: trains) {
            if (train.getDestinationPlace().equalsIgnoreCase(destination)){
                filteredTrains.add(train);
            }
        }
        return filteredTrains;
    }

    public List<Train> getTrainsAfterDateTime(List<Train> trains, LocalDateTime time){
        filteredTrains.clear();
        for (Train train: trains) {
            if (train.getTimeDeparture().isAfter(time)){
                filteredTrains.add(train);
            }
        }
        return filteredTrains;
    }

    public List<Train> getTrainsWithSameSeats(List<Train> trains, List<Seat> seat){

        filteredTrains.clear();
        for (Train train: trains) {
            if (train.getSeatList().equals(seat)){
                filteredTrains.add(train);
            }
        }
        return filteredTrains;
    }
}
