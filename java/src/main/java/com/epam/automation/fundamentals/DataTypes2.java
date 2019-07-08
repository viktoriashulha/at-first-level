package com.epam.automation.fundamentals;

import java.util.ArrayList;
import java.util.List;

public class DataTypes2 {

    public static void main(String[] args) {
        List<Integer> arrayList = getArrayFromInt(2112);
        System.out.println(isPalindrome(arrayList));
    }

    public static List<Integer> getArrayFromInt(int number) {
        List arrayList = new ArrayList();
        while (number >= 10) {
            arrayList.add(number % 10);
            number = number / 10;
        }
        arrayList.add(number);

        return arrayList;
    }

    public static boolean isPalindrome(List<Integer> arrayList) {
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (!(arrayList.get(i) == arrayList.get(size - i - 1))) {
                return false;
            }
        }
        return true;
    }


}



