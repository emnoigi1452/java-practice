// Calculate the sum of all digits from the inputted number
// Written in 10 minutes. Completed on 24/07/2020
// Tool : IntelliJ IDEA
// Code length : 16 lines


import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        System.out.print("Input integer: ");

        Scanner readInput = new Scanner(System.in);
        String num = Integer.toString(readInput.nextInt());

        int sum = 0;
        for(int i = 0; i < num.length(); ++i) {
            sum += Integer.parseInt(String.valueOf(num.charAt(i)));
        }

        System.out.println("Sum of all digits is: " + sum);
    }
}
