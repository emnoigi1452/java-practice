package me.ductrader.javapractice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class GuessingGame {
    private int s;
    private int e;
    private List<String> instructions;

    public GuessingGame(int start, int end) {
        this.s = start;
        this.e = end;
        this.instructions = new ArrayList<String>();

    }
    public int getStart() {
        return s;
    }
    public int getEnd() {
        return e;
    }
    public void setStartPoint(int s) {
        this.s = s;
    }
    public void setEndPoint(int e) {
        this.e = e;
    }
    public int getRangeLength() {
        return getEnd() - getStart();
    }
    public int getAverageValue() {
        return Math.abs(getStart() + getEnd()) / 2;
    }
    public int getAttempts() {
        int c = 0;
        for(int i = 0; i <= getRangeLength(); i++) {
            int k = (int)(Math.pow(2, i));
            if(k >= getRangeLength()) {
                c = i;
                break;
            }
        }
        return c;
    }
    private void constructInstruction() {
        this.instructions.add("Successfully setup range for guessing, range is at " + getRangeLength());
        this.instructions.add("Now, i'll ask you a series of questions, you must answer either yes or no");
        this.instructions.add("Please answer them truthfully, otherwise i'm unable to guess what number you're referring to");
        this.instructions.add("I can guarantee i'll have your number after " + getAttempts() + " tries. Now let us begin.");
    }
    public void getInstructions() {
        this.constructInstruction();
        for(String d: this.instructions) {
            System.out.println(d);
        }
    }
    public boolean getAnswer(String getAnswer) {
        if(getAnswer.equalsIgnoreCase("yes") || getAnswer.equalsIgnoreCase("y")) {
            return true;
        }
        else if(getAnswer.equalsIgnoreCase("no") || getAnswer.equalsIgnoreCase("n")) {
            return false;
        }
        else {
            System.out.println("Invalid answer, try again later!");
            System.exit(-1);
            return false;
        }
    }
    public void logicHandler(Scanner reader) {
        this.getInstructions();
        int limit = getAttempts();
        String defaultRange = this.getStart() + " - " + this.getEnd();
        int elementCount = (this.getEnd() - this.getStart()) + 1;
        int giveNum = 0;
        for(int x = 0; x < limit; x++) {
            System.out.println("Is your number larger then " + getAverageValue() + "? (Type 'yes (y)' or 'no (n)'): ");
            String i = reader.nextLine();
            if(getAnswer(i)) {
                this.setStartPoint(getAverageValue() + 1);
                giveNum = this.getStart();
            } else {
                this.setEndPoint(getAverageValue());
                giveNum = this.getEnd();
            }
        }
        System.out.println("Completed, your number is " + giveNum + ", located in range of numbers from " + defaultRange);
        System.out.println("Elements: " + elementCount + " - Scanned out in " + limit + " attempts");
    }
}

public class Main {
    static void printDesc() {
        System.out.println("Welcome to the guessing program, here i'll try and guess a number you think about with a predetermined range");
        System.out.println("I'll try my best to guess the number that you're trying to guess");
        System.out.println("Now please input your range using the following syntax: <start> to <end>");
    }
    public static void main(String[] args) {
        printDesc();
        Scanner input = new Scanner(System.in);
        String[] param = (input.nextLine()).split(" ");
        int start = 0;
        int end = 0;
        if(param.length != 3) {
            System.out.println("Not enough parameters!");
            System.exit(-1);
        } else {
            if(!param[1].equalsIgnoreCase("to")) {
                System.out.println("Unknown parameter!");
                System.exit(-1);
            }
            for(int x = 0; x < param.length; x++) {
                switch(x) {
                    case 0:
                        try {
                            start = Integer.parseInt(param[x]);
                        } catch(NumberFormatException e) {
                            System.out.println("Start value has to be an integer!");
                            System.out.println("Error caused by: " + e.getMessage());
                            System.out.println("Ending program...");
                            System.exit(-1);
                        }
                    case 2:
                        try {
                            end = Integer.parseInt(param[x]);
                        } catch(NullPointerException e) {
                            System.out.println("Start value has to be an integer!");
                            System.out.println("Error caused by: " + e.getMessage());
                            System.out.println("Ending program...");
                            System.exit(-1);
                        }

                }
            }
        }
        if(end <= start) {
            System.out.println("Unable to perform search when the range is less then 5!");
            System.exit(-1);
        } else {
            if(end - start <= 5) {
                System.out.println("Please make a larger range!");
                System.exit(-1);
            } else {
                GuessingGame g = new GuessingGame(start, end);
                g.logicHandler(input); // Start the algorithm
            }
        }
        System.out.println("");
        System.out.println("Written by emnoigi1452 - Update 15/09/2020");
        System.out.println("See you later :3");
        System.exit(-1);
    }
}
