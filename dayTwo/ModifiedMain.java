package dayTwo;

class A2{
	public int a;
	public A2(int a) {
		System.out.println("A class constructor called...");
		this.a=a;
	}
	public void show() {
		System.out.println("value of a is "+a);
	}
}

class B2{
	public int b;
	public B2(int b) {
		System.out.println("B class constructor called...");
		this.b=b;
	}
	public void show() {
		System.out.println("value of b is "+b);
	}
}

class C1 extends A2{
	public int c;
	public B2 b=new B2(2);
	public C1(int a,int c) {
		super(a);
		this.c=c;
	}
	public void show() {
		System.out.println("value of a is "+a);
		System.out.println("value of c is "+c);
	}
}

public class ModifiedMain {
	public static void main(String[] args) {
		C1 c=new C1(1,3);
		c.show();
		c.b.show();
	}
}