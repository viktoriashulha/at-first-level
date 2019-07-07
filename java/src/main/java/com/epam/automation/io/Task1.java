package com.epam.automation.io;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class Task1 implements Comparator<String> {
    public static void main(String[] args) {
        final String lineSeparator = "\n";

        try (FileWriter writer = new FileWriter("src\\main\\resources\\Task1", false)) {
            ArrayList<Integer> numbers = new ArrayList<>();
            Random randomNumber = new Random();

            for (int i = 0; i < 10; i++) {
                int generate = randomNumber.nextInt(1000);
                numbers.add(generate);
            }

            writer.write(String.valueOf(numbers));
            Collections.sort(numbers);
            writer.write(lineSeparator);
            writer.write(String.valueOf(numbers));

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    @Override
    public int compare(String o1, String o2) {
        return o1.compareTo(o2);
    }
}
