package dayFive;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class InventorySystem {
	public static void main(String[] args) {
		ExecutorService es=Executors.newFixedThreadPool(2);
		Inventory inventory=new Inventory();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the no of items...");
		int noOfItems=sc.nextInt();
		es.execute(()->{
			for(int i=0;i<noOfItems;i++)
			inventory.produce();
		});
		es.execute(()->{
			for(int i=0;i<noOfItems;i++)
			inventory.consume();
		});
		sc.close();
		es.shutdown();
	}
}

class Inventory{
	boolean flag=false;
	synchronized public void produce() {
		if(flag) {
			try{wait();}catch(Exception e) {}
		}
		System.out.println("item produced....");
		flag=true;
		notify();
	}
	
	synchronized public void consume() {
		if(!flag) {
			try{wait();}catch(Exception e) {}
		}
		System.out.println("item consumed.....");
		flag=false;
		notify();
	}
}
