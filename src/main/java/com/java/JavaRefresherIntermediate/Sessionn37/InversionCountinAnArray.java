package com.java.JavaRefresherIntermediate.Sessionn37;

import java.util.Arrays;

public class InversionCountinAnArray {
	public static final int MOD = 1000000007;
	public static void main(String[] args) {
		int[] arr = { 2, 0, 1, 3, 5, 6, 4 };
		System.out.println((int) inversionCountinAnArray(arr, 0, arr.length - 1));
	}

	public static long inversionCountinAnArray(int[] arr, int st, int end) {
		
		long count = 0;
		// int mid = (st + end) / 2; // avoid overflow here 
		int mid = st + (end - st) / 2;
		
		if (st >= end)
			return 0; // Base condition, stops couting when only one element left
		count = (count + inversionCountinAnArray(arr, st, mid)) % MOD;

		count = (count + inversionCountinAnArray(arr, mid + 1, end)) % MOD;

		long cross = countAndMerge(arr, st, mid, end);

		return (count + cross) % MOD;
	}

	public static long countAndMerge(int[] arr, int st, int mid, int end) {
		int n1 = mid - st + 1;
		int n2 = end - mid;

		int[] left = new int[n1];
		int[] right = new int[n2];

		for (int i = 0; i < n1; i++) {
			left[i] = arr[st + i];
		}
		for (int i = 0; i < n2; i++) {
			right[i] = arr[mid + 1 + i];
		}
		long count = 0;
		int i = 0, j = 0, k = st;
		while (i < n1 && j < n2) {
			if (left[i] <= right[j]) {
				arr[k] = left[i];
				i++;
				k++;
			} else {
				arr[k] = right[j];
				j++;
				k++;
				count = (count + (n1 - i))%MOD;
			}
		}

		// in a while loop incrment operators must be there to terminate the infinite
		// loop
		while (i < n1) {
			arr[k] = left[i];
			i++;
			k++;
		}
		while (j < n2) {
			arr[k] = right[j];
			j++;
			k++;
		}
		return count;
	}

}
