package com.java.JavaRefresherIntermediate.Sessionn36;

import java.util.HashMap;

public class Subarraywith0sum {

	public static void main(String[] args) {
		int[] arr = {1,23,21,-21,-23,1,3,4,-4};
		System.out.println(subarraywith0sumOptimizedMap(arr));
		System.out.println(subarraywith0sumOptimizedMap(arr, 3));
		
	}
	// Time Complexity: O(N^2) | Space Complexity: O(1)
	public static int subarraywith0sumBrute(int[] arr) {
		int n = arr.length;
		for(int i = 0; i < n; i++) {
			int sum = 0; // track the sum of the current subarray
			for(int j = i; j < n; j++) {
				sum += arr[j];
				if(sum == 0) {
					return 1;
				}
			}
		}
		return 0;
	}
	// Time Complexity: O(N) | Space Complexity: O(N)
	public static int subarraywith0sumOptimizedMap(int[] arr) {
		int n = arr.length;
		int prefix =0;
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < n; i++) {
			prefix += arr[i];
			if(map.containsKey(prefix)) { // if prefix is 0, it means we have found a subarray from the start to the current index that sums to 0
				return 1; // if the prefix sum has been seen before, it means there is a subarray between the previous index and the current index that sums to 0
			}
			map.put(prefix, 1);
		}
		return 0;
	}
	public static int subarraywith0sumOptimizedMap(int[] arr,int k) {
		int n = arr.length;
		int prefix =0;
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < n; i++) {
			prefix += arr[i];
			if(map.containsKey(prefix-k) || prefix == k) { // if prefix is 0, it means we have found a subarray from the start to the current index that sums to 0
				return 1; // if the prefix sum has been seen before, it means there is a subarray between the previous index and the current index that sums to 0
			}
			map.put(prefix, i);
		}
		return 0;
	}
}
