package behaviouralPattern;

class Cleaner {
	public void cleanHall() {
		System.out.println("Hall has been cleaned...");
	}

	public void cleanRoom() {
		System.out.println("Rooms has been cleaned...");
	}
}

class Food {
	public void orderFood() {
		System.out.println("Food has been ordered...");
	}

	public void orderSnacks() {
		System.out.println("Snacks has been ordered...");
	}
}

class Disco {
	public void turnOnLights() {
		System.out.println("Party lights has been turned on...");
	}

	public void turnOnMusic() {
		System.out.println("Music player has been turned on...");
	}
}

class TV {
	public void turnOnTV() {
		System.out.println("TV has been turned on...");
	}

	public void startMovies() {
		System.out.println("Favorite movies ready to play...");
	}

	public void turnOffTV() {
		System.out.println("TV has been turned off...");
	}
}

abstract class Command {
	Cleaner cleaner;
	Disco disco;
	TV tv;
	Food food;

	public Command() {

	}

	public Command(Cleaner cleaner, Disco disco, TV tv, Food food) {
		this.cleaner = cleaner;
		this.disco = disco;
		this.tv = tv;
		this.food = food;
	}

	public abstract void execute();
}

class DummyCommand extends Command {
	public void execute() {
		System.out.println("This is a empty command slot...");
	}
}

class PartyCommand extends Command {
	public PartyCommand(Cleaner cleaner, Disco disco, TV tv, Food food) {
		super(cleaner, disco, tv, food);
	}

	@Override
	public void execute() {
		System.out.println("Party command started...");
		cleaner.cleanHall();
		food.orderSnacks();
		disco.turnOnLights();
		disco.turnOnMusic();
		tv.turnOffTV();
		System.out.println("Enjoy the party...");
	}
}

class LateNightCommand extends Command {
	public LateNightCommand(Cleaner cleaner, Disco disco, TV tv, Food food) {
		super(cleaner, disco, tv, food);
	}

	@Override
	public void execute() {
		System.out.println("Late Night Command started...");
		cleaner.cleanHall();
		cleaner.cleanRoom();
		food.orderFood();
		tv.turnOnTV();
		tv.startMovies();
		System.out.println("Have a peaceful night...");
	}
}

class Controller {
	Command c[] = new Command[5];

	public Controller() {
		for (int i = 0; i < 5; i++) {
			c[i] = new DummyCommand();
		}
	}

	public void executeCommand(int slot) {
		c[slot].execute();
	}

	public void assignCommand(int slot, Command command) {
		c[slot] = command;
	}
}

public class CommandPattern {
	public static void main(String[] args) {
		Controller controller = new Controller();

		TV tv = new TV();
		Disco disco = new Disco();
		Cleaner cleaner = new Cleaner();
		Food food = new Food();

		Command party = new PartyCommand(cleaner, disco, tv, food);
		Command night = new LateNightCommand(cleaner, disco, tv, food);

		controller.assignCommand(0, party);
		controller.assignCommand(1, night);

		controller.executeCommand(1);
	}
}
