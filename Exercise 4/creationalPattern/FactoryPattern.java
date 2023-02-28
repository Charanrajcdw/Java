package creationalPattern;

abstract class Laptop {
	public abstract void work();
}

class LenovoLaptop extends Laptop {
	@Override
	public void work() {
		System.out.println("Working in Lenovo laptop...");
	}
}

class DellLaptop extends Laptop {
	@Override
	public void work() {
		System.out.println("Working in Dell laptop...");
	}
}

abstract class LaptopManufacturer {
	public abstract Laptop makeLaptop();
}

class LenovoManufacturer extends LaptopManufacturer {
	public LenovoManufacturer() {
	}

	@Override
	public Laptop makeLaptop() {
		return new LenovoLaptop();
	}
}

class DellManufacturer extends LaptopManufacturer {
	public DellManufacturer() {
	}

	@Override
	public Laptop makeLaptop() {
		return new DellLaptop();
	}
}

class Showroom {
	LaptopManufacturer laptopManufacturer;

	public LaptopManufacturer getLaptopManufacturer() {
		return laptopManufacturer;
	}

	public void setLaptopManufacturer(String name) {
		try {
			this.laptopManufacturer = (LaptopManufacturer) Class.forName("creationalPattern." + name + "Manufacturer")
					.getConstructor().newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Laptop getLaptop() {
		return getLaptopManufacturer().makeLaptop();
	}
}

public class FactoryPattern {
	public static void main(String[] args) {
		Showroom showroomA = new Showroom();
		showroomA.setLaptopManufacturer("Dell");

		Showroom showroomB = new Showroom();
		showroomB.setLaptopManufacturer("Lenovo");

		Laptop laptop = showroomB.getLaptop();
		laptop.work();
	}
}
