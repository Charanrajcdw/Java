package dayTwo;

class Dummy{
	int a;
	
	public Dummy(int a) {
		this.a=a;
	}
	
	public void show() {
		System.out.println("Value of a is "+a);
	}
}

public class FinalModify {
	public static void main(String[] args) {
		final Dummy d1=new Dummy(5);
		d1.show();
		d1.a=10;
		d1.show();
	}
}
