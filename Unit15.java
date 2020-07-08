import java.util.Scanner;

class Main {

    private static Scanner input;
    private static Scanner input2;
    static int length;
    static int lengthEnd;
    static int wordLength;

    public static void main(String[] args) {
        String word = "Example";
        System.out.println("The word is: " + word);
        System.out.println("Input length: ");
        try {
            input = new Scanner(System.in);
        }
        finally {
            length = input.nextInt();
        }
        String result = word.substring(0, length);
        System.out.println("Result: " + result);

        String word2 = "Photosynthesis";
        System.out.println("The word is: " + word2);
        System.out.println("Input length: ");
        try {
            input2 = new Scanner(System.in);
        }
        finally {
            lengthEnd = input2.nextInt();
        }
        wordLength = word2.length();
        String result2 = word2.substring((wordLength-1) - lengthEnd, wordLength - 1);
        System.out.println("Result: " + result2);
        System.exit(0);
    }
}
