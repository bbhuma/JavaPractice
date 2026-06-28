package com.java.JavaRefresherIntermediate.Sessionn35;

import java.util.HashMap;

public class Frequencyofelementquery {

	public static void main(String[] args) {
		int[] freqArray = {1, 2, 3, 4, 5, 2, 3, 1};
		int[] learners = {1, 2, 3, 4, 5, 6};
		int[] ans = frequencyofelementquery(freqArray, learners);
		for (int i = 0; i < learners.length; i++) {
			System.out.println("Frequency of " + learners[i] + " is " + frequencyofelementquery(freqArray, learners)[i]);
		}
		System.out.println("");
		System.out.print("[");
		for(int i : ans) {
			System.out.print(i+" ");
			
		}
		System.out.print("]");
	}
	public static int[] frequencyofelementquery(int[] arr, int[] queries) {
		int n = arr.length;
		int m= queries.length;
		HashMap<Integer, Integer> freqMap = new HashMap<>();
		for (int i = 0; i < n; i++) {
			freqMap.put(arr[i], freqMap.getOrDefault(arr[i], 0) + 1);
		}
		int[] ans = new int[m];
		for (int i = 0; i < m; i++) {
			ans[i] = freqMap.getOrDefault(queries[i], 0);
		}
		return ans;
	}

}
