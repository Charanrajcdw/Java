package dayOne;

import java.util.Scanner;

public class TwoDMaximum {
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
	
	public static void findMaximum() {
		for(int i=0;i<rows;i++) {
			int max=array[i][0];
			for(int j=1;j<columns;j++)
				if(max<array[i][j])
					max=array[i][j];
			System.out.println("The maximum element in "+i+" row is "+max);
		}
	}
	
	public static void main(String[] args) {
		scan=new Scanner(System.in);
		getInput();
		findMaximum();
		scan.close();
	}
}
