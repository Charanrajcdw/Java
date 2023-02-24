package dayTwo;

class DummyClass{
	static int count;
	
	static {
		count=0;
	}
	
	public DummyClass() {
		count++;
	}
	
	public int getCount() {
		return count;
	}
}

public class CountObjects {
	public static void main(String[] args) {
		DummyClass dc1=new DummyClass();
		DummyClass dc2=new DummyClass();
		System.out.println(dc1.getCount());
		DummyClass dc3=new DummyClass();
		DummyClass dc4=new DummyClass();
		System.out.println(dc1.getCount());
		DummyClass dc5;
		DummyClass dc6;
		System.out.println(dc1.getCount());
	}
}
