import java.util.Scanner;

class Main {
    static void input1() {
        System.out.println("Input range begin: ");
    }
    static void input2() {
        System.out.println("Input range end: ");
    }
    static void invalid() {
        System.out.println("Invalid range! Has to be larger than 2 and 10 integers apart!");
    }

    private static Scanner input1;
    private static Scanner input2;
    static int begin;
    static int end;
    static int num;
    static int range;
    static boolean isPrime;

    public static void main(String[] args) {
        input1();
        try {
            input1 = new Scanner(System.in);
        }
        finally {
            begin = input1.nextInt();
        }

        input2();
        try {
            input2 = new Scanner(System.in);
        }
        finally {
            end = input2.nextInt();
        }

        if(begin < 2 || end - begin < 10) {
            invalid();
            System.exit(0);
        }
        range = end - begin;
        num = begin;
        for(int i = 0; i<range; i++) {
            isPrime = true;
            int n = 2;
            check: for(n = 2; n <= num / 2; ++n) {
                if(num % n == 0) {
                    isPrime = false;
                    break check;
                }
            }
            if(isPrime) {
                System.out.println(num);
            }
            num++;
        }

    }
}
