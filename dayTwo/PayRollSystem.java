package dayTwo;

class Employee{
	public String name;
	public String id;
	
	
	public Employee(String name,String id) {
		this.name=name;
		this.id=id;
	}
	
	public String getWork() {
		return "company works...";
	}
	
	public double getSalary(int hours) {
		return hours*100;
	}
	
	public void printDetails() {
		System.out.println("Name is "+name);
		System.out.println("ID is "+id);
		System.out.println("Work is "+getWork());
		System.out.println("Salary is "+getSalary(40));
		System.out.println();
	}
}

class SalesPerson extends Employee{
	public SalesPerson(String name,String id) {
		super(name,id);
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
	public Worker(String name,String id) {
		super(name,id);
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
	public SalesManager(String name,String id) {
		super(name,id);
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
	public SalesTerritoryManager(String name,String id) {
		super(name,id);
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
		Employee e=new Employee("a","e01");
		e.printDetails();
		
		SalesPerson sp=new SalesPerson("b","e02");
		sp.printDetails();
		
		Worker w=new Worker("c","e03");
		w.printDetails();
		
		SalesManager sm=new SalesManager("d","e04");
		sm.printDetails();
		
		SalesTerritoryManager stm=new SalesTerritoryManager("e","e05");
		stm.printDetails();
	}
}
