package com.epam.automation.fundamentals;

import java.util.Scanner;

public class DataTypes1 {

    public static void main(String[] args) {
        DataTypes1 object = new DataTypes1();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of array elements: ");
        int massiveCounter = scanner.nextInt();
        int array[] = new int[massiveCounter];
        System.out.println("Enter numbers one by one in column");

        for (int i = 0; i < massiveCounter; i++) {
            array[i] = scanner.nextInt();
        }

        for (int i = 0; i < array.length; i++) {
            int number = array[i];

            for (int j = i - 1; j >= 0; j--) {
                int leftNumber = array[j];

                if (object.getCountsOfDigits(number) < object.getCountsOfDigits(leftNumber)) {
                    array[j + 1] = leftNumber;
                    array[j] = number;
                } else {
                    break;
                }
            }
        }
        System.out.println("Length of the shortest number = " + object.getCountsOfDigits(array[0]));
        System.out.println("Length of the longest number = " + object.getCountsOfDigits(array[array.length - 1]));
    }

    public static int getCountsOfDigits(long number) {

       return String.valueOf(Math.abs(number)).length();
    }
}
