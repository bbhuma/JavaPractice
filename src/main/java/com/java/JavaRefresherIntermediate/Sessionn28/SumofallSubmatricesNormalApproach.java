package com.java.JavaRefresherIntermediate.Sessionn28;

public class SumofallSubmatricesNormalApproach {
	public static void main(String[] args) {
		int[][] arr = { { 1, 2, 3 }, { 3, 4, 5 }, { 6, 7, 8 } };
		sumofallSubmatrices(arr);
	}

	public static void sumofallSubmatrices(int[][] arr) {
		int n = arr.length;
		int m = arr[0].length;
		long totalSum = 0;
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
						totalSum += submatrixSum;
					}
				}

			}
		}

	}

}
