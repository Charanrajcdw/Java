package creationalPattern;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class LazySingleton {
	private static LazySingleton lazySingleton;

	private LazySingleton() {
		System.out.println("Lazy singleton constructor called...");
	}

	public static LazySingleton getInstance() {
		if (lazySingleton == null) {
			synchronized (LazySingleton.class) {
				if (lazySingleton == null)
					lazySingleton = new LazySingleton();
			}
		}
		return lazySingleton;
	}
}

class EarlySingleton {
	private static EarlySingleton earlySingleton = new EarlySingleton();

	private EarlySingleton() {
		System.out.println("Early singleton constructor called...");
	}

	public static EarlySingleton getInstance() {
		return earlySingleton;

	}
}

public class SingletonPattern {
	public static void main(String[] args) {

		ExecutorService es = Executors.newFixedThreadPool(2);

		es.execute(() -> {
			LazySingleton ls1 = LazySingleton.getInstance();
			System.out.println(ls1);
		});

		es.execute(() -> {
			LazySingleton ls2 = LazySingleton.getInstance();
			System.out.println(ls2);
		});

		es.execute(() -> {
			EarlySingleton es1 = EarlySingleton.getInstance();
			System.out.println(es1);
		});

		es.execute(() -> {
			EarlySingleton es2 = EarlySingleton.getInstance();
			System.out.println(es2);
		});

		es.shutdown();
	}
}
