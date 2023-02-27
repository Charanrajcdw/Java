package dayFour;

class Base{
	public Base() throws Exception {
		System.out.println("Base constructor...");
		throw new Exception("Exception in base class");
	}
}

class Derived extends Base{
	public Derived() throws Exception{
		super();
		System.out.println("Derived constructor...");
	}
}

public class ConstructorException{
	public static void main(String[] args){
		try {
			Derived derived=new Derived();						
		}catch(Exception exception) {
			System.out.println(exception.getMessage());
		}
	}
}