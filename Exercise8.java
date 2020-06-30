import java.util.Scanner;
class Main {
    static void input() {
        System.out.println("Input a number: ");
    }
    static void display(double x, double xCube) {
        System.out.println("Number is " + x + " and cube is " + xCube);
    }

    private static Scanner input;
    static double xLimit;
    static double x = 1;
    static double xCube;


    public static void main(String[] args) {
        input();
        try {
            input = new Scanner(System.in);
        }
        finally {
            xLimit = input.nextDouble();
        }

        while (x <= xLimit)
        {
            xCube = Math.pow(x,3);
            display(x, xCube);
            x++;
        }
        System.exit(0);
    }

}
