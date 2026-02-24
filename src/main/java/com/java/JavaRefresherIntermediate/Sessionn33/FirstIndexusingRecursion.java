package com.java.JavaRefresherIntermediate.Sessionn33;

public class FirstIndexusingRecursion {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.println(firstIndexUsingRecursion(arr, 5));
		System.out.println(firstIndexUsingRecursion(arr, 10));
	}

	private static int firstIndexUsingRecursion(int[] arr, int target) {
		if (arr.length == 0)
			return -1;
		return helper(arr, 0, target);
	}

	private static int helper(int[] arr, int j, int target) { // index = 0 to arr.length-1
		if (j == arr.length) return -1; // Base case, if we have reached end of array and not found target, return -1
		
		if (arr[j] == target) return j; // Our work, if we find the target at index i, return i
		
		return helper(arr, j + 1, target); // recursion
	}

}
