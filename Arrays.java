import java.util.Arrays;

class Main {
  static int[] copy(int[] arrayToCopy) {
    int[] arrayCopied = new int[arrayToCopy.length];
    for(int i = 0; i < arrayToCopy.length; i++) {
      arrayCopied[i] = arrayToCopy[i];
    }
    return arrayCopied;
  }

  static int[] reverseCopy(int[] arrayToReverse) {
    int[] reversedArray = new int[arrayToReverse.length];
    for(int j = arrayToReverse.length - 1; j >= 0; j--) {
      reversedArray[Math.abs(j - (arrayToReverse.length - 1))] = arrayToReverse[j];
    }
    return reversedArray;
  }

  public static void main(String[] args) {
    int[] array = {1, 2, 3, 4};
    System.out.println("Original: " + Arrays.toString(array));

    int[] copied = copy(array);
    System.out.println("Copy: " + Arrays.toString(copied));

    int[] reversed = reverseCopy(array);
    System.out.println("Reversed: " + Arrays.toString(reversed));
  }

}
