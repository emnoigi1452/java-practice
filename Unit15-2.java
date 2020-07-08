import java.util.Scanner;

class Main {
    static String reverse(String text) {
        int textLength = text.length();
        String newText = "";
        for (int i  = textLength - 1; i >= 0; --i) {
            newText = newText + text.charAt(i);
        }
        return newText;
    }
    private static Scanner input;
    public static void main(String[] args) {
        String text;
        System.out.println("Input word: ");
        try {
            input = new Scanner(System.in);
        }
        finally {
            text = input.nextLine();
        }
        System.out.println("Result: " + reverse(text));
    }
}
