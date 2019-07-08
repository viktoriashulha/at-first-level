package com.epam.automation.collections;

import java.util.TreeSet;

public class NumberSorting implements Comparable<NumberSorting> {
    private int number;

    public NumberSorting(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public static void main(String[] args) {
        TreeSet<NumberSorting> array = new TreeSet<>() ;

        array.add(new NumberSorting(3));
        array.add(new NumberSorting(56));
        array.add(new NumberSorting(95));
        array.add(new NumberSorting(11));
        array.add(new NumberSorting(19));
        System.out.println(array);

    }

    @Override
    public int compareTo(NumberSorting o) {
        return number - o.number;
    }

    @Override
    public String toString() {
        return "number=" + number ;
    }
}
