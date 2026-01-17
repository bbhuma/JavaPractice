package com.java.JavaRefresherIntermediate.Sessionn26;

public class MaxSumContiguousSubarrayOptimized {

	public static void main(String[] args) {
		int[] A = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.println( maxSubArray(A));
	}

	public static int[] pfSummethod(int[] arr) {
		int[] pfSumarr = new int[arr.length];
		int pfSum = 0;
		for (int i = 0; i < arr.length; i++) {

			if ((pfSum += arr[i]) > 0)
				pfSumarr[i] = pfSum;
			else
				pfSum = 0;
		}
		return pfSumarr;
	}

	public static int maxSubArray(final int[] A) {
		int maxPossibleSum = A[0];
		int n = A.length;
		int[] prefixSum = pfSummethod(A);
		for (int i = 0; i < n; i++) {
			int sum = 0;
			sum += prefixSum[i];
			if (prefixSum[i] > 0)
				maxPossibleSum = Math.max(maxPossibleSum, prefixSum[i]);
			else
				maxPossibleSum = Math.max(maxPossibleSum, A[i]);
		}
		return maxPossibleSum;
	}
}
