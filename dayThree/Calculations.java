package dayThree;

interface calcArea{
	public double area();
}

interface calcVolume{
	public double volume();
}

class Circle implements calcArea{
	public double radius;
	
	public Circle(double radius) {
		this.radius=radius;
	}
	
	@Override
	public double area() {
		return 3.14*radius*radius;
	}
}

class Square implements calcArea{
	public double side;
	
	public Square(double side) {
		this.side=side;
	}
	
	@Override
	public double area() {
		return side*side;
	}
}

class Triangle implements calcArea{
	public double base;
	public double height;
	
	public Triangle(double base,double height) {
		this.base=base;
		this.height=height;
	}
	
	@Override
	public double area() {
		return 0.5*base*height;
	}
}

class Sphere extends Circle implements calcVolume{
	public Sphere(double radius) {
		super(radius);
	}

	@Override
	public double volume() {
		return 4/3*3.14*radius*radius*radius;
	}
}

class Cuboid extends Square implements calcVolume{
	public Cuboid(double side) {
		super(side);
	}

	@Override
	public double volume() {
		return side*side*side;
	}
}

public class Calculations {
	public static void main(String[] args) {
		Circle circle=new Circle(10);
		System.out.println("The area of circle is "+circle.area());
		
		Square square=new Square(10);
		System.out.println("The area of square is "+square.area());
		
		Triangle triangle=new Triangle(10,5);
		System.out.println("The area of traingle is "+triangle.area());
		
		Sphere sphere=new Sphere(10);
		System.out.println("The area of sphere is "+sphere.area());
		System.out.println("The volume of sphere is "+sphere.volume());
		
		Cuboid cuboid=new Cuboid(10);
		System.out.println("The area of cuboid is "+cuboid.area());
		System.out.println("The volume of cuboid is "+cuboid.volume());
	}
}
