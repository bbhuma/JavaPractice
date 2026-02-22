package com.java.JavaRefresherIntermediate.Sessionn32;

public class FindFibonacciII {

	public static void main(String[] args) {
		System.out.println(findFibonacciII(3));
		System.out.println(findFibonacciII(9));
	}
	public static int findFibonacciII (int n) {
		// Two base cases, n=0 and n=1, and then the recursive case is n-1 and n-2
		if(n==0) return 0;
		if(n==1) return 1;
		
		// Fn = Fn-1 + Fn-2
		return findFibonacciII(n-1) + findFibonacciII(n-2);
	}

}
