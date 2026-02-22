package com.java.JavaRefresherIntermediate.Sessionn32;

public class SumofDigits {

	public static void main(String[] args) {
		System.out.println(sumOfDigits(1234567));
	}
	static int sumOfDigits(int n) {
		if(n==0) return 0;
		return (n%10 + sumOfDigits(n/10));  // n%10 gives the last digit, and n/10 gives the number without the last digit, and sumOfDigits(n/10) is the recursive call
	}

}
