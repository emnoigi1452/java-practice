import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Dictionary {
    public HashMap<String, String> dictionaryDatabase;
    public ArrayList<String> listWords;

    public Dictionary() {
        dictionaryDatabase = new HashMap<String, String>();
        listWords = new ArrayList<String>();
    }

    public int getDictionarySize() {
        return dictionaryDatabase.size();
    }

    public void getTranslation(String paramKey) {
        if(!(dictionaryDatabase.containsKey(paramKey))) {
            System.out.println("This word doesn't exist in the database!");
        }
        else {
            System.out.println(paramKey + "- Translation: " + dictionaryDatabase.get(paramKey));
        }
    }
    public void addTranslation(String paramKey, String translation) {
        if(dictionaryDatabase.containsKey(paramKey)) {
            System.out.println("This word already exist in the dictionary!");
        }
        else {
            dictionaryDatabase.put(paramKey, translation);
        }
    }
    public void removeTranslation(String paramKey) {
        if(!(dictionaryDatabase.containsKey(paramKey))) {
            System.out.println("This word doesn't exist in the dictionary!");
        }
        else {
            dictionaryDatabase.remove(paramKey);
        }
    }
    public void editTranslation(String paramKey, String translation) {
        if(!(dictionaryDatabase.containsKey(paramKey))) {
            System.out.println("This word doesn't exist in the dictionary");
        }
        else {
            dictionaryDatabase.put(paramKey, translation);
        }
    }
    public ArrayList<String> translation() {
        for(String word: dictionaryDatabase.keySet()) {
            listWords.add(word + " - Translation: " + dictionaryDatabase.get(word));
        }
        return this.listWords;
    }
    public void printDictionary() {
        for(String word: listWords) {
            System.out.println(word);
        }
    }
}
class UserInterface extends Dictionary {
    public String cmd;
    public String[] args;
    public Scanner sc;
    public int actions;

    public UserInterface() {
        this.sc = new Scanner(System.in);
        this.actions = 0;
    }
    public void start() {
        while(true) {
            System.out.print("Input cmd: ");
            String cmd = sc.nextLine();
            args = cmd.split(" ");
            switch(args[0]) {
                case "quit":
                    System.exit(-1);
                    break;
                case "translate":
                    if(args.length != 2) {
                        System.out.println("Invalid arguments!");
                    }
                    else {
                        super.getTranslation(args[1]);
                    }
                    break;
                case "addTranslation":
                    if(args.length != 3) {
                        System.out.println("Invalid arguments!");
                    }
                    else {
                        super.addTranslation(args[1], args[2]);
                    }
                    break;
                case "editTranslation":
                    if(args.length != 3) {
                        System.out.println("Invalid arguments!");
                    }
                    else {
                        super.editTranslation(args[1], args[2]);
                    }
                    break;
                case "remove":
                    if(args.length != 2) {
                        System.out.println("Invalid arguments!");
                    }
                    else {
                        super.removeTranslation(args[1]);
                    }
                    break;
                case "print":
                    if(args.length != 1) {
                        System.out.println("Invalid arguments!");
                    }
                    else {
                        super.printDictionary();
                    }
                    break;
                case "getSize":
                    if(args.length != 1) {
                        System.out.println("Invalid arguments!");
                    }
                    else {
                        System.out.println("Dictionary size: " + super.getDictionarySize());
                    }
                    break;
                default:
                    System.out.println("Unknown command!");
                    break;
            }
            this.actions++;
        }
    }
    public int getActions() {
        return this.actions;
    }
}
