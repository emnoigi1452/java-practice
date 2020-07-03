import java.util.Scanner;

class Main {
    static void inputNum() {
        System.out.println("Input number: ");
    }
    static void isPrime() {
        System.out.println("The number entered is prime!");
    }
    static void notPrime() {
        System.out.println("The number entered is not a prime!");
    }

    private static Scanner input;
    static int num;

    public static void main(String[] args) {
        boolean notPrime = false;
        inputNum();
        try {
            input = new Scanner(System.in);
        }
        finally {
            num = input.nextInt();
        }

        for (int i = 2; i <= num / 2; i++)
        {
            if(num % i == 0)
            {
                notPrime = true;
                break;
            }
        }
        if(!notPrime) {
            isPrime();
        }
        else {
            notPrime();
        }
    }
}
