package com.java.JavaRefresherIntermediate.Sessionn40;

public class SquareRootofInteger {

	public static void main(String[] args) {
		System.out.println(squareRootofInteger(8));
	}

	public static int squareRootofIntegerBuiltInFunc(int num) {
		int sqrt = (int) Math.sqrt(num);
		return sqrt;
	}

	public static int squareRootofInteger(int num) {
		int low = 0;
		int high = num;
		int ans = -1;

		// binary search on search space
		while (low <= high) {
			int mid = low + (high - low) / 2; // must be int, since it is a position
			if ((long) mid * mid <= num) { // convert int to long, to avoid overflow, dont use mod unless asked to
										   // return mod
				ans = mid;
				low = mid + 1; // go right to see a better mid
			} else
				high = mid - 1;
		}
		return ans;
	}
}
