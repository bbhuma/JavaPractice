package com.java.JavaRefresherIntermediate.Sessionn40;

public class SortedInsertPosition {

	public static void main(String[] args) {
		int[] arr = {1,3,5,6};
		int target1 = 5;
		int target2 = 4;
		int target3 = 25;
		sortedInsertPosition(arr, target2);
		System.out.println("The position to insert " + target1 + " is: " + sortedInsertPosition(arr, target1));
		System.out.println("The position to insert " + target2 + " is: " + sortedInsertPosition(arr, target2));
		System.out.println("The position to insert " + target3 + " is: " + sortedInsertPosition(arr, target3));
	}

	public static int sortedInsertPosition(int[] arr, int target) {
		int n= arr.length;
		int low = 0;
		int high = n - 1;
	
			while(low <= high) {
				int mid = low + (high - low) / 2;
				if(arr[mid] == target) {
					return mid;
				}
				else if(arr[mid] < target) { // arr[mid] < target this is always true even after 
					low = mid + 1;
				}
				else {
					high = mid - 1;
				}
			}
			return low;
		
	}

}
