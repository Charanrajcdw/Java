package dayOne;

import java.util.Scanner;

public class NumebrToWords {
	static int no;
	
	public static void reverse() {
		int sum=0;
		while(no>0) {
			sum=sum*10+no%10;
			no/=10;
		}
		no=sum;
	}
	
	public static void printWords() {
		String[] words= {"zero","one","two","three","four",
				"five","six","seven","eight","nine"};
		int temp=no;
		while(temp>0) {
			System.out.print(words[temp%10]+" ");
			temp/=10;
		}
	}
	
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the no:");
		no=scan.nextInt();
		reverse();
		printWords();
		scan.close();
	}
}
