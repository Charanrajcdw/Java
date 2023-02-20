package dayTwo;
import java.util.Scanner;

class ComplexNumbers{
	public int real;
	public int imaginary;
	public static Scanner scan;
	
	public void getInput() {
		System.out.println("Enter the value of real number");
		real=scan.nextInt();
		System.out.println("Enter the value of imaginary number");
		imaginary=scan.nextInt();
	}
	
	public void add(ComplexNumbers cn) {
		this.real+=cn.real;
		this.imaginary+=cn.imaginary;
	}
	
	public void print() {
		System.out.println("The complex number is ("+real+")+("+imaginary+")i");
	}
}

public class Addition {
	public static void main(String[] args) {
		ComplexNumbers.scan=new Scanner(System.in);
		ComplexNumbers cno1=new ComplexNumbers();
		cno1.getInput();
		cno1.print();
		ComplexNumbers cno2=new ComplexNumbers();
		cno2.getInput();
		cno2.print();
		System.out.println("After adding complex number 2 to complex number 1");
		cno1.add(cno2);
		cno1.print();
		ComplexNumbers.scan.close();
	}
}
