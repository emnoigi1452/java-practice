package test;

import java.util.Scanner;

public class Methods {
	
	static void end() {
		System.out.println("Ending program...");
	}
	
	static void invalid() {
		System.out.println("Invalid command/expression...");
	}
	
	static void input1() {
		System.out.println("Please enter the first number: ");
	}
	
	static void input2() {
		System.out.println("Please enter the second number: ");
	}
	
	static void invalidNum() {
		System.out.println("The number inputted has an invalid value!");
	}
	
	static void credits()
	{
		System.out.println("");
		System.out.println("Program by: emnoigi1452");
		System.out.println("Tool: Eclipse IDE (March 2020)");
		System.out.println("Platform: Java 8 - 64 bit");
		System.out.println("Goodbye...");
	}
	
	private static Scanner command1;
	private static Scanner expression1;
	private static Scanner num1;
	private static Scanner num2;
	static String commandInput;
	static String expressionSelection;
	static double numX;
	static double numY;
	static double valueZ;
	
	public static void main(String[] args) {
		System.out.println("Welcome to the calculator");
		System.out.println("Please enter a command: ");
		System.out.println("Valid commands: calc, quit, leave, start");
		
		try {
			command1 = new Scanner(System.in);
		}
		finally {
			commandInput = command1.nextLine();
		}
		
		if(commandInput.equals("leave") || commandInput.equals("quit")) {
			end();
			System.exit(0);
		}
		
		else if (!(commandInput.equals("start") || commandInput.equals("calc"))) {
			invalid();
			end();
			System.exit(1);
		}
		
		else {
			System.out.println("Please select an expression: ");
			System.out.println("sum, subtract, multiply, division, modulo, power");
			
			try {
				expression1 = new Scanner(System.in);
			}
			finally {
				expressionSelection = expression1.nextLine();
			}
			
			if (!(expressionSelection.equals("sum") || expressionSelection.equals("subtract") || expressionSelection.equals("multiply") || expressionSelection.equals("division") || expressionSelection.equals("modulo") || expressionSelection.equals("power") )) {
				invalid();
				end();
				System.exit(2);
			}
			
			else if (expressionSelection.equals("sum")) {
				input1();
				
				try {
					num1 = new Scanner(System.in);
				}
				finally {
					numX = num1.nextDouble();
				}
				
				input2();
				
				try {
					num2 = new Scanner(System.in);
				}
				finally {
					numY = num2.nextDouble();
				}
				
				valueZ = numX + numY;
				System.out.println("The result is: " + valueZ);
			}
			
			else if (expressionSelection.equals("subtract")) {
				input1();
				
				try {
					num1 = new Scanner(System.in);
				}
				finally {
					numX = num1.nextDouble();
				}
				
				input2();
				
				try {
					num2 = new Scanner(System.in);
				}
				finally {
					numY = num2.nextDouble();
				}
				
				valueZ = numX - numY;
				System.out.println("The result is: " + valueZ);
			}
			
			else if (expressionSelection.equals("multiply")) {
				input1();
				
				try {
					num1 = new Scanner(System.in);
				}
				finally {
					numX = num1.nextDouble();
				}
				
				input2();
				
				try {
					num2 = new Scanner(System.in);
				}
				finally {
					numY = num2.nextDouble();
				}
				
				valueZ = numX * numY;
				if (numY == 0 || numX == 0) {
					System.out.println("Literally a multiplication with 0 -.-");
				}
				System.out.println("The result is: " + valueZ);
			}
			
			else if (expressionSelection.equals("division")) {
				input1();
				
				try {
					num1 = new Scanner(System.in);
				}
				finally {
					numX = num1.nextDouble();
				}
				
				input2();
				
				try {
					num2 = new Scanner(System.in);
				}
				finally {
					numY = num2.nextDouble();
				}
				
				if (numY == 0) {
					invalidNum();
					end();
					System.exit(3);
				}
				
				else {
					valueZ = numX / numY;
					System.out.println("The result is: " + valueZ);
				}
			}
			
			else if (expressionSelection.equals("modulo")) {
				input1();
				
				try {
					num1 = new Scanner(System.in);
				}
				finally {
					numX = num1.nextDouble();
				}
				
				input2();
				
				try {
					num2 = new Scanner(System.in);
				}
				finally {
					numY = num2.nextDouble();
				}
				
				if(numY == 0) {
					invalidNum();
					end();
					System.exit(4);
				}
				else {
					valueZ = numX / numY;
					System.out.println("The result is: " + valueZ);
				}
			}
			
			else if (expressionSelection.equals("power")) {
				input1();
				
				try {
					num1 = new Scanner(System.in);
				}
				finally {
					numX = num1.nextDouble();
				}
				
				input2();
				
				try {
					num2 = new Scanner(System.in);
				}
				finally {
					numY = num2.nextDouble();
				}
				
				if(numY != 0 || numY > 0) {
					System.out.println("The value shall be a positive integer!");
				}
				else if(numY != 0 || numY < 0) {
					System.out.println("The value shall be a decimal value!");
				}
				else {
					System.out.println("The power of every number to 0 will always be 1");
				}
				
				valueZ = Math.pow(numX, numY);
				System.out.println("The result is: " + valueZ);
			}
		}
		
		credits();
		System.exit(5);
		
	}

}
