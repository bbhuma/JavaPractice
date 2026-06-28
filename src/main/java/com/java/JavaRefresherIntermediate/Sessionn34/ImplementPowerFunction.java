package com.java.JavaRefresherIntermediate.Sessionn34;

public class ImplementPowerFunction {

	public static void main(String[] args) {
		// Implement power function to calculate (A^B) % C.
		// A,B,C are all 32 bit integers. A may be negative -10^9 , A B C may be very
		// large, upto 10^9.
		System.out.println(fastPowerRecursion(22345, 10092, 23345));
		System.out.println(fastPowerRecursion(123563, 1000, 37346));
		System.out.println(fastPowerRecursion(1000000000, 246644, 100000007));

//		System.out.println(powerIterative(22345, 10092, 23345));
//		System.out.println(powerIterative(123563, 1000, 37346));
//		System.out.println(powerIterative(1000000000, 246644, 100000007));
		
		System.out.println(powerIterativeOptimizedPractice(22345, 10092, 23345));
		System.out.println(powerIterativeOptimizedPractice(123563, 1000, 37346));
		System.out.println(powerIterativeOptimizedPractice(1000000000, 246644, 100000007));

	}

	public static int fastPowerRecursion(int A, int B, int C) {
		// Base Cases
		if (C == 1)
			return 0;
		if (B == 0)
			return 1 % C;
		if (A == 0)
			return 0;

		// Normalize A, make negative numbers to positive
		A = ((A % C) + C) % C;

		int ans = fastPowerRecursion(A, B / 2, C);

		long result;
		// Recursion Calls
		if (B % 2 == 0) {
			result = ((long) ans * ans) % C; // cast to long is must before ans*ans, to make conversion in long.
			return (int) result;
		} else {
			result = (((long) ans * ans) % C * A) % C; // Ensures Value never grows beyond C²
			return (int) result;
		}
	}

	// TC is O(B), need to convert it to O(log B)
	public static int powerIterative(int A, int B, int C) {
		// Base Cases
		if (B == 0)
			return 1 % C;
		if (C == 1)
			return 0;
		if (A == 0)
			return 0;

		// Normalize A, make negative numbers to positive
		A = ((A % C) + C) % C;

		long result = 1;
		for (int i = 0; i < B; i++) {
			result = (result * A) % C; // Be careful result *= A%C gives wrong result, calculates as result*A%C
		}
		return (int) result;
	}

	// TC is O(B), need to convert it to O(log B)
	// Binary Exponentiation
	/*
	 * 1️⃣ If B is odd → multiply result with current base 2️⃣ Square the base 3️⃣
	 * Divide B by 2
	 */
	public static int powerIterativeOptimized(int A, int B, int C) {

		if (C == 1)
			return 0;
		if (B == 0)
			return 1 % C;

		A = ((A % C) + C) % C; // normalize negative A
		long result = 1;

		while (B > 0) {

			// If B is odd → multiply once
			if ((B & 1) == 1) {
				result = (result * A) % C;
			}

			// Square A
			A = (int) ((long) A * A % C);

			// Divide B by 2
			B = B >> 1;
		}

		return (int) result;
	}

	public static int powerIterativeOptimizedPractice(int A, int B, int C) {
		// Base Cases
		if (B == 0)
			return 1 % C;
		if (C == 1)
			return 0;
		if (A == 0)
			return 0;

		// Normalize A, make negative numbers to positive
		A = ((A % C) + C) % C;

		long result = 1;
		for (; B > 0; B /= 2) { // also can write B>>1
			if (B % 2 == 1) { // A gets squared if even power
				result = ( result *A ) % C ;
			} 
			//B =  B>>1 is same as B/=2, but faster, happen on each iteration, also can write B = B >> 1
			A = (int) ((long) A * A % C); // A gets squared if even power, on all iterations, also can write A = (int) ((long) A * A % C);
		}
		return (int) result;
	}

}
