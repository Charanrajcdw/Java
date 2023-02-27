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
//	boolean flag=false;
	int item=0;
	synchronized public void produce() {
		if(item==1) {
			try{wait();}catch(Exception e) {}
		}
		item=1;
		System.out.println("items in the inventory....."+item);
		notify();
	}
	
	synchronized public void consume() {
		if(item==0) {
			try{wait();}catch(Exception e) {}
		}
		item=0;
		System.out.println("items in the inventory..."+item);
		notify();
	}
}
