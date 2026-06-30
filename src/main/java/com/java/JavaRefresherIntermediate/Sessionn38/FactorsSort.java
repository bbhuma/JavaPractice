package com.java.JavaRefresherIntermediate.Sessionn38;

import java.util.Arrays;

public class FactorsSort {

	public static void main(String[] args) {
		int[] arr = { 2, 6, 8, 9, 10, 15 };
		int[] factorsSort = factorsSort(arr);
		for (int num : factorsSort) {
			System.out.print(num + " ");
		}
	}

	public static int[] factorsSort(int[] arr) {
		int n = arr.length;
		/*
		 * Integer[] newarr = new Integer[arr.length]; for(int i=0;i<arr.length;i++) {
		 * newarr[i]= arr[i]; }
		 */
		// Convert int[] to Integer[] using streams or use for loop to copy
		Integer[] newarr = Arrays.stream(arr).boxed().toArray(Integer[]::new);

		// Reverse Integer[] to int[]
		// int[] arr = Arrays.stream(integerArr).mapToInt(Integer::intValue).toArray();

		Arrays.sort(newarr, (a, b) -> {
			int countA = countFactors(a);
			int countB = countFactors(b);
			if (countA != countB) {
				return Integer.compare(countA, countB);
			} else {
				return Integer.compare(a, b);
			}
		});
		return Arrays.stream(newarr).mapToInt(Integer::intValue).toArray();
	}

	private static int countFactors(Integer n) {
		int countFacts = 0;
		
		for (int i = 1; i * i <= n; i++) {
			if (n % i == 0) {
				countFacts++;
				if (i != n / i) {
					countFacts++;
				}
			}
		}
		return countFacts;
	}
}
