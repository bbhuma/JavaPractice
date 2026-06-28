package com.java.JavaRefresherIntermediate.Sessionn35;

import java.util.HashMap;
import java.util.HashSet;

public class Countdistinctelements {
	/*
	 * Distinct = different elements, including ones with duplicates. Unique =
	 * different elements, excluding ones with duplicates.
	 */
	
	public static void main(String[] args) {
	int[] arr = {1, 2, 3, 4, 5, 1, 2, 3};
    System.out.println(countDistinct(arr)); // 1,2,3,4,5
    System.out.println(countUniqueElementsMapWay(arr)); // 4,5
    
	}
	public static int countDistinct(int[] arr) {
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			set.add(arr[i]);
		}
		return set.size(); // This will return the count of distinct elements, which is the size of the set.

	}
	public static int countUniqueElementsMapWay(int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int count = 0;
			for (int i = 0; i < arr.length; i++) {
				if (!map.containsKey(arr[i])) {
					map.put(arr[i], 1);
				} else {
					map.put(arr[i], map.get(arr[i]) + 1);
				}
			}
			for (int freq : map.values()) {
				if(freq == 1) {
					count++;
					
				}
			}
			return count;
		}
}
