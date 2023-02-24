package dayTwo;

class OrderClass{
	static {
		System.out.println("This is inside static block...");
	}
	
	public OrderClass(){
		System.out.println("This is inside constructor block...");
	}
	
	{
		System.out.println("This is inside instantiation block...");
	}
}

public class OrderOfInitialization {
	public static void main(String[] args) {
		OrderClass oc=new OrderClass();
	}
}
