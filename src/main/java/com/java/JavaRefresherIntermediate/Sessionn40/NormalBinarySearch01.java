package com.java.JavaRefresherIntermediate.Sessionn40;

public class NormalBinarySearch01 {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int target = 7;
		int index = normalBinarySearch(arr, target);
		System.out.println(index);

	}

	/* నువ్వు arrayలో search చేయడం లేదు.
	 * నువ్వు search space ని search చేస్తున్నావు
	 * Binary search is only applicable on sorted arrays. It is a searching
	 * algorithm that finds the position of a target value within a sorted array.
	 * Binary search compares the target value to the middle element of the array.
	 * If they are not equal, the half in which the target cannot lie is eliminated
	 * and the search continues on the remaining half until it is successful. If the
	 * search ends with the remaining half being empty, the target is not in the
	 * array. mid = (low + high) / 2 if(target < arr[mid]) high = mid - 1 , move
	 * left if(target > arr[mid]) low = mid + 1 , move right
	 */
	public static int normalBinarySearch(int[] arr, int target) {
		// i,j are low and high of a search space, get the search space first
		int low =0; 
		int high = arr.length-1;
		int answer = -1;
		while(low <= high){ // Valid search space. low> high is not valid
		    int mid = (low+high)/2;
			if(target < arr[mid]) {
				high = mid-1; // move high pointer  to first half to left
			}else if (target > arr[mid]) {
				low = mid+1; // move low pointer to second half, to right
			}else return mid;
		}
		return answer; // very important when target is not found
	}

}
