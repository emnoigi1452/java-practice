package me.ductrader.javapractice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<String> str = new ArrayList<>();
        Scanner reader = new Scanner(System.in);
        while(true) {
            String in = reader.nextLine();
            if(in.isEmpty()) {
                break;
            }
            str.add(in);
        }
        String d = str.stream()
                .reduce("", (pStr, word) -> pStr + word + "\n");
        System.out.println(d);
    }
}
