package me.ductrader.main;

import java.util.Scanner;

class Scratch {
    static void inputCmd1() {
        System.out.println("Enter a command: ");
        System.out.println("Valid commands: sum, subtract, multiply, division, modulo, power, sqrt, curt");
    }
    static void input1() {
        System.out.println("Enter the first number: ");
    }
    static void input2() {
        System.out.println("Enter the second number: ");
    }
    static void inputRoot() {
        System.out.println("Enter the value you want to root: ");
    }
    static void resultIs() {
        System.out.println("The result is: ");
    }
    static void invalid() { System.out.println("Invalid command.."); }
    static void invalidValue() { System.out.println("Invalid value..."); }
    static void credits() {
        System.out.println("So yea i coded this because i'm still new to this");
        System.out.println("alright bye! :)");
    }

    private static Scanner input1;
    private static Scanner input2;
    private static Scanner inputRoot;
    private static Scanner command;
    static double inputValue1;
    static double inputValue2;
    static double rootValue;
    static double resultValue;
    static String cmdName;


    public static void main(String[] args) {
        inputCmd1();
        try {
            command = new Scanner(System.in);
        } finally {
            cmdName = command.nextLine();
        }

        if (!(cmdName.equals("sum") ||
                cmdName.equals("subtract") ||
                cmdName.equals("multiply") ||
                cmdName.equals("division") ||
                cmdName.equals("modulo") ||
                cmdName.equals("power") ||
                cmdName.equals("sqrt") ||
                cmdName.equals("curt"))) {
            invalid();
            System.exit(0);

        } else if (cmdName.equals("sum")) {
            input1();
            try {
                input1 = new Scanner(System.in);
            } finally {
                inputValue1 = input1.nextDouble();
            }

            input2();
            try {
                input2 = new Scanner(System.in);
            } finally {
                inputValue2 = input2.nextDouble();
            }

            resultValue = inputValue1 + inputValue2;
            resultIs();
            System.out.println(resultValue);
            
        } else if (cmdName.equals("subtract")) {
            input1();
            try {
                input1 = new Scanner(System.in);
            } finally {
                inputValue1 = input1.nextDouble();
            }

            input2();
            try {
                input2 = new Scanner(System.in);
            } finally {
                inputValue2 = input2.nextDouble();
            }

            resultValue = inputValue1 + inputValue2;
            resultIs();
            System.out.println(resultValue);
            
        } else if (cmdName.equals("multiply")) {
            input1();
            try {
                input1 = new Scanner(System.in);
            } finally {
                inputValue1 = input1.nextDouble();
            }

            input2();
            try {
                input2 = new Scanner(System.in);
            } finally {
                inputValue2 = input2.nextDouble();
            }

            resultValue = inputValue1 * inputValue2;

            if (inputValue1 == 0 || inputValue2 == 0) {
                System.out.println("You're literally multiplying a number to 0" +
                        " ,it's still going to end up being 0!");
            } else if (inputValue1 == 0 && inputValue2 == 0) {
                System.out.println("0 x 0 is 0, we don't need to calculate this, don't we ?");
            } else {
                resultIs();
                System.out.println(resultValue);
            }

        }
        else if (cmdName.equals("division")) {
            input1();
            try {
                input1 = new Scanner(System.in);
            } finally {
                inputValue1 = input1.nextDouble();
            }

            input2();
            try {
                input2 = new Scanner(System.in);
            } finally {
                inputValue2 = input2.nextDouble();
            }

            if (inputValue2 == 0) {
                invalidValue();
                System.exit(0);
            } else if (inputValue1 == 0) {
                System.out.println("0 dividing with any value except 0 would still be 0");
            } else {
                resultValue = inputValue1 / inputValue2;
                resultIs();
                System.out.println(resultValue);
            }
        }
        else if (cmdName.equals("modulo")) {
            input1();
            try {
                input1 = new Scanner(System.in);
            } finally {
                inputValue1 = input1.nextDouble();
            }

            input2();
            try {
                input2 = new Scanner(System.in);
            }
            finally {
                inputValue2 = input2.nextDouble();
            }

            if (inputValue2 == 0) {
                invalidValue();
                System.exit(0);
            }
            else if (inputValue1 == 0) {
                System.out.println("0 has no modulo against any number!");
            }
            else {
                resultValue = inputValue1 % inputValue2;
                resultIs();
                System.out.println(resultValue);
            }
        }

        else if(cmdName.equals("power")) {
            input1();
            try {
                input1 = new Scanner(System.in);
            }
            finally {
                inputValue1 = input1.nextDouble();
            }

            input2();
            try {
                input2 = new Scanner(System.in);
            }
            finally {
                inputValue2 = input2.nextDouble();
            }

            resultValue = Math.pow(inputValue1, inputValue2);
            resultIs();
            System.out.println(resultValue);
        }

        else if(cmdName.equals("sqrt")) {
            inputRoot();
            try {
                inputRoot = new Scanner(System.in);
            }
            finally {
                rootValue = inputRoot.nextDouble();
            }

            resultValue = Math.sqrt(rootValue);
            resultIs();
            System.out.println(resultValue);
        }

        else if(cmdName.equals("curt")) {
            inputRoot();
            try {
                inputRoot = new Scanner(System.in);
            }
            finally {
                rootValue = inputRoot.nextDouble();
            }

            resultValue = Math.cbrt(rootValue);
            resultIs();
            System.out.println(resultValue);
        }

        credits();
        System.exit(1);
    }
}
