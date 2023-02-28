package dayFour;

import java.util.Scanner;

public class StudentMain {
	public static void main(String[] args) {
		Teacher teacher=new Teacher(10);
		Checker checker=new Checker();
		teacher.getMarks(checker);
		teacher.showResult();
	}
}

class Teacher{
	public int studentMarks[];
	public int noOfStudents;
	public Teacher(int noOfStudents) {
		studentMarks=new int[noOfStudents];
		this.noOfStudents=noOfStudents;
	}
	public void getMarks(Checker checker) {
		Scanner scan=new Scanner(System.in);
		int studentCount=0;
		System.out.println("Enter the marks of "+noOfStudents+" marks:");
		while(studentCount<noOfStudents) {
			try {
				studentMarks[studentCount]=Integer.parseInt(scan.next());
				checker.check(studentMarks[studentCount]);
				studentCount++;
			}catch(NumberFormatException nfe) {
				System.out.println(nfe);
			}catch(InputException ie) {
				System.out.println(ie);
				ie.visit();
			}
		}
	}
	public void showResult() {
		float sum=0;
		for(int i=0;i<noOfStudents;i++)
			sum+=studentMarks[i];
		System.out.println("The average of "+noOfStudents+" people are "+sum/noOfStudents);
	}
}

class Checker{
	public void check(int number) throws InputException{
		if(number<0)
			throw new NegativeNumberException("Negative number not accepted...");
		else if(number<1 || number>100)
			throw new OutOfRangeException("Number not valid...");
	}
}

