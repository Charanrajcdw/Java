package dayOne;

class ProtectedClass{
	protected int i=5;
}

public class ProtectedData {
	public static void main(String[] args) {
		ProtectedClass pc=new ProtectedClass();
		pc.i=10;
		System.out.println(pc.i);
	}
}
