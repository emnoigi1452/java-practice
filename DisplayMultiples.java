package me.ductrader.javapractice;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static List<Integer> multiples(int dc) {
        List<Integer> nl = new ArrayList<>();
        if(dc < 2 || dc >= 10) {
            System.out.println("Value out of range! Please only put an integer" +
                    " between 2-9");
        } else {
            for(int k = (int)Math.pow(10, dc - 1); k < (int)Math.pow(10, dc); k++) {
                if(k % 11 == 0) {
                    nl.add(k);
                }
            }
        }
        return nl;
    }

    public static void main(String[] args) {
        File f1 = new File("multiples.in");
        File f2 = new File("multiples.out");
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
                FileWriter writer = new FileWriter(f2);
                if(!(sc.hasNextLine())) {
                    System.out.println("File is empty!");
                } else {
                    String p = sc.nextLine(); int a = 0;
                    try {
                        a = Integer.parseInt(p);
                    } catch(NumberFormatException n) {
                        System.out.println("Value doesn't seem to be an integer!");
                        n.printStackTrace();
                    }
                    List<Integer> mList = multiples(a);
                    for(int c = 0; c < mList.size(); c++) {
                        if(c % 15 == 0 && c != 0) {
                            writer.write(mList.get(c) + ",\n");
                        } else if(c % 15 != 0 && mList.get(c).equals(mList.get(mList.size() - 1))) {
                            writer.write(mList.get(c) + ".");
                        } else {
                            writer.write(mList.get(c) + ", ");
                        }
                    }
                    writer.flush();
                    writer.close();
                }
            } catch(IOException e) {
                System.out.println("An error occurred!");
                e.printStackTrace();
            }
        }
        System.out.println("Finished generation, please check " + f2.getName() + " for results");
    }
}
