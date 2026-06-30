package com.java.JavaRefresherIntermediate.Sessionn38;

public class QuickSortLomutoPartition {

	public static void main(String[] args) {
		int[] arr = { 5, 2, 9, 1, 5, 6 }; //Contains duplicates
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
		
		// else case is only the case, so not needed to mention
		
		// Extra work
		// Choose pivot and sort smaller element to the left and bigger elements to the
		// right around pivot
		int pivotIndex = partition(arr, st, end);

		// st<=====pivotIndex-1<======>PivotIndex====>PivotIndex+1<===>End

		// Quick sort left side, choose new pivot
		quickSortHelper(arr, st, pivotIndex - 1);

		// Quick sort right side, choose new pivot
		quickSortHelper(arr, pivotIndex + 1, end);

		return arr;
	}

	// Returns pivotIndex
	private static int partition(int[] arr, int st, int end) {
		int pivot = arr[end];
		int i = st - 1;
		for (int j = st; j < end; j++) {
			if(arr[j]<pivot) {
			i++;
			swap(arr, i, j);
			}
		}
		swap(arr, i+1, end);
		return i+1;
	}
	
	// Swap method does not need a return type, simply swap i,j in the same array
	private static void swap(int[] arr, int i, int j) {
		int temp = 0;
		temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
