package behaviouralPattern;

public class VisitorPattern {
	public static void main(String[] args) {
		Child child = new Child();
		Dog dog = new Dog();
		child.setDog(dog);
		child.playWithDog("stick");
	}
}

class Child {
	Dog dog;

	public Dog getDog() {
		return dog;
	}

	public void setDog(Dog dog) {
		this.dog = dog;
	}

	public void playWithDog(String item) {
		try {
			dog.play(item);
		} catch (DogException e) {
			e.printStackTrace();
			e.visit();
		}
	}
}

class Dog {
	public void play(String item) throws DogException {
		if (item.equals("stick"))
			throw new DogBarkException("dog is going to bark...");
		else if (item.equals("stone"))
			throw new DogBiteException("dog is going to bite...");
		else
			System.out.println("dog plays silently...");
	}
}

abstract class DogException extends Exception {
	Handler handler;

	public DogException(String msg) {
		super(msg);
		handler = new Handler911();
	}

	public abstract void visit();
}

class DogBiteException extends DogException {
	public DogBiteException(String msg) {
		super(msg);
	}

	@Override
	public void visit() {
		handler.handle(this);
	}
}

class DogBarkException extends DogException {
	public DogBarkException(String msg) {
		super(msg);
	}

	@Override
	public void visit() {
		handler.handle(this);
	}
}

abstract class Handler {
	abstract public void handle(DogBiteException dbe);

	abstract public void handle(DogBarkException dbe);
}

class Handler911 extends Handler {
	public void handle(DogBiteException dbe) {
		System.out.println("run away from the dog...");
	}

	public void handle(DogBarkException dbe) {
		System.out.println("move slowly away from the dog...");
	}
}
