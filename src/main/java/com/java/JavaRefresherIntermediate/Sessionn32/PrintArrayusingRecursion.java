package com.java.JavaRefresherIntermediate.Sessionn32;

public class PrintArrayusingRecursion {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		printArray(arr);
	}
	public static void printArray(int[] arr) {
		printArrayHelper(arr, 0);
		System.out.println();
	}
	private static void printArrayHelper(int[] arr, int i) {
		if(i==arr.length) return; // base case, if we have reached the end of the array, we stop the recursion
		
		System.out.print(arr[i] + " "); // print the current element, then we call the function recursively for the next element
		printArrayHelper(arr, i+1);
		
		
	}
}
