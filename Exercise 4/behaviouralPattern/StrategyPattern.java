package behaviouralPattern;

import java.util.Scanner;

class Driver{
	Car car;
	
	public void setCar(Car car) {
		this.car=car;
	}
	
	public Car getCar() {
		return car;
	}
	
	public void drive() {
		car.move();
	}
}

abstract class Car{
	public abstract void move();
}

class SportsCar extends Car{
	public SportsCar() {
	}
	@Override
	public void move() {
		System.out.println("It's time to race...");
	}
}

class FamilyCar extends Car{
	public FamilyCar() {
	}
	@Override
	public void move() {
		System.out.println("Ready to go for a trip...");	
	}
}

class RoyalCar extends Car{
	public RoyalCar() {
	}
	@Override
	public void move() {
		System.out.println("Have a luxurious ride...");
	}
}

public class StrategyPattern {
	public static void main(String[] args) throws Exception{
		Driver driver=new Driver();
		Scanner sc=new Scanner(System.in);
		System.out.println("Available cars\n1.Sports\n2.Family\n3.Royal\nEnter the type of car to drive");
		driver.setCar((Car)Class.forName("behaviouralPattern."+sc.next()+"Car").getConstructor().newInstance());
		driver.drive();
		sc.close();
	}
}
