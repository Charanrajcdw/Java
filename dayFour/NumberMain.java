package dayFour;

import java.util.Scanner;

public class NumberMain {
	public static void main(String[] args) {
		Calculator calculator=new Calculator();
		Division division=new Division();
		calculator.doCalculation(division);
	}
}

class Calculator{
	Scanner scan=new Scanner(System.in);
	public void doCalculation(Division division) {		
		String numerator;
		String denominator;
		while(true) {
			System.out.println("Enter numerator:");
			numerator=scan.next();
			System.out.println("Enter denominator:");
			denominator=scan.next();
			char ch=numerator.charAt(0);
			if(ch=='q'||ch=='Q') {
				System.out.println("Program ended...");
				break;
			}else {
				try {
					division.divide(numerator,denominator);
				}catch(NumberException ne){
//					ne.printStackTrace();
					ne.visit();
				}
			}
		}
	}
}

class Division{
	public void divide(String numerator,String denominator) throws NumberException{
		if(!Character.isDigit(numerator.charAt(0))||!Character.isDigit(denominator.charAt(0))) {
			throw new PoorInputException("Enter a number instead of character!!!");
		}else if(denominator.charAt(0)=='0') {
			throw new DivisionByZeroException("Enter a value above 0 for denominator!!!");
		}else {
			int numberNumerator=Integer.parseInt(numerator);
			int numberDenominator=Integer.parseInt(denominator);
			System.out.println("The answer is "+numberNumerator/numberDenominator);
		}
	}
}

abstract class NumberHandler{
	public abstract void handle(DivisionByZeroException dbe);
	public abstract void handle(PoorInputException pie);
}

class NumberHandlerImpl extends NumberHandler{
	@Override
	public void handle(DivisionByZeroException dbe) {
		System.out.println("Please enter a value greater than zero...");
	}
	public void handle(PoorInputException pie) {
		System.out.println("Please enter a number and not characters...");
	}
}

abstract class NumberException extends Exception{
	public NumberException(String msg) {
		super(msg);
	}
	public abstract void visit();
}

class DivisionByZeroException extends NumberException{
	String msg;
	public DivisionByZeroException(String msg) {
		super(msg);
		this.msg=msg;
	}
	@Override
	public String toString() {
		return msg;
	}	
	@Override
	public void visit() {
		NumberHandler nh=new NumberHandlerImpl();
		nh.handle(this);
	}
}


class PoorInputException extends NumberException{
	String msg;
	public PoorInputException(String msg) {
		super(msg);
		this.msg=msg;
	}
	@Override
	public String toString() {
		return msg;
	}	
	@Override
	public void visit() {
		NumberHandler nh=new NumberHandlerImpl();
		nh.handle(this);
	}
}