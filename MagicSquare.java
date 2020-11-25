package me.ductrader.javapractice;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

class Main {
    public static int[][] matrix(int n) {
        int[][] square = new int[n][n];
        int x = n/2; int y = n-1; square[x][y] = 1;
        for(int k = 2; k <= n*n; k++) {
            x--; y++;
            if(x < 0 && y == n) {
                x = 0; y = n-2;
            } else {
                if(x < 0) {
                    x = n-1;
                }
                if(y == n) {
                    y = 0;
                }
            }
            if(square[x][y] != 0) {
                x++; y-=2;
            }
            square[x][y] = k;
        }
        return square;
    }

    public static void main(String[] args) {
        File f1 = new File("magic.in");
        File f2 = new File("magic.out");
        boolean reload = false; int count = 0;
        if(!(f1.exists())) {
            try {
                f1.createNewFile(); count++;
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
        if(!(f2.exists())) {
            try {
                f2.createNewFile(); count++;
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
        if(count != 0) {
            System.out.println("A reboot has been executed since one of the two files were not generated!");
            System.out.println("After the program ended, please type your inputs in");
        } else {
            try {
                Scanner sc = new Scanner(f1);
                PrintWriter writer = new PrintWriter(f2);
                Calendar cal = Calendar.getInstance(); SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
                writer.println("Magic square generator - By emnoigi1452");
                writer.println("Note : This version currently can only generate odd values magic square");
                writer.println("File generated: " + sdf.format(cal.getTime())); writer.println("");
                int actions = 0;
                while(sc.hasNextInt()) {
                    int size = sc.nextInt(); // Indicate magic square size
                    if(size % 2 == 1 && size >= 3) {
                        writer.println("Begin generation - " + size + "x" + size + " magic square"); actions++;
                        int[][] generated = matrix(size);
                        for(int a = 0; a < size; a++) {
                            for(int b = 0; b < size; b++) {
                                writer.write(generated[a][b] + " ");
                            }
                            writer.println("");
                        }
                    } else {
                        writer.println("Invalid value! Either it's even or smaller than 3!");
                        writer.println("Given value: " + size);
                    }
                    writer.println("");
                }
                writer.flush(); writer.close();
                System.out.println("Program complete, " + actions + " squares generated.");
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
    }
}
