package com.scaler.JavaRefresherIntermediate.Sessionn19;

public class SubarrayWithGivenSumAndlength {
	public static int subarrayWithGivenSumAndlength(int[] A, int B, int C) {
		int n = A.length;
		if(B>n) return 0;
		
		int sum = 0;
		for (int i = 0; i < B; i++) {
			sum += A[i];
		}
		if (sum == C)
			return 1;
		// Sliding window till the end form i=B to end n-1
		for (int i = B; i < n - 1; i++) {
			sum = sum - A[i - B] + A[i];
			if (sum == C)
				return 1;
		}

		return 0;
	}

	public static void main(String[] args) {
		int[] A = { 20, 10, -34, 24, 56, 7, 98, -1, -34, -76 };
		System.out.println(subarrayWithGivenSumAndlength(A, 3, 24));
		System.out.println(subarrayWithGivenSumAndlength(A, 3, 0));
	}

}
