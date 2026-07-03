package com.java.JavaRefresherIntermediate.Sessionn39;

import java.util.Arrays;

public class SearchForARange05 {

	public static void main(String[] args) {
		int[] arr = { 5, 7, 7, 8, 8, 10 };
		int[] ans = searchForARange(arr, 8);
		System.out.println("Output: " + Arrays.toString(ans));
	}
	public static int[] searchForARange(int[] arr, int target) {
	    return new int[] {
	            findFirst(arr, target),
	            findLast(arr, target)
	    };
	}

	private static int findFirst(int[] arr, int target) {
		
	    int low = 0;
	    int high = arr.length - 1;
	    int ans = -1;

	    while (low <= high) {

	        int mid = low + (high - low) / 2;
	        
	        if (arr[mid] == target) {
	            ans = mid;
	            high = mid - 1;      // continue searching left
	        } else if (arr[mid] < target) {
	            low = mid + 1;
	        } else {
	            high = mid - 1;
	        }
	    }

	    return ans;
	}

	private static int findLast(int[] arr, int target) {

	    int low = 0;
	    int high = arr.length - 1;
	    int ans = -1;

	    while (low <= high) {

	        int mid = low + (high - low) / 2;

	        if (arr[mid] == target) {
	            ans = mid;
	            low = mid + 1;       // continue searching right
	        } else if (arr[mid] < target) {
	            low = mid + 1;
	        } else {
	            high = mid - 1;
	        }
	    }
	    return ans;
	}
}
