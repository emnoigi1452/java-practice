import java.util.ArrayList;

class Main {
    public static void main(String[] args) {
        ArrayList<Integer> intArray = new ArrayList<Integer>(6);
        for(int i = 0; i < 6; ++i) {
            int random = (int)(Math.random() * ((5 - 1) + 1)) + 1;
            intArray.add(random);
        }
        System.out.println(intArray);
        
        for(int j = 0; j < 6; ++j) {
            for(int k = j + 1; k < 6; ++k) {
                if(intArray.get(j).equals(intArray.get(k))) {
                    System.out.println(intArray.get(k) + " is the duplicate value");
                }
            }
        }
    }
}
