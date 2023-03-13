package files;

import java.util.Scanner;

public class CountCharacters {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int count = 0;
		while (scan.hasNext()) {
			String word = scan.next();
			count += word.length();
		}
		System.out.println("The number of characters entered is " + count);
	}
}
