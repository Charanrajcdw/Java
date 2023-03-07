package files;
import java.io.FileInputStream;

public class AvailableMethod {
	public static void main(String[] args) {
		try(FileInputStream file=new FileInputStream("./src/files/file.txt")){
			while(file.available()!=0) {
				System.out.print(file.available()+"   ");
				int n=file.read();
				System.out.println((char)n);
			}	
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}
