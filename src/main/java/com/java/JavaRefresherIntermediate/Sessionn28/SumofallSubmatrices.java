package com.java.JavaRefresherIntermediate.Sessionn28;

public class SumofallSubmatrices {
	public static void main(String[] args) {
		int[][] arr = { { 1, 2, 3 }, { 3, 4, 5 }, { 6, 7, 8 } };
		sumofallSubmatrices(arr);
	}

	public static void sumofallSubmatrices(int[][] arr) {
		int n = arr.length;
		int m = arr[0].length;
		long totalSum = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				long topLeftOptions = (i + 1) * (j + 1);
				long bottomRightOptions = (n - i) * (m - j);
				long totalSubmatricesIncludingElement = topLeftOptions * bottomRightOptions;
				totalSum += arr[i][j] * totalSubmatricesIncludingElement;
			}
		}
		System.out.println(totalSum);
		

	}

}
