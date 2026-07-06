package com.java.JavaRefresherIntermediate.Sessionn40;

public class FindLastRightMostElementBinarySearch03 {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6,7, 7, 7,7, 7, 7, 7, 7, 7, 8, 9, 10 };
		int target = 7;
		int index = rightMostBinarySearch(arr, target);
		System.out.println(index);

	}

	public static int rightMostBinarySearch(int[] arr, int target) {
		int low = 0;
		int high = arr.length - 1;
		int answer = -1; // when no target is found
		while (low <= high) {
			int mid = (low + high) / 2;
			if (target < arr[mid]) {
				high = mid - 1;
			} else if (target > arr[mid]) {

				low = mid + 1;
			} else {
				answer = mid; // remember answer
				low = mid + 1; // keep searching RIGHT
			}
		}
		return answer;
	}

}
