package files;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

public class DateObject {
	public static void main(String[] args) {
		try {
			Date date = new Date();
			ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("./src/files/abc.txt"));
			output.writeObject(date);
			ObjectInputStream input = new ObjectInputStream(new FileInputStream("./src/files/abc.txt"));
			Date date2 = (Date) input.readObject();
			System.out.println(date2);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
