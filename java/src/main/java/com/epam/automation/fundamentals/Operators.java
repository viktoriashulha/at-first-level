package com.epam.automation.fundamentals;

import java.util.Scanner;

public class Operators {
    public static void main(String[] args) {
        System.out.println("Enter the number");
        Scanner scanner = new Scanner(System.in);
        int numberFromConsole = scanner.nextInt();
        System.out.print("Month - ");
        System.out.println(monthName(numberFromConsole));
    }

    public static String  monthName(int number){
        switch (number){
            case 1: return "January";

            case 2: return "February";

            case 3: return "March";

            case 4: return "April";

            case 5: return "May";

            case 6: return "June";

            case 7:return "July";

            case 8: return "August";

            case 9: return "September";

            case 10: return "October";

            case 11: return "November";

            case 12: return "December";

        } return "Wrong number";
    }
}
