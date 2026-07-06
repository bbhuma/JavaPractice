package com.java.JavaRefresherIntermediate.Sessionn40;

public class MatrixSearch {

	public static void main(String[] args)

	{
		int[][] arr = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 50 } };
		System.out.println(matrixSearch(arr, 3));

	}

	public static int matrixSearch(int[][] arr, int target) {
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			int[] ans = arr[i];
			int m = ans.length;
			int low = 0;
			int high = m - 1;
			while (low <= high) {
				int mid = low + (high - low) / 2;
				if (ans[mid] == target) {
					return 1;
				} else if (ans[mid] < target) {
					low = mid + 1;
				} else
					high = mid - 1;
			}

		}

		return 0;
	}

}
