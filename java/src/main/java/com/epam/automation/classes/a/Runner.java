package com.epam.automation.classes.a;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Runner {

    private static List<Train> trains = new ArrayList<>();
    private String destination;


    public static void main(String[] args) {
        Runner runner = new Runner();
        createTrains();
        runner.processUserInput();
    }

    public static void createTrains() {
        List<Seat> minskToOdessaTrainSeatList = new ArrayList<>();
        minskToOdessaTrainSeatList.add(new Seat(Seat.SeatClass.LUXURY));
        minskToOdessaTrainSeatList.add(new Seat(Seat.SeatClass.THIRD));
        Train minskToOdessa = new Train("Odessa", "MO666", LocalDateTime.now().plusDays(1), minskToOdessaTrainSeatList);

        List<Seat> minskToOdessaYesterdaySeatList = new ArrayList<>();
        minskToOdessaYesterdaySeatList.add(new Seat(Seat.SeatClass.SECOND));
        Train minskToOdessaYesterday = new Train("Odessa", "MO666", LocalDateTime.now().minusDays(1), minskToOdessaYesterdaySeatList);

        List<Seat> minskToMoscowTrainSeatList = new ArrayList<>();
        minskToMoscowTrainSeatList.add(new Seat(Seat.SeatClass.SECOND));
        Train minskToMoscow = new Train("Moscow", "MM211", LocalDateTime.now(), minskToMoscowTrainSeatList);

        List<Seat> minskToVilniusTrainSeatList = new ArrayList<>();
        minskToVilniusTrainSeatList.add(new Seat(Seat.SeatClass.THIRD));
        Train minkToVilnius = new Train("Vilnius", "MV345", LocalDateTime.now().plusDays(2), minskToVilniusTrainSeatList);

        trains.add(minskToOdessa);
        trains.add(minskToOdessaYesterday);
        trains.add(minskToMoscow);
        trains.add(minkToVilnius);
    }

    public List<Train> filterDestination() {
        TrainDispatcher trainDispatcher = new TrainDispatcher();
        List<Train> trainsToDestination = trainDispatcher.getTrainsWithSameDestination(trains, getDestination());
        return trainsToDestination;
    }

    public List<Train> filterSeats() {
        TrainDispatcher trainDispatcher = new TrainDispatcher();
        List<Seat> minskToOdessaTrainSeatList = new ArrayList<>();
        minskToOdessaTrainSeatList.add(new Seat(Seat.SeatClass.THIRD));
        List<Train> trainsToSeats = trainDispatcher.getTrainsWithSameSeats(trains, minskToOdessaTrainSeatList);
        return trainsToSeats;
    }

    public List<Train> filterDate() {
        TrainDispatcher trainDispatcher = new TrainDispatcher();
        List<Train> trainsWithSameData = trainDispatcher.getTrainsAfterDateTime(trains, LocalDateTime.now());
        return trainsWithSameData;
    }


    public void processUserInput() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose action: ");
            System.out.println("1 - Filter destination");
            System.out.println("2 - Filter seats");
            System.out.println("3 - Filter date");
            System.out.println("4 - Print all trains");
            System.out.println("5 - Exit");

            int command = scanner.nextInt();
            switch (command) {
                case 1:
                    System.out.println("Filtered destination:");
                    chooseDestinationFromConsole();
                    filterDestination();
                    printTrains(filterDestination());
                    break;
                case 2:
                    System.out.println("Filtered seats:");
                    filterSeats();
                    printTrains(filterSeats());
                    break;
                case 3:
                    System.out.println("Filtered date:");
                    filterDate();
                    printTrains(filterDate());
                    break;
                case 4:
                    printTrains(this.trains);
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong command");
            }
        }
    }

    public void chooseDestinationFromConsole(){
        System.out.println("Write destination");
        Scanner scanner1 = new Scanner(System.in);
        destination = scanner1.nextLine();
    }

    public void printTrains(List<Train> trains) {
        for (Train t : trains) {
            System.out.println(t.toString());
        }
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

}
