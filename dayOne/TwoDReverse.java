package dayOne;

import java.util.Scanner;

public class TwoDReverse {
	static int rows;
	static int columns;
	static int[][] array;
	static Scanner scan;
	
	public static void getInput() {
		System.out.println("Enter the no of rows:");
		rows=scan.nextInt();
		System.out.println("Enter the no of columns:");
		columns=scan.nextInt();
		System.out.println("Enter the elements:");
		array=new int[rows][columns];
		for(int i=0;i<rows;i++)
			for(int j=0;j<columns;j++)
				array[i][j]=scan.nextInt();
	}
	
	public static void reverse(int size,int numbers[]) {
		for(int i=0;i<size/2;i++) {
			int temp=numbers[i];
			numbers[i]=numbers[size-i-1];
			numbers[size-i-1]=temp;
		}
	}
	
	public static void print() {
		for(int[] i:array) {
			for(int j:i)
				System.out.print(j+" ");
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		scan=new Scanner(System.in);
		getInput();
		for(int[] i:array)
		reverse(i.length,i);
		print();
		scan.close();
	}
}
