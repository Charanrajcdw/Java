package files;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ImageCopy {
	public static void main(String[] args) {
		try (FileInputStream inputFile = new FileInputStream("./src/files/image.jpeg");
				FileOutputStream outputFile = new FileOutputStream("./src/files/image2.jpeg");) {
			System.out.println(inputFile.available());
			int n = 0;
			byte b[] = new byte[1024];
			while ((n = inputFile.read(b)) != -1) {
				String s = new String(b, 0, n);
				outputFile.write(b, 0, n);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			;
		}
	}
}
