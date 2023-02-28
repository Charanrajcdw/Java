package creationalPattern;

abstract class Laptop{
	public abstract void work();
}

class LenovoLaptop extends Laptop{
	@Override
	public void work() {
		System.out.println("Lenovo laptop made...");
	}
}

class DellLaptop extends Laptop{
	@Override
	public void work() {
		System.out.println("Dell laptop made...");
	}
}

class LaptopFactory {
	public static Laptop getLaptop(String name) {
		if(name.equals("Lenovo"))
			return new LenovoLaptop();
		else if(name.equals("Dell"))
			return new DellLaptop();
		else
			return null;
	}
}

public class FactoryPattern {
	public static void main(String[] args) {
		Laptop myLaptop=LaptopFactory.getLaptop("Dell");
		myLaptop.work();
	}
}
