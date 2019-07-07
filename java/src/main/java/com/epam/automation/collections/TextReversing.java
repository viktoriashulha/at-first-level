package com.epam.automation.collections;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TextReversing {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src\\main\\resources\\TextBeforeReverse.txt");
        Scanner scanner = new Scanner(file);
        ArrayList<String> text = new ArrayList<>();
        while (scanner.hasNextLine()) {
            text.add(scanner.nextLine());
        }

        Collections.reverse(text);
        PrintWriter writer = new PrintWriter("src\\main\\resources\\TextAfterReverse.txt");

        for (int i = 0; i < text.size(); i++) {
            writer.println(text.get(i));
        }

        writer.close();

    }
}
