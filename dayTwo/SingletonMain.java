package dayTwo;

class SingletonClass{
	public static SingletonClass instance=null;
	
	private SingletonClass() {
		System.out.println("Singleton class created...");
		instance=this;
	}
	
	public static SingletonClass getInstance() {
		System.out.println("Get Instance method called...");
		return instance==null?new SingletonClass():instance;
	}
}

public class SingletonMain {
	public static void main(String[] args) {
		SingletonClass sc1=SingletonClass.getInstance();
		SingletonClass sc2=SingletonClass.getInstance();
	}
}
