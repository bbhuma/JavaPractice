package com.java.JavaRefresherIntermediate.Sessionn32;

public class DecreasingIncreasinginoneFunction {

	public static void main(String[] args) {
		decreasingIncreasinginoneFunction(5);
		decIncOptimized(5);

	}

	static void decIncOptimized(int num) {
		if (num == 0)
			return;

		System.out.print(num + " "); // prints num on the way down the call stack
		decIncOptimized(num - 1);
		System.out.print(num + " "); // prints same num again on the way back up the call stack
	}

	static void decreasingIncreasinginoneFunction(int num) {
		helper(num, num); // pass original num also
		System.out.println();
	}

	static void helper(int current, int original) {

		if (current == 0) {
			helperNew(1, original); // use original here
			return;
		}

		System.out.print(current + " ");
		helper(current - 1, original);
		System.out.print(current + " ");
	}

	static void helperNew(int current, int original) {
		if (current == original)
			return;

		System.out.print(current + " ");
		helperNew(current + 1, original);
	}
}
