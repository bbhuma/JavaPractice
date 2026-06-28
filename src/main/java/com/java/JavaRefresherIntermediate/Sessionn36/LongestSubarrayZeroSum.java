package com.java.JavaRefresherIntermediate.Sessionn36;

import java.util.HashMap;

public class LongestSubarrayZeroSum {

	public static void main(String[] args) {
		int[] arr = { 1, 23, 21, -21, -23, 1, 3, 4, -4 };
		System.out.println(longestSubarrayZeroSum(arr));

	}

	public static int longestSubarrayZeroSum(int[] arr) {
		int n = arr.length;
		int maxLength = 0;
		int prefix = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, -1); // we are putting 0 in the map with index -1, because if we find a prefix sum of
						// 0, it means we have found a subarray from the start to the current index that
						// sums to 0
		for (int i = 0; i < n; i++) {
			prefix += arr[i]; // we are storing the prefix sum in the array itself, so that we can use it to
								// find the longest subarray that sums to 0
			if (map.containsKey(prefix)) { // if the prefix sum has been seen before, it means there is a subarray
											// between the previous index and the current index that sums to 0
				maxLength = Math.max(maxLength, i - map.get(prefix)); // we are calculating the length of the subarray
																		// and updating the maxLength
			} else {
				map.put(prefix, i); // if the prefix sum has not been seen before, we are putting it in the map with
									// its index
			}
		}
		return maxLength;
	}

}
