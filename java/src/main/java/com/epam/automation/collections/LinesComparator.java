package com.epam.automation.collections;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class LinesComparator implements Comparator<String> {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src\\main\\resources\\TextBeforeReverse.txt");
        Scanner scanner = new Scanner(file);
        ArrayList<String> text = new ArrayList<>();
        while (scanner.hasNextLine()) {
            text.add(scanner.nextLine());
        }
        Collections.sort(text);

        System.out.println(text);

    }

    @Override
    public int compare(String o1, String o2) {
        return o1.length()-o2.length();
    }
}
