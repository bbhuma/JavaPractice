package com.java.JavaRefresherIntermediate.Sessionn31.LabSession;

public class MaximumANDPair {

	public static void main(String[] args) {
		int[] arr1 = {53,39,88};
		int[] arr= {38, 44, 84, 12};
		int ans = maximumANDPair(arr);
		System.out.println(ans);
	}

	public static int maximumANDPair(int[] arr) {
		int n = arr.length;
		int localMax= 0;
		int max=0;
		for(int i=0;i<n;i++) {
			for(int j=i+1;j<n;j++) {
				localMax = arr[i] & arr[j];
				max = Math.max(max, localMax);
			}
		}
		return max;
	}
	
	public static int maximumANDPairOptimized(int[] arr) {
		int n = arr.length;
		int max = 0;
		for(int i=31;i>=0;i--) { // 32*n Time complexity, but we are only checking 32 bits, so O(1) time complexity.
			int count = 0;
			int mask = max | (1 << i);
			for(int j=0;j<n;j++) {
				if((arr[j] & mask) == mask) {
					count++;
				}
			}
			if(count >= 2) {
				max = mask;
			}
		}
		return max;
	}

}
