package structuralPattern;

abstract class DominosPizza {
	public abstract int cost();
}

abstract class Crust extends DominosPizza {

}

abstract class Toppings extends DominosPizza {

}

class SmallCrust extends Crust {
	DominosPizza dp;

	public SmallCrust() {
		System.out.println("small pizza crust baked...");
	}

	public SmallCrust(DominosPizza dp) {
		System.out.println("small pizza crust baked...");
		this.dp = dp;
	}

	@Override
	public int cost() {
		if (dp == null)
			return 100;
		else
			return 100 + dp.cost();
	}
}

class LargeCrust extends Crust {
	DominosPizza dp;

	public LargeCrust() {
		System.out.println("large pizza crust baked...");
	}

	public LargeCrust(DominosPizza dp) {
		System.out.println("large pizza crust baked...");
		this.dp = dp;
	}

	@Override
	public int cost() {
		if (dp == null)
			return 200;
		else
			return 200 + dp.cost();
	}
}

class Cheese extends Toppings {
	DominosPizza dp;

	public Cheese() {
		System.out.println("cheese added...");
	}

	public Cheese(DominosPizza dp) {
		System.out.println("cheese added...");
		this.dp = dp;
	}

	@Override
	public int cost() {
		if (dp == null)
			return 20;
		else
			return 20 + dp.cost();
	}
}

class Corn extends Toppings {
	DominosPizza dp;

	public Corn() {
		System.out.println("corn added...");
	}

	public Corn(DominosPizza dp) {
		System.out.println("corn added...");
		this.dp = dp;
	}

	@Override
	public int cost() {
		if (dp == null)
			return 30;
		else
			return 30 + dp.cost();
	}
}

public class DecoratorPattern {
	public static void main(String[] args) {
		DominosPizza pizza = new Corn(new Cheese(new LargeCrust()));
		System.out.println(pizza.cost());
	}
}