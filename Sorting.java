import java.util.Arrays;

class Main {
    static int smallest(int[] array) {
        int smallest = array[0];
        for(int i = 0; i < array.length; i++) {
            if(smallest > array[i]) {
                smallest = array[i];
            }
        }
        return smallest;
    }

    static int smallestIndexOff(int[] array) {
        int smallest = array[0];
        int index = 0;
        for(int i = 0; i < array.length; i++) {
            if(smallest > array[i]) {
                index = i;
            }
        }
        return index;
    }

    static int smallestFromIndex(int[] array, int index) {
        int smallest = array[index];
        for(int i = index; i < array.length; i++) {
            if(smallest > array[i]) {
                smallest = array[i];
            }
        }
        return smallest;
    }

    static void swap(int[] array, int index1, int index2) {
        int backup = array[index2];
        array[index2] = array[index1];
        array[index1] = backup;
    }

    static void sort(int[] array) {
        for(int i = 0; i < array.length; i++) {
            int backup = 0;
            int index = i;

            int smallest = array[i];
            for(int k = i; k < array.length; k++) {
                if(smallest > array[k]) {
                    smallest = array[k];
                    index = k;
                }
            }

            backup = array[i];
            array[i] = smallest;
            array[index] = backup;



            System.out.println(Arrays.toString(array));
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 9, 7, 6, 8, 3};
        System.out.println("Smallest: " + smallest(arr));
        System.out.println("Smallest's index: " + smallestIndexOff(arr));
        System.out.println("Smallest from: " + smallestFromIndex(arr, 3));
        swap(arr, 1, 3);
        System.out.println(Arrays.toString(arr));

        sort(arr);
    }
}
