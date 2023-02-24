package dayTwo;

class Door{
	public double area;
	
	public Door(double area) {
		this.area=area;
	}
	
	public double calculateCost() {
		return area*200;
	}
}

class Window{
	public double area;
	
	public Window(double area) {
		this.area=area;
	}
	
	public double calculateCost() {
		return area*100;
	}
	
}

class House{
	public Door door;
	public Window window;
	
	public House(double doorArea,double windowArea) {
		door=new Door(doorArea);
		window=new Window(windowArea);
	}
	
	public double totalCost() {
		return door.calculateCost()+window.calculateCost();
	}
}

public class HouseCost {
	public static void main(String[] args) {
		House house=new House(1500,600);
		System.out.println("The total cost of house is "+house.totalCost());
	}
}
