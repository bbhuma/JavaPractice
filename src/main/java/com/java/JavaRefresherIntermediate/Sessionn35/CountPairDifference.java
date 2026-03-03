package com.java.JavaRefresherIntermediate.Sessionn35;

import java.util.HashMap;

public class CountPairDifference {

	public static void main(String[] args) {
		int[] arr = { 1, 5, 7, -1, 5 };
		int target = 6;
		System.out.println(countPairDifference(arr, target));
		
	}

	public static int countPairDifference(int[] arr, int target) {

	    int count = 0;
	    HashMap<Integer, Integer> map = new HashMap<>();

	    for (int num : arr) {
	    	int complement = Math.abs(num - target);
	        // Check if previous number exists
	        if (map.containsKey(complement)) {
	            count += map.get(complement);
	        }

	        // Store current number
	        map.put(num, map.getOrDefault(num, 0) + 1);
	    }

	    return count;
	}

}
