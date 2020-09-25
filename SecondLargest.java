public class Main {
    public static int secondLargest(int[] array) {
        if(array.length == 0) {
            System.out.println("Array is empty!");
            return -1;
        } else if(array.length == 1) {
            System.out.println("Array only has one element, returning...");
            return array[0];
        } else {
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
    }

    public static void main(String[] args) {
        int[] ar = {};
        System.out.println(secondLargest(ar));
    }
}
