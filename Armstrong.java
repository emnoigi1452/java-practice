package me.ductrader.javapractice;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static int getDigit(String num, int index) {
        return Integer.parseInt(String.valueOf(num.charAt(index)));
    }
    public static List<Integer> armstrongList(int d) {
        List<Integer> filtered = new ArrayList<Integer>();
        if(d <= 9 && d > 0) {
            for(int k = (int)Math.pow(10, d -1); k < (int)Math.pow(10, d); k++) {
                int t = 0; String s = Integer.toString(k); int len = s.length();
                for(int x = 0; x < s.length(); x++) {
                    t += (int)Math.pow(getDigit(s, x), s.length());
                }
                if(t == k) {
                    filtered.add(k);
                }
                // No else statements here :P
            }
        } else {
            System.out.println("Out of range!");
        }
        return filtered;
    }
    public static boolean isLastElement(List<Integer> list, int el) {
        return el == list.get(list.size() - 1);
    }

    public static void main(String[] args) {
        File f = new File("armstrong.in");
        File o = new File("armstrong.out");
        if(!f.exists()) {
            System.out.println("File " + f.getName() + " doesn't exist!");
            System.out.println("Creating a new file...");
            try {
                f.createNewFile();
                System.out.println("File has been created!");
            } catch(IOException e) {
                System.out.println("An error has occurred!");
                e.printStackTrace();
            }
            System.out.println("Please restart the program!");
            System.exit(-1);
        } else if(!o.exists()) {
            System.out.println("File " + o.getName() + " doesn't exist!");
            System.out.println("Creating a new file...");
            try {
                o.createNewFile();
                System.out.println("File has been created!");
            } catch(IOException e) {
                System.out.println("An error has occurred!");
                e.printStackTrace();
            }
            System.out.println("Please restart the program!");
            System.exit(-1);
        } else {
            System.out.println("Beginning to calculate numbers...");
            try {
                Scanner sc = new Scanner(f);
                FileWriter writer = new FileWriter(o);
                if(!sc.hasNextLine()) {
                    System.out.println("File is empty!");
                } else {
                    while(sc.hasNextLine()) {
                        String q = sc.nextLine(); int p = 0;
                        boolean isInt = true;
                        try {
                            p = Integer.parseInt(q);
                        } catch(NumberFormatException e) {
                            System.out.println("Value is not integer!");
                            isInt = false;
                        }
                        if(isInt) {
                            List<Integer> aNums = armstrongList(p);
                            writer.write("Armstrong numbers with " + p + " digits: ");
                            for(Integer a: aNums) {
                                if(isLastElement(aNums, a)) {
                                    writer.write(a + ".\n");
                                } else {
                                    writer.write(a + ", ");
                                }
                            }
                        } else {
                            System.out.println("Skipping to next line...");
                            writer.write("This line has an invalid input - '" + q + "' is not a valid integer!");
                            writer.write("\n");
                        }
                    }
                    writer.flush();
                    writer.close();
                }
            } catch(IOException e) {
                System.out.println("An error occurred in the program!");
                e.printStackTrace();
            }
        }
        System.out.println("Program ended, check " + o.getName() + " to get results");
        System.out.println("Path: " + o.getAbsolutePath());
    }
}
