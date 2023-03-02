package dayFive;

public class ThreadDemo extends Thread{
	@Override
	public void run() {
		System.out.println("Thread has started running...");
	}
	public static void main(String[] args) {
		ThreadDemo thread=new ThreadDemo();
		thread.start();
		thread.start();
	}
}

//Exception in thread "main" java.lang.IllegalThreadStateException