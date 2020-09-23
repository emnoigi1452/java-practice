package me.ductrader.javapractice;

import java.util.Scanner;

public class Main {
    public static int fibonacci(Integer n) {
        if(n == 0) {
            return 0;
        } else if(n == 1) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        System.out.print("Input number: ");
        String k = read.nextLine();
        int i = 0;
        try {
            i = Integer.parseInt(k);
        } catch(NumberFormatException e) {
            System.out.println("Error occurred - " + e);
            System.exit(-1);
        }
        System.out.println("The " + i + "th number in the sequence is " + fibonacci(i));
    }
}
