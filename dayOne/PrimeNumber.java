package dayOne;
import java.util.Scanner;

public class PrimeNumber {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter a no:");
		int no=scan.nextInt();
		boolean flag=true;
		for(int i=2;i<=no/2;i++)
			if(no%i==0)
				flag=false;
		System.out.println(flag?"Prime number":"Not a Prime number");
		scan.close();
	}
}
