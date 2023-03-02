package behaviouralPattern;

abstract class Trip {
	private final void getFirstAidKit() {
		System.out.println("First aid kits packed...");
	}

	public abstract void callFriends();

	public abstract void chooseDestination();

	public abstract void orderFood();

	public abstract void bookVehicles();

	public abstract void packDresses();

	public final void makeTrip() {
		callFriends();
		chooseDestination();
		bookVehicles();
		packDresses();
		getFirstAidKit();
		orderFood();
	}
}

class ChennaiTrip extends Trip {
	@Override
	public void bookVehicles() {
		System.out.println("Mini bus has been booked for the trip...");
	}

	@Override
	public void callFriends() {
		System.out.println("College friends have been invited to the trip...");
	}

	@Override
	public void chooseDestination() {
		System.out.println("Visit tourist places and beaches in Chennai...");
	}

	@Override
	public void orderFood() {
		System.out.println("Snacks and beverages for the trip has been ordered...");
	}

	@Override
	public void packDresses() {
		System.out.println("Dresses required for the trip has been packed...");
	}
}

public class TemplatePattern {
	public static void main(String[] args) {
		Trip chennai = new ChennaiTrip();
		chennai.makeTrip();
	}
}
