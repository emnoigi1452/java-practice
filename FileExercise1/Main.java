package me.ductrader.javapractice;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class Main {
    public static int sum(int x) {
        int s = 0;
        for(int p = 0; p < 2 * x; p++) {
            if(p % 2 == 1) {
                s += (int)(Math.pow(p, 2));
            }
        }
        return s;
    }
    public static boolean checkNmr(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        File f = new File("C:\\Users\\Administrator\\Desktop\\test.txt");
        File f2 = new File("C:\\Users\\Administrator\\Desktop\\test2.txt");
        try {
            Scanner sc = new Scanner(f);
            FileWriter wr = new FileWriter(f2);
            while(sc.hasNextLine()) {
                String s1 = sc.nextLine();
                if(checkNmr(s1)) {
                    int i1 = Integer.parseInt(s1);
                    wr.write("Input: " + i1 + " - Output: " + sum(i1) + "\n");
                    wr.flush();
                    System.out.println("Line written, moving on...");
                } else {
                    System.out.println("Not an integer...skipping...");
                }
            }
            System.out.println("File has been modified, please check " + f2.getName() + " for outputs!");
            wr.close();
        } catch(IOException e) {
            System.out.println("An exception has occurred! " + e);
            System.exit(-1);
        }

    }
}