package dayFour;

class CustomException1 extends Exception{
	String msg;
	public CustomException1(String msg) {
		this.msg=msg;
	}
	@Override
	public String toString() {
		return msg;
	}	
}

public class ExceptionMain2 {
	public static void main(String[] args) throws CustomException1 {
		throw new CustomException1("custom exception...");
	}
}

//Exception in thread "main" custom exception...
