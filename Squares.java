package me.ductrader.javapractice;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static List<Integer> cpList(int limit) {
        List<Integer> l = new ArrayList<Integer>();
        for(int k = 0; (int)Math.pow(k, 2) <= limit; k++) {
            l.add((int)Math.pow(k, 2));
        }
        return l;
    }
    public static void main(String[] args) {
        File f1 = new File("cp.in");
        File f2 = new File("cp.out");
        if(!f1.exists()) {
            System.out.println(f1.getName() + " doesn't seem to exist, creating...");
            try {
                f1.createNewFile();
                System.out.println("File successfully generated!");
            } catch(IOException e) {
                System.out.println("An error occurred!");
                e.printStackTrace();
            }
        } else if(!f2.exists()) {
            System.out.println(f2.getName() + " doesn't seem to exist, creating...");
            try {
                f2.createNewFile();
                System.out.println("File successfully generated!");
            } catch(IOException e) {
                System.out.println("An error occurred!");
                e.printStackTrace();
            }
        } else {
            try {
                Scanner sc = new Scanner(f1);
                FileWriter cpWriter = new FileWriter(f2);
                if(!sc.hasNextLine()) {
                    System.out.println("File is empty!");
                } else {
                    String s = sc.nextLine(); int c = 0;
                    try {
                        c = Integer.parseInt(s);
                    } catch(NumberFormatException n) {
                        System.out.println("Value doesn't seem to be an integer!");
                        n.printStackTrace();
                    }
                    List<Integer> ints = cpList(c);
                    for(int d = 0; d < ints.size(); d++) {
                        if(d % 10 == 0 && d != 0) {
                            cpWriter.write(ints.get(d) + ", \n");
                        } else if(ints.get(d).equals(ints.get(ints.size() - 1))) {
                            cpWriter.write(ints.get(d) + ".");
                        } else {
                            cpWriter.write(ints.get(d) + ", ");
                        }
                    }
                    cpWriter.flush(); cpWriter.close();
                    System.out.println("Check " + f2.getName() + " for results!");
                }
            } catch(IOException e) {
                System.out.println("An error occurred!");
                e.printStackTrace();
            }
        }
    }
}
