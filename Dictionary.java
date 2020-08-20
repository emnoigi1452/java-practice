import java.util.ArrayList;
import java.util.Scanner;

import java.util.HashMap;

class Dictionary {

    public HashMap<String, String> contents;
    public ArrayList<String> dictionaryList;

    public Dictionary() {
        contents = new HashMap<>();
        dictionaryList = new ArrayList<>();
    }

    public String translate(String word) {
        if (contents.containsKey(word)) {
            return contents.get(word);
        } else {
            return "That word is not available in the dictionary";
        }
    }

    public void addTranslation(String word, String translateTo) {
        contents.put(word, translateTo);
    }

    public void removeTranslation(String key) {
        contents.remove(key);
    }

    public int getWordAmount() {
        return contents.size();
    }

    public ArrayList<String> translation() {
        ArrayList<String> wordList = new ArrayList<>();
        for (String word : contents.keySet()) {
            wordList.add(word + " = " + contents.get(word));
        }
        return wordList;
    }
}

class UserInterface extends Dictionary {
    public String statement;
    public String word;
    public String translation;
    public String returnParam;
    public int words;
    public Scanner readIn;

    public UserInterface() {
        words = this.words;
        readIn = new Scanner(System.in);

    }

    public void statementHandler(String param) {
        switch(param.toLowerCase()) {
            case "add":
                System.out.println("Input word: ");
                word = readIn.nextLine();
                System.out.println("Input translation: ");
                translation = readIn.nextLine();
                super.addTranslation(word, translation);
            case "remove":
                System.out.print("Input removed word: ");
                word = readIn.nextLine();
                super.removeTranslation(word);
            case "quit":
                System.out.println("Cheers!");
                System.exit(0);
            default:
                System.out.println("Unrecognizable statement!");
        }
    }

    public void startInterface() {
        String param = "";
        while(!param.equalsIgnoreCase("quit")) {
            System.out.println("Input statement: ");
            param = readIn.nextLine();
            statementHandler(param);
        }
    }
}
