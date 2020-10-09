package me.ductrader.javapractice;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        File f = new File("prime.in");
        File f2 = new File("prime.out");
        if(!(f.exists())) {
            try {
                f.createNewFile();
            } catch(Exception e) {
                System.out.println("Error!");
            }
        } else if(!(f2.exists())) {
            try {
                f2.createNewFile();
            } catch(Exception e) {
                System.out.println("Error!");
            }
        } else {
            try {
                Scanner sc = new Scanner(f);
                FileWriter writer = new FileWriter(f2);
                while(sc.hasNextLine()) {
                    String s = sc.nextLine();
                    int i = 0;
                    try {
                        i = Integer.parseInt(s);
                    } catch(NumberFormatException e) {
                        System.out.println("Error!");
                        System.exit(-1);
                    }
                    boolean isPrime = true;
                    if(i < 2) {
                        writer.write("false");
                        writer.flush();
                        writer.close();
                    } else {
                        for(int k = 2; k < i; k++) {
                            if(i % k == 0) {
                                writer.write("false");
                                writer.flush();
                                writer.close();
                                break;
                            }
                        }
                        writer.write("true");
                        writer.flush();
                        writer.close();
                    }
                }
            } catch(IOException e) {
                System.out.println("Error!");
            }
        }
    }
}
