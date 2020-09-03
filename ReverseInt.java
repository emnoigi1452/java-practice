import java.util.Scanner;

class Main {
    static int reverse(int given) {
        String givenAsString = Integer.toString(given);
        String reverse = "";
        if(given < 0) {
            givenAsString = givenAsString.replace("-", "");
        }
        for(int i = givenAsString.length() - 1; i >= 0; i--) {
            reverse += givenAsString.charAt(i);
        }

        if(given < 0) {
            return Integer.parseInt(reverse) * (-1);
        }
        else {
            return Integer.parseInt(reverse);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input: ");
        int r = Integer.parseInt(sc.nextLine());
        System.out.println("Output: " + reverse(r));
    }
}
