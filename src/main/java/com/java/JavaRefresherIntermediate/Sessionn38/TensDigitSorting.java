package com.java.JavaRefresherIntermediate.Sessionn38;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TensDigitSorting {

	public static void main(String[] args) {
		int[] arr = { 12, 15, 17, 23, 25, 34, 45, 56, 67, 78, 89, 90, 7, 8, 9, 10, 11, 22, 33, 44, 55, 66, 77, 88, 99 };
		int[] newarr = tensDigitSortingDescending(arr);
		for (int num : newarr) {
			System.out.print(num + " ");
		}
	}

	public static int[] tensDigitSortingDescending(int[] arr) {
		return Arrays.stream(arr).boxed().sorted((a, b) -> {
			int tensCompare = Integer.compare((a / 10) % 10, (b / 10) % 10);
			if (tensCompare != 0) {
				return tensCompare;
			}
			return Integer.compare(b, a);
		}).mapToInt(Integer::intValue).toArray();

		// Arrays.sort(arr, (a, b) -> Integer.compare((a / 10) % 10, (b / 10) % 10));
	}

}
