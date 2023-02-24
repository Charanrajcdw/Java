package dayOne;

import java.util.Scanner;

public class Numbers {
	public static boolean checkPrime(int inputNumber) {
		if(inputNumber<=1)
			return false;
		if(inputNumber==2||inputNumber==3)
			return true;
		if(inputNumber%2==0||inputNumber%3==0)
			return false;
		for(int i=5;i*i<=inputNumber;i++)
			if(inputNumber%i==0)
				return false;
		return true;
	}
	
	public static void printPrime() {
		for(int i=1;i<=100;i++)
			if(checkPrime(i))
				System.out.println(i);
	}
	
	public static int findLength(int inputNumber) {
		int length=0;
		while(inputNumber>0) {
			inputNumber/=10;
			length++;
		}
		return length;
	}
	
	public static void checkArmstrong(int inputNumber) {
		int sum=0;
		int length=findLength(inputNumber);
		int numberCopy=inputNumber;
		while(numberCopy>0) {
			sum+=Math.pow(numberCopy%10,length);
			numberCopy/=10;
		}
		System.out.println(sum==inputNumber?"The no is armstrong no":"The no is not a armstrong no");
	}
	
	public static void checkPerfect(int inputNumber) {
		int sum=1;
		for(int i=2;i<=inputNumber/2;i++)
			if(inputNumber%i==0)
				sum+=i;
		System.out.println(sum==inputNumber?"The no is a perfect no":"The no is not a perfect no");
	}
	
	public static void checkPalindrome(int inputNumber) {
		int sum=0;
		int numberCopy=inputNumber;
		while(numberCopy>0){
			sum=sum*10+numberCopy%10;
			numberCopy/=10;
		}
		System.out.println(sum==inputNumber?"The no is a palindrome":"The no is not a palindrome");	
	}
	
	public static void main(String[] args) {
		System.out.println("The prime numbers are");
		printPrime();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a no:");
		int inputNumber=sc.nextInt();
		checkArmstrong(inputNumber);
		checkPerfect(inputNumber);
		checkPalindrome(inputNumber);
		sc.close();
	}
}
