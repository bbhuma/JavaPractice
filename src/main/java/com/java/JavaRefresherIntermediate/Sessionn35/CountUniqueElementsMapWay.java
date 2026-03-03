package com.java.JavaRefresherIntermediate.Sessionn35;

import java.util.HashMap;

public class CountUniqueElementsMapWay {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 1, 2, 3 };
		System.out.println(countUniqueElementsMapWay(arr));
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
