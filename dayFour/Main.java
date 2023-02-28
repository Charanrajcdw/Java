package dayFour;

import java.io.FileReader;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException  {
		FileReader fileReader = new FileReader("Test.txt");
		System.out.println(fileReader.read());
	}
}

// with throws
// Exception in thread "main" java.io.FileNotFoundException: Test.txt (No such file or directory)

// without throws
//Exception in thread "main" java.lang.Error: Unresolved compilation problems: 
//	Unhandled exception type FileNotFoundException