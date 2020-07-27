// Display all prime numbers from 0-n (with n inputted from keyboard)
// Exercise 8 - Practice

import java.util.Scanner;
import java.util.ArrayList;

class Main {
    private static Scanner readInput;
    static int n;

    public static void main(String[] args) {
        System.out.print("Input number: ");
        try {
            readInput = new Scanner(System.in);
        }
        finally {
            n = readInput.nextInt();
        }

        ArrayList<Integer> primeList = new ArrayList<Integer>();

        for(int i = 2; i <= n; i++) {
            boolean isPrime = true;
            int k = 2;
            check: for(k = 2; k <= i / 2; k++) {
                if(i % k == 0) {
                    isPrime = false;
                    break check;
                }
            }
            if(isPrime) {
                primeList.add(i);
            }
        }

        System.out.println(primeList);

    }
}
