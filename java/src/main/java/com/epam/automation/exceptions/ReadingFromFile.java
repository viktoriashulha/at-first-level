package com.epam.automation.exceptions;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadingFromFile {
    private double averageOfNumbers;
    private String text;
    private List<Double> list = new ArrayList<>();

    File file = new File("src\\main\\resources\\FileForExceptions");

    public static void main(String[] args) {

        ReadingFromFile readFromFile = new ReadingFromFile();
        readFromFile.readNumbersFromFile();
        System.out.println("The sum of the numbers: " + readFromFile.countSumOfNumbers());
        System.out.println("The average value of the numbers: " + readFromFile.countAverageValueOfNumbers());
    }

    private void readNumbersFromFile() {

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while (true) {
                try {
                    if ((text = reader.readLine()) == null) break;
                    list.add(Double.parseDouble(text));
                } catch (OutOfMemoryError e) {
                    e.printStackTrace();
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public double countSumOfNumbers() {
        double sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        return sum;
    }

    public double countAverageValueOfNumbers() {
        try {
            if (list.size() == 0) {
                throw new EmptyFileException("Empty file");
            }
            averageOfNumbers = countSumOfNumbers() / list.size();
        } catch (EmptyFileException e) {
            e.printStackTrace();
        }
        return averageOfNumbers;
    }
}
