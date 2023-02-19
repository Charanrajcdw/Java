package dayOne;

import java.util.Scanner;

public class DaysOfMonth {
	public static Scanner sc;
	public static void printDays(int month) {
		switch(month) {
			case 1:System.out.println("January has 31 days");
				   break;
			case 2:System.out.println("February has 28 or 29 days");
			System.out.println("Enter the no of days in your year");
			int days=sc.nextInt();
			String s1="It's a leap year! February has 29 days";
			String s2="It's not a leap year! Febraury has 28 days";
			System.out.println(days==366?s1:s2);
			break;
			case 3:System.out.println("March has 31 days");
				   break;
			case 4:System.out.println("April has 30 days");
				   break;
			case 5:System.out.println("May has 31 days");
				   break;
			case 6:System.out.println("June has 30 days");
				   break;
			case 7:System.out.println("July has 31 days");
				   break;
			case 8:System.out.println("August has 31 days");
				   break;
			case 9:System.out.println("September has 30 days");
				   break;
			case 10:System.out.println("October has 31 days");
				   break;
			case 11:System.out.println("November has 30 days");
				   break;
			case 12:System.out.println("December has 31 days");
				   break;
			default:System.out.println("Invalid month!!!");
				   break;
		}
	}
	public static void main(String[] args) {
		sc=new Scanner(System.in);
		System.out.println("1.January\n2.February\n3.March\n4.April");
		System.out.println("5.May\n6.June\n7.July\n8.August");
		System.out.println("9.September\n10.October\n11.November\n12.December");
		System.out.println("Select the month to diplay the number of days:");
		printDays(sc.nextInt());
		sc.close();
	}
}
