import java.util.Scanner;

class Main {
    static void charAmount() {
        System.out.println("Input integer's digit length: ");
    }
    static void rangeMin() {
        System.out.println("Input range: ");
        System.out.println("Begin value: ");
    }
    static void rangeMax() {
        System.out.println("End value: ");
    }
    static void verifyingValue() {
        System.out.println("Verifying the value...");
    }
    static void validInput() {
        System.out.println("Valid input, proceed..");
    }
    static void invalidLength() {
        System.out.println("Invalid length of integer!");
    }
    static void generating(int min, int max) {
        System.out.println("Generating random number from "
                + min + " to " + max);
    }
    static void randomizationComplete() {
        System.out.println("Randomization has complete, now time for your guess: ");
    }
    static void reallyFar() {
        System.out.println("Your guess was incorrect, you're really far away, thousands away from the correct answer");
    }
    static void Far() {
        System.out.println("Your guess was incorrect, you're quite far away, hundreds away from the answer!");
    }
    static void quiteNear() {
        System.out.println("Your guess was incorrect, you're quite near the answer already!");
    }
    static void reallyClose() {
        System.out.println("You are just a few integers away from the answer!");
    }

    static void congrats(int stableValue) {
        System.out.println("You did it, " + stableValue + " was the number!");
    }

    private static Scanner length;
    private static Scanner beginValue;
    private static Scanner endValue;
    private static Scanner guessValue;
    static int lengthValue;
    static int min;
    static int max;
    static int lengthMax;
    static int lengthMin;
    static int guess;
    static int random;
    static int stableValue;

    public static void main(String[] args) {
        System.out.println("Welcome to the guessing game!");
        charAmount();
        try {
            length = new Scanner(System.in);
        }
        finally {
            lengthValue = length.nextInt();
        }

        System.out.println("Character amount verified! Please input the range value (Only "
                + lengthValue + " characters)");
        rangeMin();
        try {
            beginValue = new Scanner(System.in);
        }
        finally {
            min = beginValue.nextInt();
        }

        verifyingValue();

        lengthMin = min;
        int i;
        for (i = 0; lengthMin >= 1; i++) {
            lengthMin /= 10;
        }
        if (i != lengthValue) {
            invalidLength();
            System.exit(0);
        }
        else {
            validInput();
        }

        rangeMax();
        try {
            endValue = new Scanner(System.in);
        }
        finally {
            max = endValue.nextInt();
        }

        verifyingValue();

        lengthMax = max;
        int n;
        for (n = 0; lengthMax >= 1; n++) {
            lengthMax /= 10;
        }
        if(n != lengthValue) {
            invalidLength();
            System.exit(0);
        }
        else {
            validInput();
        }

        random = (int)Math.random() * ((max - min)+1) + min;
        stableValue = random;

        randomizationComplete();
        try {
            guessValue = new Scanner(System.in);
        }
        finally {
            guess = guessValue.nextInt();
        }
        
        if((guess > stableValue && guess - stableValue >= 1000) ||
                (stableValue > guess && stableValue - guess >= 1000)) {
            reallyFar();
        }
        else if ((guess > stableValue && guess - stableValue >= 100 && guess - stableValue < 1000) ||
                (guess < stableValue && stableValue - guess >= 100 && stableValue - guess < 1000 )) {
            Far();
        }
        else if ((guess > stableValue && guess - stableValue >= 10 && guess - stableValue < 100) ||
                (guess < stableValue && stableValue - guess >= 10 && stableValue - guess < 100)) {
            quiteNear();
        }
        else if ((guess > stableValue && guess - stableValue >= 1 && guess - stableValue < 10) ||
                (guess < stableValue && stableValue - guess >= 1 && stableValue - guess < 10)) {
            reallyClose();
        }
        else if (guess == stableValue) {
            congrats(stableValue);
            break;
        }
        while (guess != stableValue)
        {
            try {
                guessValue = new Scanner(System.in);
            }
            finally {
                guess = guessValue.nextInt();
            }

            if((guess > stableValue && guess - stableValue >= 1000) ||
                    (stableValue > guess && stableValue - guess >= 1000)) {
                reallyFar();
            }
            else if ((guess > stableValue && guess - stableValue >= 100 && guess - stableValue < 1000) ||
                    (guess < stableValue && stableValue - guess >= 100 && stableValue - guess < 1000 )) {
                Far();
            }
            else if ((guess > stableValue && guess - stableValue >= 10 && guess - stableValue < 100) ||
                    (guess < stableValue && stableValue - guess >= 10 && stableValue - guess < 100)) {
                quiteNear();
            }
            else if ((guess > stableValue && guess - stableValue >= 1 && guess - stableValue < 10) ||
                    (guess < stableValue && stableValue - guess >= 1 && stableValue - guess < 10)) {
                reallyClose();
            }
            else if (guess == stableValue) {
                congrats(stableValue);
                break;
            }
        }

    }
}
