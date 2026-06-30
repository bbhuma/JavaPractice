package com.java.JavaRefresherIntermediate.Sessionn38;

public class PartitionIndex {

	public static void main(String[] args) {
		int[] arr = { 2, 0, 4, 5, 6, 1 };
		int[] arr2 = { 6, 2, 0, 4, 5 };
		System.out.println(partitionIndex(arr));
	}

	public static int partitionIndex(int[] arr) {
		int n = arr.length;
		int pivot = arr[n - 1];
		int i = -1;
		for (int j = 0; j < n - 1; j++) {
			if (arr[j] < pivot) {
				i++;
				swap(arr, i, j);
			} else {
				j++;
				swap(arr, i, j);
			}
			swap(arr, i + 1, n - 1);
		}
		return i+1;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = 0;
		temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
