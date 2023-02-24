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
		//initialization
		int v1=1;
		short v2=1;
		long v3=139420328240248L;
		float v4=23424.34f;
		double v5=3224.34;
		char v6='a';
		boolean v7=true;
		byte v8=127;
		System.out.println(v1+" "+v2+" "+v3+" "+v4+" "+v5+" "+v6+" "+v7+" "+v8);
		System.out.println();
		
		//implicit type casting
		byte b=97;double d=97.0;
		widening(b);
		System.out.println();
		
		//explicit type casting
		narrowing(d);
	}
}