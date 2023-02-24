package dayOne;
import java.util.Scanner;

public class PrimeNumber {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter a no:");
		int inputNumber=scan.nextInt();
		boolean flag=false;
		if(inputNumber==2 || inputNumber==3)
			flag=true;
		else if(inputNumber%2==0|| inputNumber%3==0)
			flag=false;
		else {			
			for(int i=5;i*i<=inputNumber;i+=2)
				if(inputNumber%i==0)
					flag=false;
		}
		System.out.println(flag?"Prime number":"Not a Prime number");
		scan.close();
	}
}
