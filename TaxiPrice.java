/*
Calculate the price of your trip based on the amount of km (int) inputted
The first km : 15000VND
From 2-10km : 14000VND/km
From 10km onwards : 12000VND/km
*/

import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        System.out.print("Input traveled distance: ");
        Scanner sc = new Scanner(System.in);
        int distanceX = sc.nextInt();

        if(distanceX < 1) {
            System.out.println("Distance traveled can't be smaller than 1!");
        }

        int taxiPrice = 0;

        for(int i = 1; i <= distanceX; ++i) {
            if(i == 1) {
                taxiPrice += 15000;
            }
            else if (i >= 2 && i <= 10) {
                taxiPrice += 14000;
            }
            else {
                taxiPrice += 12000;
            }
        }

        System.out.println("Your trip took " + taxiPrice + " VND");

    }
}
