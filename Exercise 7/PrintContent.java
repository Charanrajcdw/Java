package files;

import java.io.FileReader;

public class PrintContent {
	public static void main(String[] args) {
		try (FileReader file = new FileReader("./src/files/abc.txt");) {
			int n = 0;
			while ((n = file.read()) != -1) {
				System.out.print((char) n);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			;
		}
	}
}
