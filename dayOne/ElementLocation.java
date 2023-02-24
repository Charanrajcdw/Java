package dayOne;

import java.util.Scanner;

public class ElementLocation {
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
	
	public static void findLocation() {
		System.out.println("Enter the element to find location");
		int element=scan.nextInt();
		int index=0;
		while(index<size)
			if(numbers[index++]==element)
				break;
		System.out.println(index==size?"Element "+element+" not present":"The location of "+element+" is "+index);
	}
	
	public static void main(String[] args) {
		scan=new Scanner(System.in);
		getInput();
		findLocation();
		scan.close();
	}
}
