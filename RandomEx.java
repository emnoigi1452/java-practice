import java.util.Scanner;
import java.util.ArrayList;

class Main {
    private static Scanner size;
    private static Scanner input;
    private static Scanner cmd;
    static int inputVal;
    static String command;
    static int n;
    static int i;
    
    static void inputSize() {
        System.out.println("Input array size: ");
    }
    
    static void input() {
        System.out.println("Input number in array, input 0 to stop.");
    }
    static void inputCmd() {
        System.out.println("Type 'sum' to calculate the sum of all elements in the array");
        System.out.println("Type 'even' to calculate the sum of all even elements in the array!");
        System.out.println("Input next command: ");
    }
    static void invalidCmd() {
        System.out.println("Invalid command!");
    }
    
    public static void main(String[] args) {
        inputSize();
        try {
            size = new Scanner(System.in); 
        }
        finally {
            i = size.nextInt();
        }
        input();
        
        ArrayList<Integer> arr1 = new ArrayList<Integer>(i);
        for(n = 0; n < i; ++n) {
            try {
                input = new Scanner(System.in);
            }
            finally {
                inputVal = input.nextInt();
            }
            
            arr1.add(inputVal);
        }
        inputCmd();
        try {
            cmd = new Scanner(System.in);
        }
        finally {
            command = cmd.nextLine();
        }
        switch(command) {
            case "sum":
                int total = 0;
                for(int j = 0; j < i; ++j) {
                    total += arr1.get(j);
                }
                System.out.println("Result is: " + total);
            case "even":
                int totalEven = 0;
                for(int k = 0; k < i; ++k) {
                    if(arr1.get(k) % 2 == 0) {
                        totalEven += arr1.get(k);
                    }
                }
                System.out.println("Result is: " + totalEven);
            default:
                invalidCmd();
        }
    }
}
