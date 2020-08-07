class Main {
  static void printArrays(int[] array) {
    for(int i = 0; i < array.length; i++) {
      for(int j = 0; j < array[i]; j++) {
        System.out.print("*");
      }
      System.out.println();
    }
  } 

  public static void main(String[] args) {
    int[] array1 = {5, 4, 6, 3, 2};
    printArrays(array1);
  }
}
