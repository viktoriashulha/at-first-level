package com.epam.automation.classes.a;


import java.time.LocalDateTime;
import java.util.List;

public class Train {

    private String destinationPlace;
    private String trainNumber;
    private LocalDateTime timeDeparture;
    private List<Seat> seatList;

    public Train(String destinationPlace, String trainNumber, LocalDateTime timeDeparture, List<Seat> seatList) {
        this.destinationPlace = destinationPlace;
        this.trainNumber = trainNumber;
        this.timeDeparture = timeDeparture;
        this.seatList = seatList;
    }

    @Override
    public String toString() {
        return "Train{" +
                "destinationPlace='" + destinationPlace + '\'' +
                ", trainNumber='" + trainNumber + '\'' +
                ", timeDeparture=" + timeDeparture +
                ", seatList=" + seatList.toString() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Train train = (Train) o;

        if (destinationPlace != null ? !destinationPlace.equals(train.destinationPlace) : train.destinationPlace != null)
            return false;
        if (trainNumber != null ? !trainNumber.equals(train.trainNumber) : train.trainNumber != null) return false;
        if (timeDeparture != null ? !timeDeparture.equals(train.timeDeparture) : train.timeDeparture != null)
            return false;
        return seatList != null ? seatList.equals(train.seatList) : train.seatList == null;
    }

    @Override
    public int hashCode() {
        int result = destinationPlace != null ? destinationPlace.hashCode() : 0;
        result = 31 * result + (trainNumber != null ? trainNumber.hashCode() : 0);
        result = 31 * result + (timeDeparture != null ? timeDeparture.hashCode() : 0);
        result = 31 * result + (seatList != null ? seatList.hashCode() : 0);
        return result;
    }

    public String getDestinationPlace() {
        return destinationPlace;
    }

    public void setDestinationPlace(String destinationPlace) {
        this.destinationPlace = destinationPlace;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public LocalDateTime getTimeDeparture() {
        return timeDeparture;
    }

    public void setTimeDeparture(LocalDateTime timeDeparture) {
        this.timeDeparture = timeDeparture;
    }

    public List<Seat> getSeatList() {
        return seatList;
    }

    public void setSeatList(List<Seat> seatList) {
        this.seatList = seatList;
    }
}

