package com.java.JavaRefresherIntermediate.Sessionn34;

public class GreatestCommonDivisor {

	public static void main(String[] args) {

		System.out.println(getGreatestCommonDivisor(25, 15));
		System.out.println(getGreatestCommonDivisor(12, 30));
		System.out.println(getGreatestCommonDivisor(9, 18));
		System.out.println(getGreatestCommonDivisor(81, 153));


		System.out.println(findGcd(48,0));
		System.out.println(findGcd(0,98));
		System.out.println(findGcd(-101,10));
		System.out.println(findGcd(54,24));

	}
	
	//TC is O(log(min(m,n))) because in each step we are reducing the problem size by half. The space complexity is O(1) because we are using only a constant amount of space for the variables.
	
	// SC is O(log(min(m,n))) because of the recursive call stack. In the worst case, the depth of the recursion can be log(min(m,n)) when m and n are both large and close to each other.
	
	// m,n can be positive, negative or zero. GCD is always positive. GCD of 0 and any number is the absolute value of that number. GCD of two negative numbers is the same as the GCD of their absolute values.
	public static int findGcd(int m, int n) {
		// Base cases: if either m or n is 0, return the absolute value of the other number. This is because the GCD of 0 and any number is the absolute value of that number.
		if(m==0) return Math.abs(n); //
		if(n==0) return Math.abs(m);
		if(m<0 || n<0) return findGcd(Math.abs(m),Math.abs(n)); // if either m or n is negative, we take the absolute value of both m and n and call findGcd again. This ensures that we are working with positive numbers, which is necessary for finding the GCD.
		
		// Euclidean Algorithm
		return findGcd(n,m%n); // if m is divisible by n, then m%n will be 0, and the next call will return n as the gcd. If m is not divisible by n, then we replace m with n and n with m%n, which reduces the problem size in each step.
	}
	

	public static int getGreatestCommonDivisor(int m, int n) {
		if (n==0 ) {
			return m;
		}
		if (m==0) {
			return n;
		}
		if(m<n) {
			return getGreatestCommonDivisor(n%m, m);
		}else 
		return getGreatestCommonDivisor(m % n, n);
	}
	

}
