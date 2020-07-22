// Calculate the price of the message sent
// Formula : 10 cents x <character amount>
/* Note : The price of the message won't calculate any duplicate values
   or spacebar input. ex: ' '
*/

import java.util.Scanner;
import java.util.ArrayList;

class Main {
    public static void main(String[] args) {
        System.out.print("Input message: ");

        Scanner inputMsg = new Scanner(System.in);
        String msg = inputMsg.nextLine();

        ArrayList<Character> charList = new ArrayList<Character>();
        for(int i = 0; i < msg.length(); ++i) {
            if(!(msg.charAt(i) == ' ')) {
                charList.add(msg.charAt(i));
            }
        }
        for(int j = 0; j < charList.size(); ++j) {
            for(int k = j + 1; k < charList.size(); ++k) {
                if(charList.get(j).equals(charList.get(k))) {
                    charList.remove(j);
                }
            }
        }

        double msgPrice = 10 * charList.size();
        System.out.println("Message price: " + msgPrice);
    }
}
