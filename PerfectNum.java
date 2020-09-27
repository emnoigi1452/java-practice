import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

class Main {
  public static void checkPerfect(int num) {
    // Create a statement to prevent errors from occuring
    /* Since the smallest perfect integer is 6, this statement
     * should prevent errors */
    if(num < 6) {
      System.out.println("Number isn't perfect!");
    } else {
      /* Generate a list of divisors
       Using List, or ArrayList
    */
    List<Integer> divs = new ArrayList<>();
    for(int j = 1; j <= num / 2; j++) {
      if(num % j == 0) {
        divs.add(j);
      }
    }
    // Create algorithm to check if the number is perfect or not
    int s = 0;
    for(Integer d: divs) {
      s += d;
    }
    if(s == num) {
      System.out.println("Number is perfect!");
    } else {
      System.out.println("Number isn't perfect!");
    }
    }
  }
  public static void main(String[] args) {
    Scanner read = new Scanner(System.in);
    System.out.print("Input number: ");
    int k = 0; String j = read.nextLine();
    try {
      k = Integer.parseInt(j);
    } catch(NumberFormatException e) {
      System.out.println("Error! Input is not integer!");
      System.out.println(e);
      System.exit(-1);
    }
    checkPerfect(k);
  }
}
