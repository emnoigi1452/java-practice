package me.ductrader.javapractice;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class Main {
    public static int robotMovement(int movement) {
        if(movement < 0) {
            return Math.abs(((1 + movement) + 10) % 10);
        } else {
            return (1 + movement) % 10;
        }
    }

    public static void main(String[] args) {
        File f1 = new File("C:\\Users\\Administrator\\Desktop\\robot.txt");
        File f2 = new File("C:\\Users\\Administrator\\Desktop\\robot2.txt");
        try {
            Scanner sc = new Scanner(f1);
            FileWriter writer = new FileWriter(f2);
            while(sc.hasNextLine()) {
                int k = sc.nextInt();
                writer.write("Robot will move to: " + robotMovement(k) + "\n");
                writer.flush();
                System.out.println("Inputted value, moving on...");
            }
            System.out.println("Output has been made, please check " + f2.getName() + " to see results!");
            writer.close();
        } catch(IOException e) {
            System.out.println("An exception has been thrown!");
            System.out.println("Maybe an error occurred?");
            System.exit(-1);
        }
    }
}