package patterns;

import java.util.HashMap;
import java.util.Random;

interface Player {
	public void setWeapon(String weapon);

	public void printMission();
}

class Terrorist implements Player {
	private String task, weapon;

	public Terrorist() {
		System.out.println("Terrorist player object has been created...");
		task = "capture hostages";
	}

	@Override
	public void setWeapon(String weapon) {
		this.weapon = weapon;
	}

	@Override
	public void printMission() {
		System.out.println("Terrorist [task=" + task + ", weapon=" + weapon + "]");
	}
}

class CounterTerrorist implements Player {
	private String task, weapon;

	public CounterTerrorist() {
		System.out.println("CounterTerrorist player object has been created...");
		task = "rescue hostages";
	}

	@Override
	public void setWeapon(String weapon) {
		this.weapon = weapon;
	}

	@Override
	public void printMission() {
		System.out.println("CounterTerrorist [task=" + task + ", weapon=" + weapon + "]");
	}
}

class PlayerFactory {
	private static HashMap<String, Player> map = new HashMap<>();

	public static Player getPlayer(String type) {
		Player player = null;
		if (map.containsKey(type))
			player = map.get(type);
		else if (type == "Terrorist") {
			player = new Terrorist();
			map.put(type, player);
		} else if (type == "CounterTerrorist") {
			player = new CounterTerrorist();
			map.put(type, player);
		}
		return player;
	}
}

public class Flyweight {
	private static String[] playerType = { "Terrorist", "CounterTerrorist" };
	private static String[] weapons = { "AK-47", "M134", "M16A4", "MK-22" };

	public static String getRandomPlayerType() {
		Random random = new Random();
		int randomInt = random.nextInt(playerType.length);
		return playerType[randomInt];
	}

	public static String getRandomWeapon() {
		Random random = new Random();
		int randomInt = random.nextInt(weapons.length);
		return weapons[randomInt];
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			Player player = PlayerFactory.getPlayer(getRandomPlayerType());
			player.setWeapon(getRandomWeapon());
			player.printMission();
		}
	}
}
