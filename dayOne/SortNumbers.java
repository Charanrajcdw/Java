package dayOne;

import java.util.Scanner;

public class SortNumbers {
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
	
	public static void sort() {
		for(int i=0;i<size;i++)
			for(int j=0;j<i;j++)
				if(numbers[i]<numbers[j]) {
					int temp=numbers[i];
					numbers[i]=numbers[j];
					numbers[j]=temp;
				}		
	}
	
	public static void print() {
		System.out.println("Ascending order:");
		for(int i:numbers)
			System.out.println(i);
		System.out.println("Descending order:");
		for(int i=size-1;i>=0;i--)
			System.out.println(numbers[i]);		
	}
	
	public static void main(String[] args) {		
		scan=new Scanner(System.in);
		getInput();
		sort();
		print();
		scan.close();
	}
}
