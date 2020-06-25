package test;

import java.util.Scanner;

public class SumPow {
	
	private static Scanner input;
	private static Scanner pow;
	static double inputValue;
	static double endPow;
	static double count;
	static double result;
	
	static void input1() {
		System.out.println("Please enter a base number: ");
	}
	
	static void input2() {
		System.out.println("Please enter final power value: ");
	}
	
	static void resultDisplay(double result2) {
		System.out.println("Result is: ");
	}
	
	public static void main(String[] args) {
		input1();
		try {
			input = new Scanner(System.in);
		}
		finally {
			inputValue = input.nextDouble();
		}
		
		input2();
		try {
			pow = new Scanner(System.in);
		}
		finally {
			endPow = pow.nextDouble();
		}
		
		count = 0;
		
		while (count <= endPow) {
			result += Math.pow(inputValue, count);
			count++;
		}
		
		resultDisplay(result);
		System.exit(0);
	}

}
