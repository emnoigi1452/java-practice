package me.ductrader.javapractice;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class Main {
    public static int[] pascalTriangle(int size) {
        int[] ar = new int[size+1];
        for(int k = 0; k <= size; k++) {
            if(k == 0) {
                ar[0] = 1;
            } else {
                ar[k] = (int)Math.pow(11, k);
            }
        }
        return ar;
    }

    public static void main(String[] args) {
        File i = new File("pascal.in");
        File o = new File("pascal.out");
        int triangleCount = 0;
        if(!i.exists()) {
            System.out.println("Input file doesn't exist!");
            System.out.println("Creating new file...");
            try {
                i.createNewFile();
                System.out.println("Input file generated!");
                System.exit(0);
            } catch(IOException e) {
                System.out.println("An error occurred! More info on this error: ");
                e.printStackTrace();
            }
        } else if(!o.exists()) {
            System.out.println("Output file doesn't exist!");
            System.out.println("Creating new file...");
            try {
                o.createNewFile();
                System.out.println("Output file generated!");
                System.exit(0);
            } catch(IOException e) {
                System.out.println("An error occurred! More info: ");
                e.printStackTrace();
            }
        } else {
            try {
                Scanner sc = new Scanner(i);
                FileWriter writer = new FileWriter(o);
                if(!sc.hasNextLine()) {
                    System.out.println("File is empty!");
                } else {
                    while(sc.hasNextLine()) {
                        String r = sc.nextLine(); int k = 0; boolean isValid = true;
                        try {
                            k = Integer.parseInt(r);
                        } catch(NumberFormatException e) {
                           isValid = false;
                        }
                        if(isValid) {
                            int[] everyInt = pascalTriangle(k);
                            for(Integer pas: everyInt) {
                                String s = Integer.toString(pas);
                                for(int y = 0; y < s.length(); y++) {
                                    writer.write(s.charAt(y) + " ");
                                }
                                writer.write("\n");
                            }
                            writer.write("Triangle size: " + k); triangleCount++;
                            writer.write("\n\n");
                        } else {
                            writer.write("- Invalid input: " + r);
                            writer.write("\nSkipping to next value...");
                            writer.write("\n\n");
                        }
                    }
                    writer.flush();
                    writer.close();
                }
            } catch(IOException e) {
                System.out.println("An error occurred whilst generating triangle!");
                e.printStackTrace();
            }
        }
        System.out.println("Process ended, generated " + triangleCount + " triangles");
        System.out.println("Input triangle size: " + i.getName() + " - " + i.getAbsolutePath());
        System.out.println("Output triangles: " + o.getName() + " - " + o.getAbsolutePath());
    }
}
