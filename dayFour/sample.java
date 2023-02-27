package dayFour;

public class sample{
	public void mth1() throws Exception {
		mth2();
		System.out.println("caller");
	}
	public void mth2() throws Exception {
		try {
			throw new Exception("custom exception");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			System.out.println("finally-mth2");
		}
		System.out.println("method 2...");
	}
	public static void main(String[] args) throws Exception {
		sample s=new sample();
		s.mth1();
	}
}
//normal run:
//finally-mth2
//caller

//after adding exception
//finally-mth2
//Exception in thread "main" java.lang.Exception: custom exception

//after adding catch
//the code after try catch executes without program stopping