package com.epam.automation.collections;

import java.util.ArrayList;
import java.util.Scanner;

public class CircleOfPeople {
    public static void main(String[] args) {

        ArrayList<Integer> circle = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of people");
        int numberOfPeople = scanner.nextInt();
        for (int i = 0; i < numberOfPeople; i++) {
            circle.add(i + 1);
        }

        System.out.println("CircleOfPeople before " + circle);

        int eachSecondMan = 0;
        for (int i = 0; i < numberOfPeople; i++) {
            if (circle.size() > 1) {
                eachSecondMan = (eachSecondMan + 1) % circle.size();
                circle.remove(eachSecondMan);
            }
        }
        System.out.println("Last person " + circle);
    }
}






