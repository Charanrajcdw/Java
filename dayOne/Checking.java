package dayOne;

public class Checking {
	static int staticVariable=10;
	
//	public Checking(int i) {
//		System.out.println("Got a argument"+i);
//	}
	
	public void nonStaticMethod() {
		System.out.println(staticVariable);
	}
	
	public static void main(String[] args) {
//		final int i=1;
//		i=3;
		
		
		Checking check=new Checking();
		check.nonStaticMethod();	
	}
}
