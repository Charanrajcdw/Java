package dayFour;

class Base{
	public Base() throws Exception {
		System.out.println("Base constructor...");
		throw new Exception("Exception in base class");
	}
}

class Derived extends Base{
	public Derived() throws Exception{
		try{
			Base b=new Base();
		}catch(Exception e) {
			System.out.println(e);
		}
		System.out.println("Derived constructor...");
	}
}

public class ConstructorException{
	public static void main(String[] args) throws Exception{
		Derived derived=new Derived();			
	}
}

//Base constructor...
//Exception in thread "main" java.lang.Exception: Exception in base class
//base class exception is thrown to derived class 
//but cannot be handled since super() must be first line in the method