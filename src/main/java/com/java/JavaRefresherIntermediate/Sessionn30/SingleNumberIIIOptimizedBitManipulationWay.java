package com.java.JavaRefresherIntermediate.Sessionn30;

public class SingleNumberIIIOptimizedBitManipulationWay {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 2, 3, 5 };
		int[] ans = singleNumberIII(arr);
		for(int x:ans) {
			System.out.print(x+ " ");
		}
	}

	public static int[] singleNumberIII(int[] arr) {
		int n = arr.length;
		int xor= 0;
		int xorA =0; // first unique number
		int xorB = 0;// second unique number
		int mask =0;
		
		// find XOR of array
		for(int i =0; i<n;i++) {
			xor = xor ^ arr[i];
		}
		// xor = a XOR b;
		mask = (xor & (xor-1)) ^ xor;
		
		// loop one more time to separate the array into two halves based on mask?
		for(int i=0;i<n;i++) {
			if((arr[i] & mask) != 0) { // if array element follows mask is true, put in group and xor it with xorA
				xorA = xorA ^ arr[i];
			}else {
				xorB = xorB ^ arr[i];
			}
		}
		
		return new int[] {Math.min(xorA, xorB), Math.max(xorA, xorB)}; // Create an array on fly and add elements as needed.
	}

}
