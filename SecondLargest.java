package me.ductrader.javapractice;

public class Main {
    public static int secondLargest(int[] array) {
        int largest = array[0];
        int second = array[0];
        for(int i = 0; i < array.length; i++) {
            if(array[i] > largest) {
                largest = array[i];
            }
        }
        for(int i = 0; i < array.length; i++) {
            if(array[i] > second && array[i] < largest) {
                second = array[i];
            }
        }
        return second;
    }

    public static void main(String[] args) {
        int[] ar = {0,1,2,3,4};
        System.out.println(secondLargest(ar));
    }
}
