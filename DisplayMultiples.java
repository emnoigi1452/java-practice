/*
Program written to display all multiples of 11 with 'n' digits
'n' is being inputted by user. n can only be selected from 2-10
*/

import java.util.Scanner;
import java.util.ArrayList;

class Main {
    public static void main(String[] args) {
        System.out.print("Input digit count: ");

        Scanner inputDigit = new Scanner(System.in);
        int n = inputDigit.nextInt();
        
        if(n >= 2 && n <= 10) {
            System.out.println("Verified value, calculating...");
        }
        else {
            System.out.println("Invalid value, n can only be numbers from 2-10");
        }

        ArrayList<Integer> numList = new ArrayList<Integer>();

        int j = 0; //Amount of digits
        int multiplier = 1; //Multiplier for 11

        for(int i = 0; j <= n; i++) {
            j = 0;
            int num = 11 * multiplier;
            int numDisplay = num;
            for (j = 0; num >= 1; j++) {
                num /= 10; //Count digits
            }
            if(j > n) {
                break;
            }
            else if (j < n) {
                multiplier++;
            }
            else if (j == n) {
                numList.add(numDisplay);
                multiplier++;
            }

        }

        System.out.println("Displaying all multiples of 11 with " + n + " digits: ");
        for (Integer integer : numList) {
            System.out.print(integer + ", ");
        }
    }
}
