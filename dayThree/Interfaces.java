package dayThree;

interface Interface1{
	public void methoda1();
	public void methoda2();
}

interface Interface2{
	public void methodb1();
	public void methodb2();
}

interface Interface3{
	public void methodc1();
	public void methodc2();
}

interface InterfaceAll extends Interface1,Interface2,Interface3{
	public void method();
}

class BaseClass{
	public void classmethod() {
		System.out.println("Method from class...");
	}
}

class DerivedClass extends BaseClass implements InterfaceAll{
	@Override
	public void method() {
		System.out.println("InterfaceAll method implemented...");
	}
	@Override
	public void methoda1() {
		System.out.println("Interface1 methoda1 implemented...");
	}
	@Override
	public void methoda2() {
		System.out.println("Interface1 methoda2 implemented...");		
	}
	@Override
	public void methodb1() {
		System.out.println("Interface1 methodb1 implemented...");
	}
	@Override
	public void methodb2() {
		System.out.println("Interface1 methodb2 implemented...");
	}
	@Override
	public void methodc1() {
		System.out.println("Interface1 methodc1 implemented...");	
	}
	@Override
	public void methodc2() {
		System.out.println("Interface1 methodc2 implemented...");			
	}
}

public class Interfaces {
	public static void method1(Interface1 obj) {
		obj.methoda1();
		obj.methoda2();
	}
	public static void method2(Interface2 obj) {
		obj.methodb1();
		obj.methodb2();
	}
	public static void method3(Interface3 obj) {
		obj.methodc1();
		obj.methodc2();
	}
	public static void method4(InterfaceAll obj) {
		obj.methoda1();
		obj.methoda2();
		obj.methodb1();
		obj.methodb2();
		obj.methodc1();
		obj.methodc2();
		obj.method();
	}
	public static void main(String[] args) {
		DerivedClass dc=new DerivedClass();
		method1(dc);
		method2(dc);
		method3(dc);
		method4(dc);
	}
}
