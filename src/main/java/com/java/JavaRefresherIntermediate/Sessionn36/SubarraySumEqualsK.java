package com.java.JavaRefresherIntermediate.Sessionn36;

import java.util.ArrayList;
import java.util.HashMap;

public class SubarraySumEqualsK {

	public static void main(String[] args) {
		int[] arr = {1,23,21,-21,-23,1,3,4,-4};
		// int k = 24;
		int k = 0;
		int[] result = subarraySumEqualsK(arr, k);
		 for(int x : result) {
			 System.out.print(x+" ");
		 }

	}
	public static int[] subarraySumEqualsK(int[] arr,int k) {
		int n= arr.length;
		
		ArrayList<Integer> list = new ArrayList<>();
		HashMap<Long, Integer> map = new HashMap<>();
		long prefix = 0;
		map.put(0L, -1); // we are putting 0 in the map with index -1, because if we find a prefix sum of 0, it means we have found a subarray from the start to the current index that sums to 0
		
		// prefix[i] - prefix[j] = k, means the sum of the subarray from index j+1 to index i is k, because prefix[i] is the sum of the subarray from index 0 to index i, and prefix[j] is the sum of the subarray from index 0 to index j, so if we subtract prefix[j] from prefix[i], we get the sum of the subarray from index j+1 to index i, which should be equal to k.
		// prefix[i] - k = prefix[j], means the sum of the subarray from index j+1 to index i is k, because prefix[i] is the sum of the subarray from index 0 to index i, and prefix[j] is the sum of the subarray from index 0 to index j, so if we subtract k from prefix[i], we get the sum of the subarray from index j+1 to index i, which should be equal to k.
		for(int i = 0; i < n; i++) {
			prefix += arr[i];
			if(map.containsKey(prefix-k)|| prefix == k) { // if prefix is 0, it means we have found a subarray from the start to the current index that sums to 0
				int startIndex = map.get(prefix-k);// if the prefix sum has been seen before, it means there is a subarray between the previous index and the current index that sums to 0
				int endIndex = i;
				for(int j = startIndex+1; j <= endIndex; j++) {
					list.add(arr[j]);
				}
				break; // first sub array only, stop here. 
			}
			map.put(prefix, i);
		}
		return list.size()>0? list.stream().mapToInt(Integer::intValue).toArray(): new int[] {-1};
	}
	

}
