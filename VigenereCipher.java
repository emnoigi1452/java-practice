import java.util.*;
 
class Main {
	public static int index(char[] a, char c) {
		for(int k = 0; k < 26; k++) {
			if(a[k] == c) return k;
		} return -1;
	}
	public static void main(String[] args) {
		char[] cs = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
		'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    System.out.print("String to encrypt: ");
		Scanner sc = new Scanner(System.in); 
		String input = sc.nextLine().toLowerCase(); 
		int s = input.length(); 
		String key = ""; String generated = "";
		for(int a = 0; a < s; a++) {
			if(input.charAt(a) == ' ') { generated += " "; key += " "; continue; }
			key += cs[(int)(Math.random()*25)+1];
			int current_ind = index(cs,input.charAt(a)); 
			int new_ind = (current_ind)+index(cs,key.charAt(a));
			if(new_ind > 25) new_ind -= 26; generated += cs[new_ind];
		}
		System.out.println("Original text: " + input);
		System.out.println("Encrypted text: " + generated);
		System.out.println("Decipher key: " + key);
	}
}
