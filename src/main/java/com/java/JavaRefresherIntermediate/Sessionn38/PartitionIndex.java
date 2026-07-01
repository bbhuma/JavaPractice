package com.java.JavaRefresherIntermediate.Sessionn38;

/*
pivot = arr[high]

i = low-1

for j = low to high-1

    if arr[j] < pivot
        i++
        swap(i,j)

swap(i+1, high)

return i+1
*/

public class PartitionIndex {

	public static void main(String[] args) {
		int[] arr = { 2, 0, 4, 5, 6, 1 };
		int[] arr2 = { 6, 2, 0, 4, 5 };
		System.out.println(partitionIndex(arr, 0, arr.length - 1));
	}

	public static int partitionIndex(int[] arr,int low, int high) {
		int n = arr.length;
		int pivot = arr[high];
		int i = low-1; 
		for (int j = low; j < high; j++) {
			if (arr[j] < pivot) {
				i++; // first make space for the smaller element and then increment the index and then swap the elements
				swap(arr, i, j); // swap the smaller element with the element at index i
			} 			
		}
		swap(arr, i + 1, n - 1); // need to do only once, must be outside loop
		return i+1;
	}
	private static void swap(int[] arr, int i, int j) {
		int temp = 0;
		temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
