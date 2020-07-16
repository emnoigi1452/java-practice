//Replace all prime values in the array with 0
//Generate the array with 35 elements placed in 5 rows
//Completed on 16/07/2020
//Version : 1.0

class Main {
    public static void main(String[] args) {
        int[][] array = new int[5][7];
        for(int n = 0; n < 5; ++n) {
            for(int i = 0; i < 7; ++i) {
                int random = (int)(Math.random() * ((35 - 1) + 1)) + 1;
                array[n][i] = random;
            }
        }
        for(int j = 0; j < 5; ++j) {
            for(int k = 0; k < 7; ++k) {
                int num = array[j][k];
                int y = 2;
                boolean notPrime = false;
                while(y <= num / 2) {
                    if(num % y == 0) {
                        notPrime = true;
                        break;
                    }
                    y++;
                }
                if(!notPrime) {
                    array[j][k] = 0;
                }
            }
        }
        for(int a = 0; a < 5; ++a) {
            for (int b = 0; b < 7; ++b) {
                System.out.print(array[a][b] + " ");
            }
            System.out.println("");
        }
    }
}
