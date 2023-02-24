package dayFive;

class MyClass extends Thread{
	StringBuffer string;
	
	public MyClass(StringBuffer string) {
		this.string=string;
	}
	
	@Override
	public void run() {
		synchronized(string) {
			System.out.println(Thread.currentThread()+" : ");
			for(int i=0;i<100;i++) {
				try {
					System.out.print(string);
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println();
			string.replace(0, 1,""+(char)(string.charAt(0)+1));
		}
	}
}

public class LockDemo {
	public static void main(String[] args) {
		StringBuffer sb=new StringBuffer("A");
		MyClass object1=new MyClass(sb);
		MyClass object2=new MyClass(sb);
		MyClass object3=new MyClass(sb);
		object1.start();
		object2.start();
		object3.start();
	}
}
