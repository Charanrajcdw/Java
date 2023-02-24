package dayFive;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Numbers{
	synchronized public void printOdd() {
		System.out.println("The odd numbers are");
		int number=1;
		while(number<100) {
			System.out.println(number);
			number+=2;
		}
	}
	synchronized public void printEven() {
		System.out.println("The even numbers are");
		int number=2;
		while(number<=100) {
			System.out.println(number);
			number+=2;
		}
	}
}

public class OddOrEven {
	public static void main(String[] args) {
		Numbers number=new Numbers();
		ExecutorService es=Executors.newFixedThreadPool(2);
		es.execute(()->{
			number.printEven();
		});
		es.execute(()->{
			number.printOdd();
		});
		es.shutdown();
	}
}
