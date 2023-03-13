package files;

import java.io.File;

public class ListFiles {
	public static void main(String[] args) {
		File file = new File("./src/files");
		if (file.isDirectory()) {
			String[] files = file.list();
			System.out.println("The files in directory are...");
			for (String fileName : files)
				System.out.println(fileName);
		} else {
			System.out.println("Not a directory...");
		}
	}
}
