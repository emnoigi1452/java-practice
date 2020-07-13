package me.ductrader.main;
import java.util.Scanner;
import java.util.ArrayList;

class Main {
	static void inputCommand() {
		System.out.println("Input a command: ");
		System.out.println("(prime, odd, even, normal, quit)");
	}
	static void inputAmount() {
		System.out.println("Input number amount: ");
	}
	static void invalidCmd() {
		System.out.println("Invalid command!");
	}
	static void inputNextCmd() {
		System.out.println("Input your next option: ");
	}
	
	private static Scanner inputCmd;
	private static Scanner inputCmd2;
	private static Scanner inputNum;
	static String cmd;
	static String cmd2;
	static int j;
	static int num;
	
	public static void main(String[] args) {
		int n = 2;
		System.out.println("Welcome to the display machine!");
		System.out.println("The machine will display the sum of the first n <type> numbers");
		System.out.println("You can also select to display all the numbers!");
		System.out.println("n will be the number you entered");
		inputAmount();
		try {
			inputNum = new Scanner(System.in);
		}
		finally {
			j = inputNum.nextInt();
		}
		
		ArrayList<Integer> array1 = new ArrayList<Integer>(j);
		inputCommand();
		try {
			inputCmd = new Scanner(System.in);
		}
		finally {
			cmd = inputCmd.nextLine();		
		}
		
		int k = 0;
		num = 0;
		
		switch(cmd) {
		case "quit":
			System.out.println("Disabling machine..");
			System.exit(0);
			break;
		case "normal":
			for (k = 0; k < j; ++k) {
				num += k;
				array1.add(k);
			}
			System.out.println("Sum is: " + num);
			break;
		case "odd":
			int a = 0;
			while(k < j) {
				if(a % 2 == 1) {
					array1.add(a);
					num += a;
					k++;
				}
				a++;
			}
			System.out.println("Sum is: " + num);
			break;
		case "even":
			int b = 0;
			while(k < j) {
				if(b % 2 == 0) {
					array1.add(b);
					num += b;
					k++;
				}
				b++;
			}
			System.out.println("Sum is: " + num);
			break;
		case "prime":
			while (k < j) {
				int i = 2;
				boolean isPrime = true;
				check: for(i = 2; i <= n /2; ++i) {
					if(n % i == 0) {
						isPrime = false;
						break check;
					}
				}
				if(isPrime) {
					array1.add(n);
					num += n;
					k++;
				}
				n++;
			}
			System.out.println("Sum is: " + num);
			break;
			
		default:
			invalidCmd();
			System.exit(0);
		}
		
		System.out.println("Type 'quit' to stop, type 'display' to display all the integers");
		inputNextCmd();
		try {
			inputCmd2 = new Scanner(System.in);
		}
		finally {
			cmd2 = inputCmd2.nextLine();
		}
		switch(cmd2) {
		case "quit":
			System.out.println("Disabling machine...");
			System.exit(0);
			break;
		case "display":
			System.out.println("Displaying " + j + " integers...");
			System.out.println(array1);
			System.exit(0);
			break;
		}
		
		
	}
}
