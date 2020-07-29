/* Prime display - Exercise type 3 :
 * Display all prime numbers with n digits. n inputted by the user;
 * Code completed on 28/07/2020
*/


import java.util.Scanner;
import java.util.ArrayList;

class Main {
  private static Scanner reader;
  static int digitCount;

  public static void main(String[] args) {
    System.out.print("Input digit count: ");
    try {
      reader = new Scanner(System.in);
    }
    finally {
      digitCount = reader.nextInt();
    }

    ArrayList<Integer> primeList = new ArrayList<Integer>();

    int num = 0;

    main: for(num = 0; num < (int)Math.pow(10,( digitCount + 1)); num++) {
      int numDigitCount = num;
      int j = 0;
      for(j = 0; numDigitCount >= 1; j++) {
        numDigitCount /= 10;
      }
      if(j == digitCount) {
        int n = 2;
        boolean isPrime = true;
        check: for(n = 2; n <= num / 2; n++) {
          if(num % n == 0) {
            isPrime = false;
            break check;
          }
        }
        if(isPrime) {
          primeList.add(num);
        }
      }
    }
    for(Integer display: primeList) {
      System.out.print(display + ", ");
    }
  }
}
