package me.ductrader.javapractice;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class Main {
    public static String converter(int num) {
        int s = num % 60, m = (num % 3600) / 60, h = num / 3600;
        // Format
        String s1, m1, h1;
        if(s < 10) {
            s1 = "0" + s;
        } else {
            s1 = String.valueOf(s);
        }
        if(m < 10) {
            m1 = "0" + m;
        } else {
            m1 = String.valueOf(m);
        }
        if(h < 10) {
            h1 = "0" + h;
        } else {
            h1 = String.valueOf(h);
        }
        return "Converted time: " + h1 + "h " + m1 + "m " + s1 + "s";
    }

    public static void main(String[] args) {
        File f1 = new File("clock.in");
        File f2 = new File("clock.out");
        if(!(f1.exists())) {
            try {
                System.out.println("File doesn't exist, creating new empty file...");
                f1.createNewFile();
                System.out.println(f1.getName() + " has been generated!");
            } catch(IOException e) {
                System.out.println("An error occurred!");
                System.out.println("Information: ");
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        } else if(!(f2.exists())) {
            try {
                System.out.println("File doesn't exist, creating new empty file...");
                f2.createNewFile();
                System.out.println(f2.getName() + " has been generated!");
            } catch(IOException e) {
                System.out.println("An error occurred!");
                System.out.println("Information: ");
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        } else {
            try {
                Scanner sc = new Scanner(f1);
                FileWriter writer = new FileWriter(f2);
                while(sc.hasNextLine()) {
                    String s = sc.nextLine(); int i = 0;
                    try {
                        i = Integer.parseInt(s);
                    } catch(NumberFormatException n) {
                        System.out.println("This line doesn't contain an integer!");
                        System.out.println("Error log: ");
                        n.printStackTrace();
                    }
                    if(i < 0) {
                        System.out.println("Error! Value has to be larger than 1!");
                        System.out.println("Skipping this value...");
                    } else {
                        writer.write(converter(i));
                    }
                    writer.flush();
                    writer.close();
                }
            } catch(IOException e) {
                System.out.println("An error occurred!");
                System.out.println("Information: ");
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
