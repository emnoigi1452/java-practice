package me.ductrader.javapractice;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static boolean isNumeral(String param) {
        try {
            Integer.parseInt(param);
        } catch(NumberFormatException e) {
            return false;
        }
        return true;
    }
    public static int getIndex(int[] array, int element) {
        for(int k = 0; k < array.length; k++) {
            if(array[k] == element) {
                return k;
            }
        }
        return 0;
    }
    public static int getIndex(String[] array, String element) {
        for(int k = 0; k < array.length; k++) {
            if(array[k].equalsIgnoreCase(element)) {
                return k;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        File in = new File("equation.in");
        File out = new File("equation.out");
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String currentTime = sf.format(cal.getTime());
        try {
            in.createNewFile(); out.createNewFile();
            System.out.println("Files generated!");
            System.out.println("Input file: " + in.getAbsolutePath());
            System.out.println("Output file: " + out.getAbsolutePath());
        } catch(IOException e) {
            System.out.println("An error occurred while creating files...");
            e.printStackTrace();
            System.out.println("Files already created, skipping...");
        }
        try {
            Scanner sc = new Scanner(in);
            FileWriter writer = new FileWriter(out);
            writer.write("Output file, where results are written\n");
            writer.write("Displaying all equations calculated...\n");
            writer.write("Created on: " + currentTime + "\n");
            while(sc.hasNextLine()) {
                String s = sc.nextLine();
                List<Integer> indexes = new ArrayList<Integer>();
                if(!(s.isEmpty())) {
                    String[] p = s.split(" ");
                    if(p.length < 2) {
                        System.out.println("Invalid length!");
                    } else {
                        int val = 0;
                        for(String q: p) {
                            if(isNumeral(q)) {
                                val++;
                                indexes.add(getIndex(p, q));
                            }
                            if(val == 2) {
                                break;
                            }
                        }
                        if(val != 2) {
                            System.out.println("Not enough valid values!");
                        } else {
                            int a = Integer.parseInt(p[indexes.get(0)]);
                            int b = Integer.parseInt(p[indexes.get(1)]);
                            if(b == 0) {
                                if(a == 0) {
                                    writer.write("Infinite values of x\n\n");
                                } else {
                                    writer.write("x has a value of 0\n\n");
                                }
                            } else {
                                if(a == 0) {
                                    writer.write("x has no possible value!\n\n");
                                } else {
                                    writer.write("x has a value of: " + (b * -1) / a + "\n\n");
                                }
                            }
                        }
                    }
                }
            }
            writer.flush();
            writer.close();
        } catch(IOException e) {
            System.out.println("An error occurred!");
            e.printStackTrace();
        }
    }
}
