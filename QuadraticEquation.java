package me.ductrader.javapractice;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File f1 = new File("equation.in");
        if(!(f1.exists())) {
            try {
                f1.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        File f2 = new File("equation.out");
        if(!(f2.exists())) {
            try {
                f2.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            Scanner sc = new Scanner(f1);
            FileWriter writer = new FileWriter(f2);
            while(sc.hasNextLine()) {
                String s = sc.nextLine();
                String[] nums = s.split(" ");
                for(int k = 0; k < 3; k++) {
                    try {
                        Double.parseDouble(nums[k]);
                    } catch (NumberFormatException e) {
                        System.out.println("There's not a valid number here!");
                        System.exit(-1);
                    }
                }
                double a = Double.parseDouble(nums[0]); double b = Double.parseDouble(nums[1]); double c = Double.parseDouble(nums[2]);
                writer.write("Equation #1: ax^2 + bx + c - With a = " + a + ", b = " + b + ", c = " + c + "\n");
                double dt = b*b - 4*a*c;
                if(dt < 0) {
                    writer.write("This equation has no valid value!\n");
                } else if(dt == 0) {
                    writer.write("Equation has an equal root value of: " + (b*(-1)) / 2*a + "\n");
                } else if(dt > 0) {
                    double x1 = ((b*(-1)) + Math.sqrt(dt)) / (2*a);
                    double x2 = ((b*(-1)) - Math.sqrt(dt)) / (2*a);
                    writer.write("x1 = " + x1 + "\nx2 = " + x2 + "\n");
                }
            }
            writer.flush(); writer.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
