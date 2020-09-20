package me.ductrader.javapractice;

import java.util.Scanner;

public class Main {
    public static int clockMovement(String movement, int num) {
        int edit = 0;
        if(movement.contains("+") || (movement.contains("-"))) {
            switch(movement.charAt(0)) {
                case '+':
                    edit = Integer.parseInt(movement.replace("+", ""));
                    if(edit >= 10000000) {
                        System.out.println("Số nhập vào không được lớn hơn 10^6");
                        System.exit(-1);
                    }
                case '-':
                    edit = Integer.parseInt(movement.replace("-", "")) * -1;
                    if(edit <= (10000000 * -1)) {
                        System.out.println("Số nhập vào không được nhỏ hơn -10^6");
                        System.exit(-1);
                    }
            }
            num += edit;
            if(num >= 0) {
                num %=  12;
            } else {
                num = Math.abs(num + 12) % 12;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        int clock = 1;
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập lệnh cử động kim đồng hồ: ");
        String mvm = sc.nextLine();
        clock = clockMovement(mvm, clock);
        if(clock % 12 == 0) {
            System.out.println("Kim đồng hồ đang chỉ số 12!");
        } else {
            System.out.println("Kim đồng hồ đang chỉ số " + clock +  "!");
        }
    }
}
