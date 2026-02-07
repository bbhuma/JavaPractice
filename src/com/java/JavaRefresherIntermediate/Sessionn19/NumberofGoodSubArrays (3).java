package com.scaler.JavaRefresherIntermediate.Sessionn19;

public class NumberofGoodSubArrays {

	public static int numberofGoodSubArrays(int[] A, int B) {
		int n = A.length;
		int[] prefix = new int[n + 1];
		prefix[0] = 0;
		for (int i = 1; i <= n; i++)
			prefix[i] = prefix[i - 1] + A[i - 1];
		int goodSubArrays = 0;
		for (int i = 0; i < n; i++) {
			int sum = 0;
			for (int j = i; j < n; j++) {
				sum = prefix[j + 1] - prefix[i]; //O(1)
				int length = j - i + 1;
				if (length % 2 != 0 && sum > B) {
					goodSubArrays++;
				} else if (length % 2 == 0 && sum < B)
					goodSubArrays++;
				// else continue;
			}
		}
		return goodSubArrays;
	}

	public static void main(String[] args) {
		int[] A = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.println(numberofGoodSubArrays(A, 3));
	}

}
