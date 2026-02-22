package com.java.JavaRefresherIntermediate.Sessionn32;

public class FindFactorial {
	public static void main(String[] args) {
		System.out.println(findFactorial(5));
	}
	static int findFactorial(int n){
		
		if(n==1) return 1;
		
		return n*findFactorial(n-1); // n * is extrawork, n-1 is the smaller problem, and findFactorial(n-1) is the recursive call
	}

}
