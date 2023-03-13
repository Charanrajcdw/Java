package files;

import java.io.File;
import java.io.IOException;

public class FileActions {
	public static void deleteFile(String fileName) {
		File file = new File(fileName);
		if (file.delete())
			System.out.println("File deleted");
		else
			System.out.println("File not deleted");
	}

	public static void renameFile(String oldName, String newName) {
		File oldFile = new File(oldName);
		File newFile = new File(newName);
		if (oldFile.renameTo(newFile))
			System.out.println("File renamed");
		else
			System.out.println("File not renamed");
	}

	public static void displaySize(String fileName) {
		File file = new File(fileName);
		System.out.println(file.length());
	}

	public static void main(String[] args) {
		File file = new File("./src/files/abc.txt");
		try {
			file.createNewFile();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		displaySize("./src/files/abc.txt");
		renameFile("./src/files/abc.txt", "./src/files/def.txt");
		deleteFile("./src/files/def.txt");
	}
}
