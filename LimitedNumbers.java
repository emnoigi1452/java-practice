package me.ductrader.javapractice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static boolean betweenOneToFive(int num) {
        return num >= 1 && num <= 5;
    }
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<Integer>();
        Scanner read = new Scanner(System.in);
        while(true) {
            String s = read.nextLine();
            int sNum = 0;
            try {
                sNum = Integer.parseInt(s);
            } catch(NumberFormatException e) {
                System.out.println("Please input a valid integer!");
                System.out.println("Error caused by: " + e.getMessage());
                System.out.println("Ending process...");
                System.exit(-1);
            }
            if(sNum < 0) {
                break;
            }
            l.add(sNum);
        }
        System.out.println();
        l.stream()
                .filter(Main::betweenOneToFive)
                .forEach(System.out::println);
    }
}
