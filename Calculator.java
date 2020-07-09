import java.util.Scanner;

class Calculator {
    static void inputCmd() {
        System.out.println("Welcome to the calculator!");
        System.out.println("Valid commands: start, quit");
        System.out.println("Input command: ");
    }
    static void expressionSelect() {
        System.out.println("Valid expressions: sum, subtract, multiply, \n" +
                " division, modulo, exponentiation, factorial, \n" +
                " sqrt, cbrt, random, prime");
        System.out.println("Input expression: ");
    }
    static void invalidCmd() {
        System.out.println("Command is invalid!");
    }
    static void invalidExp() {
        System.out.println("Invalid expression!");
    }
    static void input1() {
        System.out.println("Input first number: ");
    }
    static void input2() {
        System.out.println("Input second number: ");
    }
    static void inputVal() {
        System.out.println("Input number: ");
    }
    static void invalidVal() {
        System.out.println("Invalid value! Unable to process input!");
    }
    static void regen() {
        System.out.println("Type 'reg' to regenerate a new random int");
    }
    static void base() {
        System.out.println("Input base number: ");
    }
    static void power() {
        System.out.println("Input power value: ");
    }
    static void display1(double result) {
        System.out.println("The result is: ");
    }
    static void display2(double randomVal) {
        System.out.println("Your number is: ");
    }
    static void notPrime() {
        System.out.println("Number entered is not prime");
    }
    static void isPrime() {
        System.out.println("Number entered is prime");
    }

    private static Scanner cmd;
    private static Scanner exp;
    private static Scanner val1;
    private static Scanner val2;
    private static Scanner randomCmd;
    static String cmdInput;
    static String expSelect;
    static String randomCont;
    static double num1;
    static double num2;
    static double result;
    static double randomVal;

    public static void main(String[] args) {
        inputCmd();
        try {
            cmd = new Scanner(System.in);
        }
        finally {
            cmdInput = cmd.nextLine();
        }

        switch (cmdInput) {
            case "quit":
                System.out.println("Stopping calculator...");
                System.exit(0);
                break;
            case "start":
                expressionSelect();
                try {
                    exp = new Scanner(System.in);
                }
                finally {
                    expSelect = exp.nextLine();
                }
                switch (expSelect) {
                    case "sum":
                        input1();
                        try {
                            val1 = new Scanner(System.in);
                        } finally {
                            num1 = val1.nextDouble();
                        }

                        input2();
                        try {
                            val2 = new Scanner(System.in);
                        } finally {
                            num2 = val2.nextDouble();
                        }

                        result = num1 + num2;
                        display1(result);
                        break;

                    case "subtract":
                        input1();
                        try {
                            val1 = new Scanner(System.in);
                        } finally {
                            num1 = val1.nextDouble();
                        }

                        input2();
                        try {
                            val2 = new Scanner(System.in);
                        } finally {
                            num2 = val2.nextDouble();
                        }

                        result = num1 - num2;
                        display1(result);
                        break;

                    case "multiply":
                        input1();
                        try {
                            val1 = new Scanner(System.in);
                        } finally {
                            num1 = val1.nextDouble();
                        }

                        input2();
                        try {
                            val2 = new Scanner(System.in);
                        } finally {
                            num2 = val2.nextDouble();
                        }

                        if (num1 == 0 || num2 == 0)
                        {
                            System.out.println("Multiplying to 0, the result is 0 :/");
                        }
                        else {
                            result = num1 * num2;
                            display1(result);
                        }
                        break;

                    case "division":
                        input1();
                        try {
                            val1 = new Scanner(System.in);
                        }
                        finally {
                            num1 = val1.nextDouble();
                        }

                        input2();
                        try {
                            val2 = new Scanner(System.in);
                        }
                        finally {
                            num2 = val2.nextDouble();
                        }

                        if(num2 == 0)
                        {
                           invalidVal();
                           System.exit(0);
                        }
                        else if (num1 == 0) {
                            System.out.println("The result is 0 :/");
                        }
                        else {
                            result = num1 / num2;
                            display1(result);
                        }
                        break;

                    case "modulo":
                        input1();
                        try {
                            val1 = new Scanner(System.in);
                        }
                        finally {
                            num1 = val1.nextDouble();
                        }

                        input2();
                        try {
                            val2 = new Scanner(System.in);
                        }
                        finally {
                            num2 = val2.nextDouble();
                        }

                        if(num2 == 0)
                        {
                            invalidVal();
                            System.exit(0);
                        }
                        else if (num1 == 0) {
                            System.out.println("The result is 0 :/");
                        }
                        else {
                            result = num1 % num2;
                            display1(result);
                        }
                        break;

                    case "exponentiation":
                        base();
                        try {
                            val1 = new Scanner(System.in);
                        }
                        finally {
                            num1 = val1.nextDouble();
                        }

                        power();
                        try {
                            val2 = new Scanner(System.in);
                        }
                        finally {
                            num2 = val2.nextDouble();
                        }

                        result = Math.pow(num1, num2);
                        display1(result);
                        break;

                    case "factorial":
                        inputVal();
                        try {
                            val1 = new Scanner(System.in);
                        }
                        finally {
                            num1 = val1.nextDouble();
                        }

                        for (double j = num1; j >= 1; --j) {
                            result *= j;
                        }
                        display1(result);
                        break;

                    case "sqrt":
                        inputVal();
                        try {
                            val1 = new Scanner(System.in);
                        }
                        finally {
                            num1 = val1.nextDouble();
                        }

                        result = Math.sqrt(num1);
                        display1(result);
                        break;

                    case "cbrt":
                        inputVal();
                        try {
                            val1 = new Scanner(System.in);
                        }
                        finally {
                            num1 = val1.nextDouble();
                        }

                        result = Math.cbrt(num1);
                        display1(result);
                        break;

                    case "random":
                        input1();
                        try {
                            val1 = new Scanner(System.in);
                        }
                        finally {
                            num1 = val1.nextDouble();
                        }

                        input2();
                        try {
                            val2 = new Scanner(System.in);
                        }
                        finally {
                            num2 = val2.nextDouble();
                        }

                        randomVal = (int)Math.random() * ((num2 - num1) +1) + num1;
                        display2(randomVal);
                        break;

                    case "prime":
                        boolean notPrime = false;
                        inputVal();
                        try {
                            val1 = new Scanner(System.in);
                        }
                        finally {
                            num1 = val1.nextDouble();
                        }

                        check: for (int i = 2; i <= num1 / 2; ++i) {
                            if(num1 % i == 0) {
                                notPrime = true;
                                break check;
                            }
                        }
                        if(!notPrime) {
                            isPrime();
                        }
                        else {
                            notPrime();
                        }
                        break;

                    default:
                        invalidExp();
                        System.exit(0);
                        break;
                }
            default:
                invalidCmd();
                System.exit(0);
        }
    }
}
