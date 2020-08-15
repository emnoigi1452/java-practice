
import java.util.Scanner;
import java.util.ArrayList;

class GuessingHandler {
    public int a;
    public int b;
    public Scanner sc;
    public ArrayList<String> instruct;

    public GuessingHandler(int a, int b) {
        this.a = a;
        this.b = b;
        sc = new Scanner(System.in);
        instruct = new ArrayList<>();
    }

    public int getInitialRange() {
        return this.b - this.a;
    }

    public int getAverage() {
        return (this.a + this.b) / 2;
    }

    public int getTries() {
        int tries = 0;
        for(int i = 0; i < getInitialRange(); i++) {
            int pow = (int)(Math.pow(2, i));
            if(pow >= getInitialRange()) {
                tries = i;
                break;
            }
        }
        return tries;
    }

    public void instruction() {
        instruct.add("Welcome to the guessing game! ");
        instruct.add("Please think of a random number, within " + this.a + " to " + this.b);
        instruct.add("I promise you i can guess your number within " + getTries() + " tries");
        instruct.add("Did you get your number? Now answer the following questions, and i'll try to guess your number!");
        for(String display: instruct) {
            System.out.println(display);
        }
    }

    public boolean isLarger() {
        System.out.print("Is your number larger then " + getAverage() + "? (y/n) ");
        String param = sc.nextLine();
        if(param.equalsIgnoreCase("y")) {
            return true;
        }
        else {
            return false;
        }
    }

    public void gameLogic() {
        int num = 0;
        int count = getTries();

        instruction();
        for(int k = 0; k < count; k++) {
            if(isLarger()) {
                this.a = getAverage() + 1;
                num = this.a;
            }
            else {
                this.b = getAverage();
                num = this.b;
            }
        }
        System.out.println("Your number is: " + num);

    }

}
class Main {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.print("Input the selected range - ");
        System.out.print("Begins from: ");
        int x = reader.nextInt();
        System.out.print("- Ends at: ");
        int y = reader.nextInt();

        GuessingHandler guess = new GuessingHandler(x, y);
        guess.gameLogic();

    }

}
