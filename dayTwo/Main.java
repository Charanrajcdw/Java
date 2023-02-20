package dayTwo;

class A{
	public A() {
		System.out.println("A class constructor called...");
	}
}

class B{
	public B() {
		System.out.println("B class constructor called...");
	}
}

class C extends A{
	B b=new B();
}

public class Main {
	public static void main(String[] args) {
		C c=new C();
	}
}
//implicitly calls base class A constructor
//class B constructor is called by creating instance inside C
