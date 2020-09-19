
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
        System.out.print("Print negative or positive (p/n): ");
        String options = reader.nextLine();
        double output = 0;
        if(options.equalsIgnoreCase("p")) {
            output = inputs.stream()
                    .filter(str -> isNumeric(String.valueOf(str)) && Integer.parseInt(str) >= 0)
                    .mapToDouble(Integer::parseInt)
                    .average()
                    .getAsDouble();
            System.out.println("Average of all positive values: " + output);
        } else {
            output = inputs.stream()
                    .filter(str -> isNumeric(String.valueOf(str)) && Integer.parseInt(str) < 0)
                    .mapToDouble(Integer::parseInt)
                    .average()
                    .getAsDouble();
            System.out.println("Average of all negative values: " + output);
        }
    }
}
