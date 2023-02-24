package dayTwo;

import java.util.Scanner;

class Student{
	public static Scanner scan;
	public String name;
	public int rollno;
	
	public void getNameRollno() {
		System.out.println("Enter name:");
		name=scan.next();
		System.out.println("Enter rollno:");
		rollno=scan.nextInt();
	}
}

class Exam extends Student{
	public int m1,m2,m3;
	
	public void getMarks() {
		System.out.println("Enter marks:");
		m1=scan.nextInt();
		m2=scan.nextInt();
		m3=scan.nextInt();
	}
}

class Result extends Exam{
	public int totalMark;
	
	public void calculateResult() {
		totalMark=m1+m2+m3;
		System.out.println("Total marks is "+totalMark);
	}
}

public class CalculateResult {
	public static void main(String[] args) {
		Result.scan=new Scanner(System.in);
		Result result=new Result();
		result.getNameRollno();
		result.getMarks();
		result.calculateResult();
		Result.scan.close();
	}
}
