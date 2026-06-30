package com.java.JavaRefresherIntermediate.Sessionn38;

public class QuickSortHoarePartition {

	public static void main(String[] args) {
		int[] arr = { 5, 2, 9, 1, 5, 6 }; // Contains duplicates
		quickSort(arr);
		for (int num : arr) {
			System.out.print(num + " ");
		}
	}

	public static int[] quickSort(int[] arr) {

		return quickSortHelper(arr, 0, arr.length - 1);
	}

	private static int[] quickSortHelper(int[] arr, int st, int end) {
		// Base case, stop when st>=end ie when st meets or crosses end
		if (st >= end)
			return arr;

		int pivotIndex = partition(arr, st, end);

		// Quick sort left side, choose new pivot
		quickSortHelper(arr, st, pivotIndex);

		// Quick sort right side, choose new pivot
		quickSortHelper(arr, pivotIndex + 1, end);
		return arr;
	}

	// Returns pivotIndex
	private static int partitionDoWhile(int[] arr, int st, int end) {

		// int pivotIndex = st;

		int pivotValue = arr[st];

		int i = st - 1;
		int j = end + 1;
		while (true) {
			do {
				i++;
			} while (arr[i] < pivotValue);
			do {
				j--;
			} while (arr[j] > pivotValue);

			if (i >= j)
				return j;

			swap(arr, i, j);

		}
	}

	private static int partition(int[] arr, int st, int end) {

	    int pivotValue = arr[st];

	    int i = st;
	    int j = end;

	    while (true) {

	        while (i <= end && arr[i] < pivotValue) {
	            i++;
	        }

	        while (j >= st && arr[j] > pivotValue) {
	            j--;
	        }

	        if (i >= j) {
	            return j;
	        }

	        swap(arr, i, j);

	        // IMPORTANT
	        i++;
	        j--;
	    }
	}

	// Swap method does not need a return type, simply swap i,j in the same array
	private static void swap(int[] arr, int i, int j) {
		int temp = 0;
		temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
