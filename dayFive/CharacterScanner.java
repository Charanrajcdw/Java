package dayFive;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class NotAlphabetException extends Exception {
	String msg;

	public NotAlphabetException(String msg) {
		super(msg);
		this.msg = msg;
	}

	@Override
	public String toString() {
		return msg;
	}
}

class Characters {
	public int count;
	public Scanner scan;
	public char character;

	public Characters() {
		count = 0;
	}

	public void getCharacter() {
		while (true) {
			System.out.println("Enter a character:");
			character = scan.next().charAt(0);
			if (character == '*') {
				System.out.println("Program ended...\nNo of alphabets entered: " + count);
				scan.close();
				break;
			} else {
				try {
					if (!((character >= 'a' && character <= 'z') || (character >= 'A' && character <= 'Z')))
						throw new NotAlphabetException("It is not a alphabet...");
					else
						count++;
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		}

	}
}

public class CharacterScanner {
	public static void main(String[] args) {
		Characters characters = new Characters();
		characters.scan = new Scanner(System.in);
		ExecutorService es = Executors.newFixedThreadPool(1);
		System.out.println("Enter * to stop");
		es.execute(() -> {
			characters.getCharacter();
		});
		es.shutdown();
	}
}
