package me.ductrader.javapractice.dictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SaveableDictionary {
    private File f;
    private Scanner sc;

    public SaveableDictionary(String path) {
        f = new File(path);
        this.newFile();
        this.generateScanner();
    }

    public void newFile() {
        if(!(f.exists())) {
            try {
                f.createNewFile();
            } catch(IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("File already exist!");
        }
    }

    public boolean generateScanner() {
        try {
            sc = new Scanner(f);
        } catch(IOException e) {
            return false;
        }
        return true;
    }

    private static Map<String, String> words = new HashMap<String, String>();

    public void add(String word, String translate) {
        words.put(word, translate);
    }
    public String translate(String word) {
        while(this.sc.hasNextLine()) {
            String l = this.sc.nextLine();
            String[] sp = l.split(":");
            if(word.equalsIgnoreCase(sp[1])) {
                return sp[2];
            } else if(word.equalsIgnoreCase(sp[2])) {
                return sp[1];
            }
        }
        return null;
    }
    public void delete(String toDel) {
        for(String s: words.keySet()) {
            String s1 = words.get(s);
            if(toDel.equalsIgnoreCase(s)) {
                words.remove(s); break;
            } else if(toDel.equalsIgnoreCase(s1)) {
                words.remove(s); break;
            }
        }
    }
    public void save() throws FileNotFoundException {
        PrintWriter writer;
        if(load()) {
            writer = new PrintWriter(f);
            for(String s: words.keySet()) {
                writer.println(s + ":" + words.get(s));
            }
        } else {
            System.out.println("Failed to save! File doesn't seem to exist!");
        }
    }
    public boolean load() {
        return f.exists() && this.generateScanner();
    }
}
