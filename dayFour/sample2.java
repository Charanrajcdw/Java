package dayFour;

public class sample2{
	public void mth1(){
		mth2();
		System.out.println("caller");
	}
	public void mth2(){
		try {
			System.exit(0);
		}
		finally {
			System.out.println("finally-mth2");
		}
	}
	public static void main(String[] args){
		sample2 s=new sample2();
		s.mth1();
	}
}

//nothing is printed