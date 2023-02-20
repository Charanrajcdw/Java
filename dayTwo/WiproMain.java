package dayTwo;

class Wipro{
	public String name;
	public String location;
	
	public Wipro(String name,String location) {
		this.name=name;
		this.location=location;
	}
	
	public void getDetails() {
		System.out.println("Name : "+name);
		System.out.println("Location : "+location);
	}
	
	public void getWork() {
		System.out.println("Work : Software related");
	}
}

class WiproTechnologies extends Wipro{
	public WiproTechnologies(String name,String location) {
		super(name,location);
	}
	
	@Override
	public void getWork() {
		System.out.println("Work : Software development...\n");
	}
}

class WiproInfotech extends Wipro{
	public WiproInfotech(String name,String location) {
		super(name,location);
	}
	
	@Override
	public void getWork() {
		System.out.println("Work : IT services...\n");
	}
}

class WiproBPO extends Wipro{
	public WiproBPO(String name,String location) {
		super(name,location);
	}
	
	@Override
	public void getWork() {
		System.out.println("Work : Business related work...\n");
	}
}

public class WiproMain {
	public static void main(String[] args) {
		Wipro[] wipro=new Wipro[3];
		wipro[0]=new WiproTechnologies("WT-Chennai","Chennai");
		wipro[1]=new WiproInfotech("WI-Bangalore","Bangalore");
		wipro[2]=new WiproBPO("WB-Hyderabad","Hyderabad");
		
		for(Wipro w:wipro) {
			w.getDetails();
			w.getWork();
		}
	}
}
