package dayThree6;

public class Class2 extends Class1{
	public void derivedClassMethod() {
		protectedMethod();
	}
	
	public static void main(String[] args) {
		Class2 obj=new Class2();
		obj.protectedMethod();
	}
}
