package dayThree5;

public class Class implements Interface {
	@Override
	public void method1() {
		System.out.println("This is from method1...");
	}

	@Override
	public void method2() {
		System.out.println("This is from method2...");
	}

	@Override
	public void method3() {
		System.out.println("This is from method3...");
	}
	public static void main(String[] args) {
		Class c=new Class();
		c.method1();
		c.method2();
		c.method3();
	}
}
