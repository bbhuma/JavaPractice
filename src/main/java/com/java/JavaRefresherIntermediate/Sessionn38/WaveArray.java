package com.java.JavaRefresherIntermediate.Sessionn38;

public class WaveArray {
    public static int[] wave(int[] arr) {
      int[] ans = quickSortHelper(arr,0,arr.length-1);
     // for(int num:arr) System.out.print(num+ " ");
      waveSwap(arr);
      return arr;
    }
    private static void waveSwap(int[] arr) {
		for(int i=0; i<arr.length-1;i+=2) {
			swap(arr,i,i+1);
		}
		
	}
	private static int[] quickSortHelper(int[] arr, int st, int end) {
		// Base case, stop when st>=end ie when st meets or crosses end
		if (st >= end)
			return arr;

		int pivotIndex = partition(arr, st, end);
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
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4,6,9,8,31,33};
		int[] ans = wave(arr);
		for(int num: arr) {
			System.out.print(num + " " );
		}
	}
}

