package car;

import vehicle.FourWheeler;

class Car extends FourWheeler{
	@Override
	public void getDetails() {
		System.out.println("This is a car...");
	}
}

public class CarCompany {
	public static void main(String[] args) {
		Car car=new Car();
		car.getDetails();
	}
}
