package me.ductrader.exercise;

import java.util.Scanner;

public class UserInterface extends Dictionary {

    public Scanner inputReader;

    public UserInterface() {
        inputReader = new Scanner(System.in);
    }

    public void interfaceHandler(String param) {
        switch(param.toLowerCase()) {
            case "quit":
                System.out.println("Cheers!");
                System.exit(-1);
            case "add":
                System.out.print("Input word: ");
                String word = inputReader.nextLine();
                System.out.print("Input translation: ");
                String translation = inputReader.nextLine();
                super.addTranslation(word, translation);
            case "remove":
                System.out.print("Input word: ");
                String key = inputReader.nextLine();
                super.removeTranslation(key);
            case "translate":
                System.out.print("Input word: ");
                String args = inputReader.nextLine();
                super.getTranslation(args);
            case "displayall":
                super.printDictionary();
            case "wordcount":
                System.out.println("The dictionary has " + super.getWordCount() + " words!");
            case "help":
                System.out.println("Available commands :");
                System.out.println("add - Add a word and its translation to the dictionary");
                System.out.println("remove - Remove a word from the dictionary");
                System.out.println("translate - Translate a word, translation taken from dictionary");
                System.out.println("displayall - Display all stored words in the dictionary");
                System.out.println("wordcount - Get the amount of words the library contains.");
                System.out.println("help - Shows this help menu");
                System.out.println("quit - Stop the dictionary");
            default:
                System.out.println("Unrecognizable argument! Please type 'help' for a command list!");
        }
    }

    public void interfaceScript() {
        String param = "";
        while(!(param.equalsIgnoreCase("quit"))) {
            System.out.print("Statement - ");
            param = inputReader.nextLine();
            interfaceHandler(param);
        }
    }

}
