package dayFour;

public class sample{
	public void mth1() throws Exception {
		mth2();
		System.out.println("caller");
	}
	public void mth2() throws Exception {
		try {
			throw new Exception("custom exception");
//			return;
		}
		finally {
			System.out.println("finally-mth2");
		}
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