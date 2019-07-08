package com.epam.automation.io;

import java.io.*;
import java.util.ArrayList;

public class Task3 {

    public static void main(String[] args) {

        final String REGEX = " |\\.";
        File fileBefore = new File("src\\main\\resources\\Task2Before");
        File fileAfter = new File("src\\main\\resources\\Task3After");
        ArrayList<String> finalText = new ArrayList<>();
        String strLine;
        try {
            FileInputStream stream = new FileInputStream(fileBefore);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(stream));

            while ((strLine = bufferedReader.readLine()) != null) {
                String[] words = strLine.split(REGEX);

                for (String word : words) {
                    if (word.equals("public")) {
                        word = word.replace("public", "private");
                        finalText.add(word);
                    } else finalText.add(word);

                    try (FileWriter writer = new FileWriter(fileAfter)) {
                        writer.write(finalText.toString());
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
