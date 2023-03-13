package files;

import java.io.FileReader;
import java.io.FileWriter;

public class CopyFile {
	public static void main(String[] args) {
		try (
				FileReader fis = new FileReader("./src/files/abc.txt");
				FileWriter fos = new FileWriter("./src/files/copy.txt");) {
			int n = 0;
			while ((n = fis.read()) != -1) {
				System.out.print((char) n);
				fos.write(n);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
