package files;

import java.util.Scanner;

public class CountWords {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int count = 0;
		while (scan.hasNextLine()) {
			String line = scan.nextLine();
			String[] words = line.split("\\s+");
			count += words.length;
		}
		System.out.println("The number of characters entered is " + count);
	}
}
