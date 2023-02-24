package dayTwo;

public class DataPassing {
	public static void passByValue(int val) {
		val=20;
		System.out.println("Modified value is "+val);
	}
	
	public static void passByReference(int[] array) {
		for(int i=0;i<array.length;i++)
			array[i]*=2;
		System.out.print("Modified value is");
		for(int i:array)
			System.out.print(" "+i);			
	}
	
	public static void main(String[] args) {
		int val=10;
		System.out.println("Before passing, value is "+val);
		passByValue(val);
		System.out.println("After passing, value is "+val);
		System.out.println();
		
		int[] array= {1,2,3,4,5};
		System.out.print("Before passing value is");
		for(int i:array)
			System.out.print(" "+i);
		System.out.println();
		passByReference(array);
		System.out.println();
		System.out.print("After passing value is");
		for(int i:array)
			System.out.print(" "+i);
	}
}
