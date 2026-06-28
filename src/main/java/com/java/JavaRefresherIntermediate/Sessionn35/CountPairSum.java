package com.java.JavaRefresherIntermediate.Sessionn35;

import java.util.HashMap;

public class CountPairSum {

	public static void main(String[] args) {
		int[] arr = { 1, 5, 7, -1, 5 };
		int target = 6;
		System.out.println(countPairSum(arr, target));
	}

	public static int countPairSum(int[] arr, int target) {

		long mod = 1_000_000_007;
		long count = 0;

		HashMap<Long, Long> map = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {

			long current = arr[i]; // convert once
			long complement = (long) target - current;

			if (map.containsKey(complement)) {
				count = (count + map.get(complement)) % mod; // add the count of complement in the map to the count variable, and take mod to avoid overflow
			}

			map.put(current, map.getOrDefault(current, 0L) + 1);
		}

		return (int) (count % mod);
	}

}
