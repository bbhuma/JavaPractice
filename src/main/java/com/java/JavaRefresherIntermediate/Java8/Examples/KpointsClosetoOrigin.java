package com.java.JavaRefresherIntermediate.Java8.Examples;

import java.util.Arrays;

public class KpointsClosetoOrigin {

	public static void main(String[] args) {
		int[][] arr = { { 1, 3 }, { -2, 2 }, { 5, 8 }, { 0, 1 } };
		int[][] ans = KpointsClosetoOriginEucledian(arr, 3);
		System.out.print("[");
		for (int[] num : ans) {
			System.out.print(Arrays.toString(num));
		}
	}

	public static int[][] KpointsClosetoOriginEucledian(int[][] arr, int k) {
		return Arrays.stream(arr).sorted((a, b) -> Integer.compare(a[0] * a[0] + a[1] * a[1], b[0] * b[0] + b[1] * b[1]))
				.limit(k).toArray(int[][]::new);
	}

}
