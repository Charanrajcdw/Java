package dayOne;

public class LowerTriangularMatrix {
	public static void main(String[] args) {
		int rows=4;
		int columns=4;
		int[][] array=new int[rows][columns];
		int no=0;
		for(int i=0;i<rows;i++) {
			array[i]=new int[i+1];
			for(int j=0;j<=i;j++)
				array[i][j]=++no;
		}
		for(int i=0;i<rows;i++) {
			for(int j=0;j<=i;j++) {				
				System.out.printf("%-2d ",array[i][j]);
			}
			System.out.println();
		}
	}
}
