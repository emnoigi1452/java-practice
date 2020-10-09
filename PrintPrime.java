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
                    String k = sc.nextLine(); int c = 0;
                    try {
                        c = Integer.parseInt(k);
                    } catch(NumberFormatException e) {
                        System.out.println("Error!"); System.exit(-1);
                    }
                    if(c < 2) {
                        System.out.println("Error! Minimum value has to be 2!");
                    } else {
                        for(int x = 2; x <= c; x++) {
                            boolean isPrime = true;
                            for(int p = 2; p < x; p++) {
                                if(x % p == 0) {
                                    isPrime = false;
                                    break;
                                }
                            }
                            if(isPrime) {
                                writer.write(x + " ");
                            }
                        }
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
