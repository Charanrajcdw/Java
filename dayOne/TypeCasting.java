package dayOne;

public class TypeCasting {
	public static void widening(byte b) {
		short s=b;
		System.out.println("short "+s);
		char c=(char)b;
		System.out.println("char "+c);
		int i=b;
		System.out.println("int "+i);
		long l=b;
		System.out.println("long "+l);
		float f=b;
		System.out.println("float "+f);
		double d=b;
		System.out.println("double "+d);
	}
	
	public static void narrowing(double d) {
		float f=(float) d;
		System.out.println("float "+f);
		long l=(long) d;
		System.out.println("long "+l);
		int i=(int) d;
		System.out.println("int "+i);
		char c=(char) d;
		System.out.println("char "+c);
		short s=(short) d;
		System.out.println("short "+s);
		byte b=(byte) d;
		System.out.println("byte "+b);
	}
	
	public static void main(String[] args) {
		byte b=97;double d=97.0;
		widening(b);
		System.out.println();
		narrowing(d);
	}
}