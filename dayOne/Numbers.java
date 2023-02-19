package dayOne;

import java.util.Scanner;

public class Numbers {
	public static boolean checkPrime(int n) {
		if(n<=1)return false;
		if(n==2)return true;
		for(int i=2;i<=n/2;i++)
			if(n%i==0)
				return false;
		return true;
	}
	
	public static void printPrime() {
		for(int i=1;i<=100;i++)
			if(checkPrime(i))
				System.out.println(i);
	}
	
	public static int findLength(int no) {
		int len=0;
		while(no>0) {
			no/=10;
			len++;
		}
		return len;
	}
	
	public static void checkArmstrong(int no) {
		int sum=0;
		int len=findLength(no);
		int temp=no;
		while(temp>0) {
			sum+=Math.pow(temp%10,len);
			temp/=10;
		}
		System.out.println(sum==no?"The no is armstrong no":"The no is not a armstrong no");
	}
	
	public static void checkPerfect(int no) {
		int sum=1;
		for(int i=2;i<=no/2;i++)
			if(no%i==0)
				sum+=i;
		System.out.println(sum==no?"The no is a perfect no":"The no is not a perfect no");
	}
	
	public static void checkPalindrome(int no) {
		int sum=0;
		int temp=no;
		while(temp>0){
			sum=sum*10+temp%10;
			temp/=10;
		}
		System.out.println(sum==no?"The no is a palindrome":"The no is not a palindrome");	
	}
	
	public static void main(String[] args) {
		System.out.println("The prime numbers are");
		printPrime();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a no:");
		int no=sc.nextInt();
		checkArmstrong(no);
		checkPerfect(no);
		checkPalindrome(no);
		sc.close();
	}
}
