package com.java.JavaRefresherIntermediate.Sessionn36;

import java.util.HashMap;

public class CountSubarrayZeroSum {

	public static void main(String[] args) {
		int[] arr = {1,23,21,-21,-23,1,3,4,-4};
		int k = 3;
		System.out.println(countSubarrayZeroSumPractice(arr));
		System.out.println(countSubarrayZeroSumGPT(arr));
		System.out.println(countSubarrayKSum(arr,k));
	}

	public static int countSubarrayKSum(int[] arr, int k) {
		int count = 0;
		int n = arr.length;
		HashMap<Integer, Integer> map = new HashMap<>();
		int prefix = 0;
		for(int i = 0; i < n; i++) {
			prefix += arr[i];
			if(map.containsKey(prefix-k) || prefix == k) { // if prefix is 0, it means we have found a subarray from the start to the current index that sums to 0
				count += map.get(prefix-k); // if the prefix sum has been seen before, it means there is a subarray between the previous index and the current index that sums to 0
			}
			map.put(prefix, map.getOrDefault(prefix, 0) + 1); // we are storing the count of the prefix sums in the map, so that we can use it to count the number of subarrays that sum to k
		}
		return count;
	}

	public static int countSubarrayZeroSumPractice(int[] arr) {
		long count = 0;
		int mod = 1000000007;
		int n = arr.length;
		HashMap<Long, Integer> map = new HashMap<>();
		map.put(0L,1); // we are putting 0 in the map with count 1, because if we find a prefix sum of 0, it means we have found a subarray from the start to the current index that sums to 0
		long prefix = 0;
		for(int i = 0; i < n; i++) {
			prefix += arr[i];
			if(map.containsKey(prefix) || prefix == 0) { // if prefix is 0, it means we have found a subarray from the start to the current index that sums to 0
				count = (count +  map.get(prefix))%mod; // if the prefix sum has been seen before, it means there is a subarray between the previous index and the current index that sums to 0
			}
			map.put(prefix, map.getOrDefault(prefix, 0) + 1); // we are storing the count of the prefix sums in the map, so that we can use it to count the number of subarrays that sum to k
		}
		return (int) (count%mod);
	}
	public static int countSubarrayZeroSumGPT(int[] arr) {
	    long count = 0;
	    int mod = 1000000007;
	    HashMap<Long, Integer> map = new HashMap<>();
	    map.put(0L,1);
	    long prefix = 0;
	    for(int i=0;i<arr.length;i++){
	        prefix += arr[i];
	        if(map.containsKey(prefix)){
	            count = (count + map.get(prefix)) % mod;
	        }
	        map.put(prefix, map.getOrDefault(prefix,0)+1);
	    }
	    return (int)(count % mod);
	}

}
