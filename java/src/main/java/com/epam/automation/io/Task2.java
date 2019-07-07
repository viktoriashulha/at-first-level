package com.epam.automation.io;

import java.io.*;
import java.util.ArrayList;

public class Task2 {
    public static void main(String[] args) {

        final String REGEX = " |\\.";

        File fileBefore = new File("src\\main\\resources\\Task2Before");
        File fileAfter = new File("src\\main\\resources\\Task2After");
        ArrayList<String> result = new ArrayList<>();

        try {

            FileInputStream stream = new FileInputStream(fileBefore);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(stream));
            String strLine;
            while ((strLine = bufferedReader.readLine()) != null) {
                String[] words = strLine.split(REGEX);
                for (String word : words) {
                    if (word.length() >= 2) {
                        word = word.toUpperCase();
                        result.add(word);
                    } else result.add(word);

                    try (FileOutputStream stream1 = new FileOutputStream(fileAfter)) {
                        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(stream1));
                        writer.write(result.toString());
                        writer.close();
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }

                }
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
