package com.java.JavaRefresherIntermediate.Sessionn36;

import java.util.HashMap;

public class Subarraywithgivensum {

	public static void main(String[] args) {
		int[] arr = {1,23,21,-21,-23,1,3,4,-4};
		int k = 3;
		System.out.println(subarraywithgivensumOptimizedMap(arr,k));
	}

	public static int subarraywithgivensumOptimizedMap(int[] arr, int k) {
		int n = arr.length;
		int prefix =0;
		int count = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < n; i++) {
			prefix += arr[i];
			if(map.containsKey(prefix-k) || prefix == k) { // if prefix is 0, it means we have found a subarray from the start to the current index that sums to 0
				count += map.get(prefix-k); // if the prefix sum has been seen before, it means there is a subarray between the previous index and the current index that sums to 0
			}
			map.put(prefix, map.getOrDefault(prefix, 0) + 1); // we are storing the count of the prefix sums in the map, so that we can use it to count the number of subarrays that sum to k
		}
		return count;
	}

}
