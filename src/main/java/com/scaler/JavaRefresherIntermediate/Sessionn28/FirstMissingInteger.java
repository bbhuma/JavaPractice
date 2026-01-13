package com.scaler.JavaRefresherIntermediate.Sessionn28;

public class FirstMissingInteger {
	public static void main(String[] args) {
		int[] arr = { 3, 4, 4, -1, 1 }; // Array can be empty, can have negative numbers, duplicates, may also only have positive numbers
		                                // Output should be 2
		                                // Another example: {1,2,0} -> Output should be 3
		                                // Another example: {-1,-2} -> Output should be 1
		                                // Another example: {2,3,4} -> Output should be 1
										// Another example: {1,2,3} -> Output should be 4
		                                // Another example: {} -> Output should be 1
		System.out.println(firstMissingInteger(arr));
	}

	public static int firstMissingInteger(int[] arr) {
		boolean[] isPresent = new boolean[arr.length + 1];
		if(arr.length==0) {
			return 1;
		}
		for (int num : arr) {
			if (num > 0 && num <= arr.length) {
				isPresent[num - 1] = true; // marking the index as true, since we are using zero based index for array at position num-1
			}
		}
		for (int i = 0; i < isPresent.length; i++) {
			if (isPresent[i] == false) {
				return i + 1;// this is zero based index, so we add 1
			}
		}
		return arr.length + 1;
	}

}
