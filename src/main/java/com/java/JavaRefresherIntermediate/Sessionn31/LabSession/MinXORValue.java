package com.java.JavaRefresherIntermediate.Sessionn31.LabSession;

import java.util.Arrays;

public class MinXORValue {

	public static void main(String[] args) {
	

	}
	public static int findMinXor(int[] arr) {
		int n= arr.length;
		Arrays.sort(arr);
		int min = Integer.MAX_VALUE;
		for(int i=0;i<n-1;i++) {
			min = Math.min(min, (arr[i] ^ arr[i+1]));
		}
		return min;
	}
	
	public static int findMaxXor(int[] arr) {
		int n= arr.length;
		Arrays.sort(arr);
		int max = Integer.MIN_VALUE;
		for(int i=0;i<n-1;i++) {
			max = Math.max(max, (arr[i] ^ arr[i+1]));
		}
		return max;
	}
}
