import java.util.Scanner;
import java.util.ArrayList;

class Main {
    private static Scanner input;
    static int count;
    static String newWord;
    public static void main(String[] args) {
        ArrayList<String> wordList = new ArrayList<String>();
        for(count = 0; count <= 5; ++count) {
            System.out.println("Type a word: ");
            try {
                input = new Scanner(System.in);
            }
            finally {
                newWord = input.nextLine();
            }
            if(newWord.equals("")) {
                System.out.println("Please type something in the console!");
                break;
            }
            else {
                wordList.add(newWord);
            }
        }
        if(wordList.isEmpty()) {
            System.out.println("Typing result: You didn't type anything");
        }
        else {
            System.out.println("You typed the following words: ");
            int listLength = wordList.size();
            for (int n = 0; n <= listLength; ++n) {
                System.out.println(wordList.get(n));
            }
        }
    }
}
