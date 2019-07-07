package com.epam.automation.fundamentals;

import java.util.Scanner;

public class DataTypes4 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите первое число: ");
        int firstNumber = scanner.nextInt();
        System.out.println("Введите второе число: ");
        int secondNumber = scanner.nextInt();
        System.out.println("Введите третье число: ");
        int thirdNumber = scanner.nextInt();
        int sum = firstNumber + secondNumber + thirdNumber;
        System.out.println("Cумма чисел:" + sum);

    }
}
