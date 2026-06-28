package com.java.JavaRefresherIntermediate.Sessionn35;

import java.util.HashMap;

public class CheckPairSum {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		int target = 5;
		System.out.println(checkPairSum(arr, target));
	}

	public static int checkPairSum(int[] arr, int target) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			int complement = target - arr[i];
			if (map.containsKey(complement)) {
				System.out.println("Pair found: " + arr[i] + " and " + complement);
				return 1;
			}
			map.put(arr[i], i); // we are putting the current element in the map, so that we can check for its complement in the next iterations
		}
		return 0;
	}
}
