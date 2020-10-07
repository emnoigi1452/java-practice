package me.ductrader.javapractice;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static boolean isNumeric(String param) {
        try {
            Integer.parseInt(param);
        } catch(NumberFormatException n) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        File f1 = new File("C:\\Users\\Administrator\\Desktop\\timso.in");
        File f2 = new File("C:\\Users\\Administrator\\Desktop\\timso.out");
        if(!f1.exists()) {
            System.out.println("File " + f1.getName() + " doesn't exist, creating new file...");
            try {
                f1.createNewFile();
                System.out.println("File " + f1.getName() + " is generated, please reload the program!");
            } catch(Exception e) {
                System.out.println("An error occurred!");
                System.out.println("Error code - " + e);
                System.exit(-1);
            }
        } else if(!f2.exists()) {
            System.out.println("File " + f2.getName() + " doesn't exist, creating new file...");
            try {
                f2.createNewFile();
                System.out.println("File " + f2.getName() + " is generated, please reload the program!");
            } catch(Exception e) {
                System.out.println("An error occurred!");
                System.out.println("Error code - " + e);
            }
        } else {
            try {
                Scanner sc = new Scanner(f1);
                FileWriter writer = new FileWriter(f2);
                List<Integer> list = new ArrayList<Integer>();
                boolean hasLines = false;
                while(sc.hasNextLine()) {
                    hasLines = true;
                    String s = sc.nextLine();
                    if(isNumeric(s)) {
                        int i = Integer.parseInt(s);
                        list.add(i);
                    } else {
                        System.out.println("Not a valid integer...skipping..");
                    }
                }
                if(hasLines) {
                    System.out.println("Identifying second largest value in array...");
                    int l1 = 0, l2 = 0;
                    for(Integer k: list) {
                        if(k > l1) {
                            l1 = k;
                        }
                    }
                    for(Integer k2: list) {
                        if(k2 > l2 && k2 < l1) {
                            l2 = k2;
                        }
                    }
                    writer.write("Second largest value: " + l2);
                    System.out.println("Second largest value in array identified! Saving file...");
                    writer.flush();
                    writer.close();
                } else {
                    System.out.println("The file " + f1.getName() + " is empty!");
                    System.out.println("You need to input the integers for the code to run!");
                }
            } catch(Exception e) {
                System.out.println("An error occurred!");
                System.out.println("Error code - " + e);
            }
        }
    }
}