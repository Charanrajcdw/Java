package dayOne;

import java.util.Scanner;

public class CalculateResult {
	static int studentSize;
	static int markSize;
	static int[][] marks;
	static Scanner scan;
	
	public static void getInput() {
		System.out.println("Enter the no of students:");
		studentSize=scan.nextInt();
		System.out.println("Enter the no of marks:");
		markSize=scan.nextInt();
		System.out.println("Enter the elements:");
		marks=new int[studentSize][markSize];
		for(int i=0;i<studentSize;i++)
			for(int j=0;j<markSize;j++)
				marks[i][j]=scan.nextInt();
	}
	
	public static void calculateResult() {
		for(int i=0;i<studentSize;i++) {
			int total=0;
			for(int j=0;j<markSize;j++)
				total+=marks[i][j];
			System.out.println();
			System.out.println("For student "+(i+1));
			System.out.println("Total marks:"+total);
			System.out.println("Average:"+total/markSize);
		}
				
	}
	
	public static void main(String[] args) {
		scan=new Scanner(System.in);
		getInput();
		calculateResult();
		scan.close();
	}
}
