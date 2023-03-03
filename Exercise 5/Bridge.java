package patterns;

abstract class Shape {
	Color color;

	public Shape(Color color) {
		this.color = color;
	}

	public abstract void draw();
}

class Square extends Shape {
	public Square(Color color) {
		super(color);
	}

	@Override
	public void draw() {
		System.out.println("A " + color.getColor() + " square...");
	}
}

class Circle extends Shape {
	public Circle(Color color) {
		super(color);
	}

	@Override
	public void draw() {
		System.out.println("A " + color.getColor() + " circle...");
	}
}

interface Color {
	public String getColor();
}

class Red implements Color {
	@Override
	public String getColor() {
		return "red color";
	}
}

class Blue implements Color {
	@Override
	public String getColor() {
		return "blue color";
	}
}

public class Bridge {
	public static void main(String[] args) {
		Shape redSqaure = new Square(new Red());
		Shape blueCircle = new Circle(new Blue());
		redSqaure.draw();
		blueCircle.draw();
	}
}
