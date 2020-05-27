package math;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int firstNumber;
		int secondNumber;
		int thirdNumber;
		
		System.out.println("Chào mừng đến chương trình tính trung bình cộng!");
		System.out.println("Vui lòng nhập 3 số bạn muốn tính trung bình cộng.");
		
		System.out.println("Hãy nhập số thứ nhất: ");
		try(Scanner numberInput1 = new Scanner(System.in)){
			firstNumber = numberInput1.nextInt();
		}
		
		System.out.println("Hãy nhập số thứ hai: ");
		try(Scanner numberInput2 = new Scanner(System.in)){
			secondNumber = numberInput2.nextInt();
		}
		
		System.out.println("Hãy nhập số thứ ba: ");
		try(Scanner numberInput3 = new Scanner(System.in)){
			thirdNumber = numberInput3.nextInt();
		
		int averageValue = (firstNumber + secondNumber + thirdNumber) /3;
		System.out.println("Trung bình cộng ba số là: " + averageValue);
		
		}
		
		

	}

}
