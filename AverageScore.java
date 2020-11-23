package me.ductrader.javapractice;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static double average(double[] hs1, double[] hs2, double[] hs3) {
        double totalValue = 0;
        for(Double i: hs1) {
            totalValue += i;
        }
        for(Double j: hs2) {
            totalValue += j*2;
        }
        for(Double y: hs3) {
            totalValue += y*3;
        }
        return totalValue / (hs1.length + (hs2.length * 2) + (hs3.length * 3));
    }

    public static boolean isNumeric(String param) {
        try {
            Double.parseDouble(param);
        } catch(NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        File f1 = new File("diem.in");
        File f2 = new File("diem.out");
        if(!(f1.exists())) {
            System.out.println("Cannot locate input file, generating a new one...");
            try {
                f1.createNewFile();
                System.out.println("File created!");
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
        if(!(f2.exists())) {
            System.out.println("Cannot locate output file, generating a new output file...");
            try {
                f2.createNewFile();
                System.out.println("File created!");
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
        try {
            Scanner sc = new Scanner(f1);
            PrintWriter wr = new PrintWriter(f2);
            double[] h1 = new double[20]; double[] h2 = new double[10]; double[] h3 = new double[2];
            main:
            for(int k = 0; k < 3; k++) {
                if(sc.hasNextLine()) {
                    String h = sc.nextLine();
                    double[] scores = new double[h.split(" ").length]; int index = 0;
                    if(k != 2) {
                            for(int z = 0; z < h.split(" ").length; z++) {
                            if(isNumeric(h.split(" ")[z]) && Double.parseDouble(h.split(" ")[z]) <= 10 &&
                                    Double.parseDouble(h.split(" ")[z]) >= 0) {
                                scores[index] = Double.parseDouble(h.split(" ")[z]); index++;
                            } else {
                                wr.write("Invalid scores!"); wr.flush(); wr.close(); break main;
                            }
                        }   
                    } else {
                        for(int x = 0; x < 2; x++) {
                            if(isNumeric(h.split(" ")[z]) && Double.parseDouble(h.split(" ")[z]) <= 10 &&
                                    Double.parseDouble(h.split(" ")[z]) >= 0) {
                                scores[index] = Double.parseDouble(h.split(" ")[z]); index++;
                            } else {
                                wr.write("Invalid scores!"); wr.flush(); wr.close(); break main;
                            }
                        }
                    }
                    switch (k) {
                        case 0 -> h1 = scores;
                        case 1 -> h2 = scores;
                        case 2 -> h3 = scores;
                    }
                } else {
                    wr.println("Not enough arguments created!");
                    wr.flush(); wr.close();
                    break;
                }
            }
            double avg = average(h1, h2, h3);
            wr.print("Average score: "); wr.printf("%.1f", avg);
            wr.flush(); wr.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
