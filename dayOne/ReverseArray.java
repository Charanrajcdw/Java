package dayOne;

import java.util.Scanner;

public class ReverseArray {
	static int size;
	static int[] numbers;
	static Scanner scan;
	
	public static void getInput() {
		System.out.println("Enter the no of elements:");
		size=scan.nextInt();
		System.out.println("Enter the elements:");
		numbers=new int[size];
		for(int i=0;i<size;i++)
			numbers[i]=scan.nextInt();
	}
	
	public static void reverse() {
		for(int i=0;i<size/2;i++) {
			int temp=numbers[i];
			numbers[i]=numbers[size-i-1];
			numbers[size-i-1]=temp;
		}
		System.out.println("The reversed elements are:");
		for(int i:numbers)
			System.out.println(i);		
	}
	
	public static void main(String[] args) {
		scan=new Scanner(System.in);
		getInput();
		reverse();
		scan.close();
	}
}
