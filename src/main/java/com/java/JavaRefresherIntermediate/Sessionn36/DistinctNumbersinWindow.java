package com.java.JavaRefresherIntermediate.Sessionn36;

import java.util.HashSet;

public class DistinctNumbersinWindow {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 1, 2, 3}; // 8 elements, window size = 4, 8-4+1 = 5 windows
		int windowSize = 4;
		distinctNumbersinWindow(arr, windowSize);
	}
	public static void distinctNumbersinWindow(int[] arr,int windowSize) {
		int n = arr.length;
		for(int i=0; i<=n-windowSize; i++) {
			HashSet<Integer> set = new HashSet<>();
			for(int j=i; j<i+windowSize; j++) {
				set.add(arr[j]);
			}
			System.out.println(set.size());
		}
	
	}

}
