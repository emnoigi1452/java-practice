package me.ductrader.javapractice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static boolean isNumeric(String num) {
        try {
            Integer.parseInt(num);
        } catch(NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        List<String> inputs = new ArrayList<String>();
        Scanner reader = new Scanner(System.in);

        System.out.println("Input numbers, press 'end' to finish: ");
        while(true) {
            String b = reader.nextLine();
            if(!(b.equalsIgnoreCase("end"))) {
                inputs.add(b);
            } else {
                break;
            }
        }
        double avg = inputs.stream()
                .filter(str -> isNumeric(String.valueOf(str)))
                .mapToDouble(Integer::parseInt)
                .average()
                .getAsDouble();
        System.out.println("Average: " + avg);
    }
}
