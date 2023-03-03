package oops;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

class Lorry {
	private float speed;
	private int workingHours;

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public int getWorkingHours() {
		return workingHours;
	}

	public void setWorkingHours(int workingHours) {
		this.workingHours = workingHours;
	}

	public boolean isWorkingDay(LocalDateTime date) {
		DayOfWeek dayName = date.getDayOfWeek();
		if (dayName.equals("SUNDAY"))
			return false;
		int month = date.getMonthValue();
		int dayOfMonth = date.getDayOfMonth();
		int dayOfWeek = dayName.getValue();
		if (dayOfWeek == 7 && dayOfMonth > 7 && dayOfMonth <= 14)
			return false;
		if (month == 1) {
			if (dayOfMonth == 1 || dayOfMonth == 26)
				return false;
		}
		if (month == 8 && dayOfMonth == 15)
			return false;
		return true;
	}
}

class Time {
	private float timeTaken;
	private int minutes;
	private LocalDateTime startingTime;
	private LocalDateTime reachingTime;
	Lorry lorry;
	Travel travel;

	public Time(Lorry lorry, Travel travel, int year, int month, int day, int hours, int minutes) {
		this.lorry = lorry;
		this.travel = travel;
		this.startingTime = LocalDateTime.of(year, month, day, hours, minutes);
	}

	public int getRemainingTimeInDay() {
		int hours = startingTime.getHour();
		int minutes = startingTime.getMinute();
		int remainingMinutes = 1440 - 60 * hours - minutes;
		if (remainingMinutes > lorry.getWorkingHours() * 60)
			return lorry.getWorkingHours() * 60;
		return remainingMinutes;
	}

	public void calculateReachingTime() {
		timeTaken = travel.getDistance() / lorry.getSpeed();
		minutes = (int) (timeTaken * 60);

		// calculates if today job can be completed, or else reduces the work done today
		// from total work
		if (lorry.isWorkingDay(startingTime)) {
			int remainingTimeInDay = getRemainingTimeInDay();
			if (minutes <= remainingTimeInDay) {
				reachingTime = startingTime.plusMinutes(minutes);
				System.out.println(
						"Lorry will reach in " + reachingTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
				return;
			} else {
				minutes -= remainingTimeInDay;
			}
		}

		// calculates the number of days taken to complete work
		int workingMinutes = lorry.getWorkingHours() * 60;
		reachingTime = LocalDateTime.of(startingTime.getYear(), startingTime.getMonth(), startingTime.getDayOfMonth(),
				0, 0);
		reachingTime = reachingTime.plusDays(1);
		while (minutes >= workingMinutes) {
			if (lorry.isWorkingDay(reachingTime)) {
				minutes -= workingMinutes;
			}
			reachingTime = reachingTime.plusDays(1);
		}

		// calculates the minutes in last day
		while (!lorry.isWorkingDay(reachingTime)) {
			reachingTime = reachingTime.plusDays(1);
		}
		reachingTime = reachingTime.plusMinutes(minutes);
		System.out
				.println("Lorry will reach in " + reachingTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
	}
}

class Travel {
	private float distance;

	public float getDistance() {
		return distance;
	}

	public void setDistance(float distance) {
		this.distance = distance;
	}
}

public class TimeCalculator {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Lorry lorry = new Lorry();
		System.out.println("Enter the speed of the lorry:");
		lorry.setSpeed(scan.nextFloat());
		System.out.println("Enter working hours per day:");
		lorry.setWorkingHours(scan.nextInt());
		Travel travel = new Travel();
		System.out.println("Enter the distance to be covered:");
		travel.setDistance(scan.nextFloat());
		System.out.println("Enter the starting date(year,month,day,hours,minutes):");
		int year = scan.nextInt();
		int month = scan.nextInt();
		int day = scan.nextInt();
		int hours = scan.nextInt();
		int minutes = scan.nextInt();
		Time time = new Time(lorry, travel, year, month, day, hours, minutes);
		time.calculateReachingTime();
		scan.close();
	}
}
