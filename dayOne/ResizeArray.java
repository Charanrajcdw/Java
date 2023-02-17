package dayOne;

import java.util.Arrays;
import java.util.Scanner;

public class ResizeArray {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int[] array=new int[5];
		System.out.println("Current length:"+array.length);
		System.out.println("Enter the new size");
		int size=scan.nextInt();
		array=Arrays.copyOf(array,size);
		System.out.println("Modified length:"+array.length);
		scan.close();
	}
}
