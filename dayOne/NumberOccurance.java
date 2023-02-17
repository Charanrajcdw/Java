package dayOne;

import java.util.Scanner;

public class NumberOccurance {
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
	
	public static void findOccurances() {
		System.out.println("Enter the element to find no of occurances");
		int element=scan.nextInt();
		System.out.println("The element is present in indexes:");
		int occurances=0;
		int index=0;
		while(index<size) {
			if(numbers[index]==element) {
				System.out.println(index);
				occurances++;
			}
			index++;
		}
		System.out.println("The element is present "+occurances+" no of times");
	}
	
	public static void main(String[] args) {
		scan=new Scanner(System.in);
		getInput();
		findOccurances();
		scan.close();
	}
}
