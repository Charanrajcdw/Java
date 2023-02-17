package dayOne;

import java.util.Scanner;

public class Average {
	static int no;
	static int[] numbers;
	
	public static void getInput() {		
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the no of elements:");
		no=scan.nextInt();
		System.out.println("Enter the elements:");
		numbers=new int[no];
		for(int i=0;i<no;i++)
			numbers[i]=scan.nextInt();
		scan.close();
	}
	
	public static void findAverage() {
		int total=0;
		for(int i:numbers)
			total+=i;
		float average=total/no;
		System.out.println("The average of given elements is "+average);
	}
	
	public static void main(String[] args) {
		getInput();
		findAverage();
	}
}
