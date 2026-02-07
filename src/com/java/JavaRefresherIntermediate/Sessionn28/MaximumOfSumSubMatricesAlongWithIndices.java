package com.java.JavaRefresherIntermediate.Sessionn28;

public class MaximumOfSumSubMatricesAlongWithIndices {
	public static void main(String[] args) {
		int[][] arr = { { 1, 2, 3 }, { 3, 4, 5 }, { 6, 7, 8 } };
		System.out.println(maximumOfSumSubMatrices(arr));
	}

	public static long maximumOfSumSubMatrices(int[][] arr) {
		int n = arr.length;
		int m = arr[0].length;
		long maxSumStartLeft = Integer.MIN_VALUE;
		long maxSumStartRight = Integer.MIN_VALUE;
		long maxSumEndLeft = Integer.MIN_VALUE;
		long maxSumEndRight = Integer.MIN_VALUE;
		long maxSum = Integer.MIN_VALUE;

		for (int startRow = 0; startRow < n; startRow++) {
			for (int endRow = startRow; endRow < n; endRow++) {
				for (int startCol = 0; startCol < m; startCol++) {
					for (int endCol = startCol; endCol < m; endCol++) {

						// Calculate sum of the submatrix from (startRow, startCol) to (endRow, endCol)
						long submatrixSum = 0;
						for (int i = startRow; i <= endRow; i++) {
							for (int j = startCol; j <= endCol; j++) {
								submatrixSum += arr[i][j];
							}
						}
						// maxSum = Math.max(maxSum, submatrixSum);
						if (submatrixSum > maxSum) {
							maxSum = submatrixSum;
							maxSumStartLeft = startRow;
							maxSumStartRight = startCol;
							maxSumEndLeft = endRow;
							maxSumEndRight = endCol;

						}
					}
				}
			}
		}
		System.out.println("Max Sum Starting from Left: (" + maxSumStartLeft + "," + maxSumStartRight + ") to ("
				+ maxSumEndLeft + "," + maxSumEndRight + ")");
		return maxSum;
	}

}
