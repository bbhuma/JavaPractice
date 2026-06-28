package com.java.JavaRefresherIntermediate.Sessionn34;

public class LargestCoprimeDivisor {

	public static void main(String[] args) {
		System.out.println(largestCoprimeDivisor(15, 6)); // 5, focus on 15, the divisors of 15 are 1, 3, 5, 15, and the divisors of 6 are 1, 2, 3, 6, the common divisors are 1 and 3, so the largest coprime divisor of 15 with respect to 6 is 5,
		// why not 15? because 15 and 6 are not coprime, they have common divisor 3, so we need to divide 15 by 3 to get the largest coprime divisor of 15 with respect to 6, which is 5
		System.out.println(largestCoprimeDivisor(8, 5)); // 8	
		System.out.println(largestCoprimeDivisor(12, 15)); // 4
	}

	public static int largestCoprimeDivisor(int a, int b) {
		while (gcd(a, b) != 1) {
			a= a / gcd(a, b);
		}
		return a; // we are dividing a by gcd(a,b) until gcd(a,b) becomes 1, which means a and b are coprime, and we are returning the largest coprime divisor of a with respect to b
	}

	public static int gcd(int a, int b) {
		if (b == 0) return a;
		return gcd(b, a % b); //
	}
	
	

}
