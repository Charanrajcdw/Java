package files;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MarkAndReset {
	public static void main(String[] args) {
		FileInputStream inputStream;
		BufferedInputStream bufferedInputStream;
		try {
			inputStream = new FileInputStream("./src/files/file.txt");
			bufferedInputStream = new BufferedInputStream(inputStream);
			for (int i = 0; i < 3; i++)
				System.out.println((char) bufferedInputStream.read());
			bufferedInputStream.mark(5);
			System.out.println("marking...");
			for (int i = 0; i < 3; i++)
				System.out.println((char) bufferedInputStream.read());
			bufferedInputStream.reset();
			System.out.println("resetting...");
			System.out.println((char) bufferedInputStream.read());
			System.out.println((char) bufferedInputStream.read());
			bufferedInputStream.mark(0);
			System.out.println("marking...");
			for (int i = 0; i < 3; i++)
				System.out.println((char) bufferedInputStream.read());
			bufferedInputStream.reset();
			System.out.println("resetting...");
			for (int i = 0; i < 3; i++)
				System.out.println((char) bufferedInputStream.read());

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
