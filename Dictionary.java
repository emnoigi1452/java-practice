package me.ductrader.exercise;

import java.util.ArrayList;
import java.util.HashMap;

public class Dictionary {
    public HashMap<String, String> dictionary;

    public Dictionary() {
        dictionary = new HashMap<>();
    }
    public void getTranslation(String param) {
        if(!dictionary.containsKey(param)) {
            System.out.println("This word doesn't exist in the dictionary!");
        }
        else {
            dictionary.get(param);
        }
    }
    public void addTranslation(String paramKey, String translation) {
        if(dictionary.containsKey(paramKey) && dictionary.get(paramKey).equalsIgnoreCase(translation)) {
            System.out.println("That word has already been translated and stored within the dictionary's database!");
        }
        else if(dictionary.containsKey(paramKey) && (!(dictionary.get(paramKey).equalsIgnoreCase(translation)))) {
            System.out.println("Successfully modified " + paramKey + "! New translation: " + translation);
        }
        else {
            dictionary.put(paramKey, translation);
            System.out.println("Successfully added " + paramKey + " to the database. Translation: " + translation);
        }
    }
    public void removeTranslation(String paramKey) {
        if(!dictionary.containsKey(paramKey)) {
            System.out.println("This word doesn't exist within the database!");
        }
        else {
            System.out.println("Word removed!");
            dictionary.remove(paramKey);
        }
    }
    public int getWordCount() {
        return dictionary.size();
    }
    public ArrayList<String> translations() {
        ArrayList<String> words = new ArrayList<>();
        for(String loadArray: dictionary.keySet()) {
            words.add(loadArray + " - Translation: " + dictionary.get(loadArray));
        }
        return words;
    }
    public void printDictionary() {
        for(String display: translations()) {
            System.out.println(display);
        }
    }
}
