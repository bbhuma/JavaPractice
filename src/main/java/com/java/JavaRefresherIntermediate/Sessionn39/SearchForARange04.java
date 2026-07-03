package com.java.JavaRefresherIntermediate.Sessionn39;

import java.util.Arrays;

/* int[] arr = {8, 8, 8, 8};
 * target = 8;
 * Output should be [0,3] 
 * Answer can be inclusive of 0 and n-1 
Binary Search

↓

Found Target

↓

Expand Left (Linear)

↓

Expand Right (Linear)

8 8 8 8 8 8 8 8

↓

Expand entire array

↓

O(n)

*/

public class SearchForARange04 {

	public static void main(String[] args) {
		int[] arr = { 5, 7, 7, 8, 8, 8, 8, 8, 8, 10 };
		int[] ans = searchForARange(arr, 8);
		System.out.println("Output: " + Arrays.toString(ans));
	}
	public static int[] searchForARange(final int[] arr, int target) {
		// int[] search space i.e. from index 0 to N-1.
		int low = 0;
		int high = arr.length - 1;

		// Better initialization, n case you don't find the target in array
		int leftmostIdx = -1;
		int rightMostIdx = -1;

		while (low <= high) {
			int mid = (low + high) / 2;
			if (target < arr[mid]) {
				high = mid - 1; // move high left
			} else if (target > arr[mid]) {
				low = mid + 1; // move low to right
			} else {
				// store the mid index and then move left and right to find the leftmost and
				// rightmost index of the target
				leftmostIdx = mid;
				rightMostIdx = mid;

				while (leftmostIdx > 0 && arr[leftmostIdx - 1] == target) {
					leftmostIdx--;
				}

				while (rightMostIdx < arr.length - 1 && arr[rightMostIdx + 1] == target) {
					rightMostIdx++;
				}
				break; // you must break after looping for first and last elements
			}
		}
		return new int[] { leftmostIdx, rightMostIdx };
	}

}
