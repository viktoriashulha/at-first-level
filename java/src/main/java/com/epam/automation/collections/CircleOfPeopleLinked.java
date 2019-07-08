package com.epam.automation.collections;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CircleOfPeopleLinked {
    public static void main(String[] args) {
        List<Integer> circle = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of people");
        int number = scanner.nextInt();

        for (int i = 0; i < number; i++) {
            circle.add(i + 1);
        }

        int eachSecondMan = 0;
        for (int i = 0; i < number; i++) {
            if (circle.size() > 1) {
                eachSecondMan = (eachSecondMan + 1) % circle.size();
                circle.remove(eachSecondMan);
            }
        }
        System.out.println("Last person " + circle);
    }

}
