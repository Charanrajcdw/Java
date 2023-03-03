package files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class CopyFileLines {
	public static void main(String[] args) {
		try (
				FileReader fileReader = new FileReader("./src/files/abc.txt");
				FileWriter fileWriter = new FileWriter("./src/files/copy.txt");
				BufferedReader input = new BufferedReader(fileReader);
				BufferedWriter output = new BufferedWriter(fileWriter);) {
			String line;
			while ((line = input.readLine()) != null) {
				System.out.println(line);
				output.write(line);
				output.newLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
