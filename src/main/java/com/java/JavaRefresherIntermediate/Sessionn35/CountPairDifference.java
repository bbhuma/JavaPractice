package com.java.JavaRefresherIntermediate.Sessionn35;

import java.util.HashMap;

public class CountPairDifference {

	public static void main(String[] args) {
		int[] arr = { 1, 5, 7, -1, 5 };
		int target = 6;
		System.out.println(countPairDifference(arr, target));
		System.out.println(countPairDifferenceOtherway(arr, target));
		
	}

	public static int countPairDifference(int[] arr, int target) {

	    long count = 0;
	    int mod = 1_000_000_007;
	    HashMap<Integer, Integer> map = new HashMap<>();

	    for (int num : arr) {
//	    	long complement1 = (num - target);
//	    	long complement2 = (num + target);
	        // Check if previous number exists
	        if (map.containsKey(num-target)) {
	            count += map.getOrDefault(num-target, 0);
	        }
	        if (map.containsKey(num+target)) {
	            count += map.getOrDefault(num+target,0);
	        }
	        count %=mod; // Take mod to avoid overflow

	        // Store current number
	        map.put(num, map.getOrDefault(num, 0) + 1);
	    }

	    return (int)(count%mod);
	}
	public static int countPairDifferenceOtherway(int[] arr, int target) {

	    long count = 0;
	    int mod = 1_000_000_007;
	    HashMap<Integer, Integer> map = new HashMap<>();

	    for (int num : arr) {
	    	long complement1 = (num - target);
	    	long complement2 = (num + target);
	        // Check if previous number exists
	        if (map.containsKey(num-target)||map.containsKey(num+target)) {
	            count += map.getOrDefault(num-target, 0)+ map.getOrDefault(num+target,0);
	        }
	        count %=mod; // Take mod to avoid overflow

	        // Store current number
	        map.put(num, map.getOrDefault(num, 0) + 1);
	    }

	    return (int)count;
	}
}
