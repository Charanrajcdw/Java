package dayFive;

import java.time.LocalTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Time {
	private int seconds;
	private int minutes;
	private int hours;

	public Time() {
		seconds = LocalTime.now().getSecond();
		minutes = LocalTime.now().getMinute();
		hours = LocalTime.now().getHour();
	}

	public int getSeconds() {
		return seconds;
	}

	public int getMinutes() {
		return minutes;
	}

	public int getHours() {
		return hours;
	}

	synchronized public void updateSecond() {
		if (seconds < 60) {
			seconds = seconds + 1;
			if (seconds == 60)
				notifyAll();
			else
				System.out.printf("%02d:%02d:%02d\n", hours, minutes, seconds);
		} else {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	synchronized public void updateMinute() {
		if (seconds == 60 && minutes < 60) {
			minutes = minutes + 1;
			if (minutes == 60)
				notifyAll();
			else {				
				seconds = 0;
				System.out.printf("%02d:%02d:%02d\n", hours, minutes, seconds);
			}
		} else {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	synchronized public void updateHour() {
		if (seconds == 60 && minutes == 60) {
			minutes = 0;
			seconds = 0;
			hours = hours == 11 ? 0 : hours + 1;
			notifyAll();
			System.out.printf("%02d:%02d:%02d\n", hours, minutes, seconds);
		} else {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class DigitalClock {
	public static LocalTime time;

	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(3);
		Time time = new Time();
		es.execute(() -> {
			while (true) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				time.updateSecond();
			}
		});
		es.execute(() -> {
			while (true) {
				time.updateMinute();
			}
		});
		es.execute(() -> {
			while (true) {
				time.updateHour();
			}
		});
		es.shutdown();
	}
}
