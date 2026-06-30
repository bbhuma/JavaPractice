package com.java.JavaRefresherIntermediate.Sessionn37;

public class MaxChunksToMakeSorted {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 0, 5, 7, 8, 6 };
		System.out.println(maxChunksToMakeSorted(arr));
	}

	public static int maxChunksToMakeSorted(int[] arr) {
		int max = Integer.MIN_VALUE;
		int chunks = 0;
		for (int i = 0; i < arr.length; i++) {
			max = Math.max(max, arr[i]);
			// if (arr[i] > max)
			// max = arr[i];
			if (i == max) {
				chunks++;
				// max = Integer.MIN_VALUE;} // No need to reset the max value
			}

		}
		return chunks;
	}
}
