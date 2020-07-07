import java.util.Scanner;

class Main {
    static void yourChoice() {
        System.out.println("You select: ");
    }
    static void compChoice(String computerChoice) {
        System.out.println("The computer select: " + computerChoice);
    }
    static void invalidChoice() {
        System.out.println("Invalid choice!");
    }
    static void youWin() {
        System.out.println("You won!");
    }
    static void youLose() {
        System.out.println("You lost!");
    }
    static void aTie() {
        System.out.println("It's a tie!");
    }
    
    private static Scanner choice;
    static String commandInput;
    static String yourChoice;
    static String computerChoice;
    static int numChoice;

    public static void main(String[] args) {
        System.out.println("Time to play Rock, Paper, Scissors!");
        yourChoice();
        try {
            choice = new Scanner(System.in);
        }
        finally {
            yourChoice = choice.nextLine();
        }

        if (!(yourChoice.equals("Rock") ||
                yourChoice.equals("Paper") ||
                yourChoice.equals("Scissors"))) {
            invalidChoice();
            System.exit(0);
        }

        numChoice = (int)Math.random() * ((3 - 1) + 1) + 1;
        switch(numChoice) {
            case 1:
                computerChoice = "Rock";
                break;
            case 2:
                computerChoice = "Paper";
                break;
            case 3:
                computerChoice = "Scissors";
                break;
        }

        if(yourChoice.equals("Rock")) {
            if(computerChoice.equals("Paper")) {
                youLose();
                System.exit(0);
            }
            else if (computerChoice.equals("Scissors")) {
                youWin();
                System.exit(0);
            }
            else {
                aTie();
                System.exit(0);
            }
        }
        else if(yourChoice.equals("Paper")) {
            if(computerChoice.equals("Rock")) {
                youWin();
                System.exit(0);
            }
            else if(computerChoice.equals("Scissors")) {
                youLose();
                System.exit(0);
            }
            else {
                aTie();
                System.exit(0);
            }
        }
        else if(yourChoice.equals("Scissors")) {
            if(computerChoice.equals("Paper")) {
                youWin();
                System.exit(0);
            }
            else if(computerChoice.equals("Rock")) {
                youLose();
                System.exit(0);
            }
            else {
                aTie();
                System.exit(0);
            }
        }
    }
}
