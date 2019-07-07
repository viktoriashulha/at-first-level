package com.epam.automation.classes.b;

import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class BouquetCreator {

    public static void main(String[] args) {

        Iris iris = new Iris();
        System.out.print("Iris - " + iris);

        Rose rose = new Rose();
        System.out.print("Rose - " + rose);

        Rose rose2 = new Rose();
        System.out.print("Rose - " + rose2);

        Mimosa mimosa = new Mimosa();
        System.out.print("Mimosa - " + mimosa);

        System.out.println("Choose action: ");
        System.out.println("1 - Create bouquet");
        System.out.println("2 - Sorting flowers by freshness");
        System.out.println("3 - Find flower by length of stem");
        System.out.println("4 - Exit");

        Scanner scanner = new Scanner(System.in);
        Bouquet bouquet = new Bouquet();
        bouquet.fillBouquet(3,2,1,true, true);

        while (true) {
            System.out.println("Action: ");
            int action = scanner.nextInt();
            switch (action) {
                case 1:
                    System.out.println(bouquet);
                    System.out.println("Bouquet price with accessory: " + bouquet.getPrice() + " $");
                    break;
                case 2:
                    System.out.println("Sorting flowers by freshness:");
                    bouquet.sortFlowers();
                    System.out.println(bouquet);
                    break;
                case 3:
                    System.out.println("Sorting flowers by length of stem:");
                    System.out.println(bouquet.findStemLength(15, 25));
                    break;
                case 4:
                    System.exit(0);
                    return;
                default :
                    System.out.println("Wrong action");
            }
        }
    }
}
