package com.scaler.JavaRefresherIntermediate.Sessionn26;

public class MaxSumContiguousSubarray {

	public static void main(String[] args) {
		int[] A = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.println( maxSumArrayOptimized(A));
	}
	public static int maxSumArrayOptimized(int[] A) {
		int n= A.length;
		int currentSum=0;
		int maxSum= A[0];
		for(int i=0;i<n;i++) {
			currentSum = Math.max(A[i], currentSum + A[i]);
			maxSum = Math.max(maxSum, currentSum);
		}
		return maxSum;
	}
	
}
