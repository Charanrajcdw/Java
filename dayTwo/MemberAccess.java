package dayTwo;

class A1{
	public int a;
	protected int b;
	private int c;
	
	public A1(int a,int b,int c) {
		this.a=a;
		this.b=b;
		this.c=c;
	}
}

class B1 extends A1{
	public int d;
	
	public B1(int a,int b,int c,int d) {
		super(a,b,c);
		this.d=d;
	}
	
	public void show() {
		System.out.println("public a="+a);
		System.out.println("protected b="+b);
//		System.out.println("private c="+c);
//		can't access private member in derived class 
	}
}

public class MemberAccess {
	public static void main(String[] args) {
		B1 b=new B1(1,2,3,4);
		b.show();
	}
}
