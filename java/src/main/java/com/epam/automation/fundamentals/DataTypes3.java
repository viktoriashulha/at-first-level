package com.epam.automation.fundamentals;

import java.util.Scanner;

public class DataTypes3 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = scn.nextLine();
        System.out.println("Welcome," + name +"!");
    }
}
