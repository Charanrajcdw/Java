package dayFive;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Numbers {
	boolean flag = true;

	synchronized public void printOdd() {
		int number = 1;
		try {
			while (number <= 100) {				
				if (!flag) {
					wait();
				} else {
					Thread.sleep(100);
					System.out.println(number);
					number += 2;
					flag = false;
					notify();
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	synchronized public void printEven() {
		int number = 2;
		try {
			while (number <= 100) {				
				if (flag) {
					wait();
				} else {
					Thread.sleep(100);
					System.out.println(number);
					number += 2;
					flag = true;
					notify();
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

public class OddOrEven {
	public static void main(String[] args) {
		Numbers number = new Numbers();
		ExecutorService es = Executors.newFixedThreadPool(2);
		System.out.println("The numbers from 1 to 100 are...");
		es.execute(() -> {
			number.printEven();
		});
		es.execute(() -> {
			number.printOdd();
		});
		es.shutdown();
	}
}
