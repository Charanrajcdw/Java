package dayFive;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Printer{
	public int count;
	public Printer() {
		count=1;
	}
	public void updateCount() {
		while(count<=100) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(count);
			if(count%10==0)
				print();
			count++;
		}
	}
	public void print() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(count+" numbers reached...");
	}
}

public class StringPrint {
	public static void main(String[] args) {
		Printer printer=new Printer();
		ExecutorService es=Executors.newFixedThreadPool(1);
		es.execute(()->{
			printer.updateCount();
		});
		es.shutdown();
	}
}
