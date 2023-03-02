package creationalPattern;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Clone implements Cloneable {
	private static Clone clone;
	int a;

	private Clone() {
		System.out.println("Clone constructor called...");
	}

	synchronized public Clone createClone() {
		try {
			return (Clone) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	}

	synchronized public static Clone createInstance() {
		if (clone == null) {
			clone = new Clone();
			return clone;
		} else {
			return clone.createClone();
		}
	}

	public void setValue(int a) {
		this.a = a;
	}

	public int getValue() {
		return a;
	}
}

public class PrototypePattern {
	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(3);

		es.execute(() -> {
			Clone c1 = Clone.createInstance();
			System.out.println(c1);
			c1.setValue(10);
			System.out.println(c1.getValue());
		});

		es.execute(() -> {
			Clone c2 = Clone.createInstance();
			System.out.println(c2);
			c2.setValue(20);
			System.out.println(c2.getValue());
		});

		es.execute(() -> {
			Clone c3 = Clone.createInstance();
			System.out.println(c3);
			c3.setValue(30);
			System.out.println(c3.getValue());
		});

		es.shutdown();
	}
}
