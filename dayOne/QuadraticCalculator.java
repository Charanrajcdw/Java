package dayOne;

class QuadraticFunction {
	int a;
	int b;
	int c;
	
	public QuadraticFunction() {
		a=b=c=1;
	}
	
	public QuadraticFunction(int a,int b,int c) {
		this.a=a;
		this.b=b;
		this.c=c;
	}
	
	public int geta() {
		return a;
	}
	
	public int getb() {
		return b;
	}
	
	public int getc() {
		return c;
	}
	
	public void setabc(int a,int b,int c) {
		this.a=a;
		this.b=b;
		this.c=c;		
	}
	
	public int compute(int x) {
		return (a*x*x)+(b*x)+(c);
	}
}

public class QuadraticCalculator{
	public static void main(String[] args) {
		QuadraticFunction quad1=new QuadraticFunction();
		System.out.println("The values are "+quad1.geta()+" "+quad1.getb()+" "+quad1.getc());
		quad1.setabc(2,2,2);
		System.out.println("The result of quadratic function is "+quad1.compute(3));
		
		QuadraticFunction quad2=new QuadraticFunction(1,2,3);
		System.out.println("The values are "+quad2.geta()+" "+quad2.getb()+" "+quad2.getc());
		System.out.println("The result of quadratic function is "+quad2.compute(3));
	}
}
