import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Memento {
	public static void main(String[] args)throws Exception {
		Vehicle bike=new Vehicle();
		System.out.println("Petrol before trip...:"+bike.petrol);
		new WriteObject().writeObject(bike);
		System.out.println("Going for a long trip...");
		bike.longDrive();
		System.out.println("Petrol after trip..:"+bike.petrol);
		System.out.println("Retrieving object from saved file...");
		bike=new ReadObject().readObject("bike.dat");
		System.out.println("Petrol in the bike...:"+bike.petrol);
	}
}
class Vehicle implements Serializable{
	int petrol=50;
	void longDrive() {
		petrol-=30;
	}
}
class WriteObject {
	public void writeObject(Vehicle bike) throws Exception{
		ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("bike.dat"));
		oos.writeObject(bike);
	}
}
class ReadObject {
	public Vehicle readObject(String filename) throws Exception{
		ObjectInputStream ois=new ObjectInputStream(new FileInputStream(filename));
		return (Vehicle)ois.readObject();
	}
}




