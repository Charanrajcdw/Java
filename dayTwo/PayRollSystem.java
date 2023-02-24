package dayTwo;

import java.time.LocalDate;

abstract class Employee{
	public String name;
	public String id;
	public LocalDate dateOfJoining;
	
	public Employee(String name,String id,LocalDate date) {
		this.name=name;
		this.id=id;
		this.dateOfJoining=date;
	}
	
	public abstract String getWork();
	
	public abstract double getSalary(int hours);
	
	public void printDetails() {
		System.out.println("Name is "+name);
		System.out.println("ID is "+id);
		System.out.println("Work is "+getWork());
		System.out.println("Salary is "+getSalary(40));
		System.out.println("Date of joining is "+dateOfJoining);
		System.out.println();
	}
}

class SalesPerson extends Employee{
	public SalesPerson(String name,String id,LocalDate date) {
		super(name,id,date);
	}
	
	@Override
	public String getWork() {
		return "sell products directly to customer...";
	}
	
	@Override
	public double getSalary(int hours) {
		return hours*150;
	}
}

class Worker extends Employee{
	public Worker(String name,String id,LocalDate date) {
		super(name,id,date);
	}
	
	@Override
	public String getWork() {
		return "do hardware works in company...";
	}
	
	@Override
	public double getSalary(int hours) {
		return hours*180;
	}
}

class SalesManager extends SalesPerson{
	public SalesManager(String name,String id,LocalDate date) {
		super(name,id,date);
	}
	
	@Override
	public String getWork() {
		return "manage sales persons...";
	}
	
	@Override
	public double getSalary(int hours) {
		return hours*220;
	}
}

class SalesTerritoryManager extends SalesManager{
	public SalesTerritoryManager(String name,String id,LocalDate date) {
		super(name,id,date);
	}
	
	@Override
	public String getWork() {
		return "manage sales managers...";
	}
	
	@Override
	public double getSalary(int hours) {
		return hours*250;
	}
}

public class PayRollSystem {
	public static void main(String[] args) {
		Employee e;
		
		e=new SalesPerson("b","e02",LocalDate.parse("2022-01-01"));
		e.printDetails();
		
		e=new Worker("c","e03",LocalDate.parse("2022-01-01"));
		e.printDetails();
		
		e=new SalesManager("d","e04",LocalDate.parse("2021-01-01"));
		e.printDetails();
		
		e=new SalesTerritoryManager("e","e05",LocalDate.parse("2020-01-01"));
		e.printDetails();
	}
}
