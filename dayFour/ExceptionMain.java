package dayFour;

class CustomException extends Exception{
	String msg;
	public CustomException(String msg) {
		this.msg=msg;
	}
	@Override
	public String toString() {
		return msg;
	}	
}

public class ExceptionMain {
	public static void main(String[] args) {
		try {
			throw new CustomException("custom exception...");
		}catch(CustomException ce) {
			System.out.println(ce);
		}
	}
}
//custom exception...