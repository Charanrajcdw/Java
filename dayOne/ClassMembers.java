package dayOne;

class OuterClass {
	public int publicMember=1;
	protected int protectedMember=2;
	private int privateMember=3;
	int defaultMember=4;
	
	public void publicMethod() {
		System.out.println("This is inside of public method...");
	}
	protected void protectedMethod() {
		System.out.println("This is inside of protected method...");
	}
	private void privateMethod() {
		System.out.println("This is inside of private method...");
	}
	void defaultMethod() {
		System.out.println("This is inside of default method...");
	}
}

public class ClassMembers{
	public static void main(String[] args) {
		OuterClass oc=new OuterClass();
		System.out.println(oc.publicMember);
		System.out.println(oc.protectedMember);
//		System.out.println(oc.privateMember);
		System.out.println(oc.defaultMember);
		oc.publicMethod();
		oc.protectedMethod();
//		oc.privateMethod();
		oc.defaultMethod();
	}
}
