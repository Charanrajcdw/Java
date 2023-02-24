package dayOne;

//protected class base{
class base{
	String method() {
		return "Wow";
	}
}

class derived{
	public void useD() {
		base z=new base();
		System.out.println("base says, "+z.method());
	}
}

public class FindResult {
	public static void main(String[] args) {
		derived d=new derived();
		d.useD();
	}
}

//output:classes can be only public, abstract & final