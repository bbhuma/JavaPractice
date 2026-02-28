package com.java.JavaRefresherIntermediate.Sessionn34;

public class Deleteone {

	public static void main(String[] args) {
		int[] arr = { 12, 15, 18 };
		System.out.println("Brute Force Approach:"+ DeleteoneToMaxGCDArrayBruteForce(arr));
		 System.out.println("Optimized Approach:"+ DeleteoneToMaxGCDArrayOptimized(arr));
	}
	
	public static int DeleteoneToMaxGCDArrayOptimized(int[] arr) {
		int[] prefixGCD = prefixGCD(arr);
		int[] suffixGCD = suffixGCD(arr);
		int maxGCD = 0;
		for (int i = 1; i < arr.length-1; i++) {
			int gcd = 0;
			if(i==0) maxGCD = suffixGCD[1];
			else if(i==arr.length-1) maxGCD = prefixGCD[arr.length-2];
			else {
			gcd = gcd(prefixGCD[i - 1], suffixGCD[i + 1]);
			maxGCD = Math.max(maxGCD, gcd);
			}
		}
		return maxGCD;
	}

	public static int[] suffixGCD(int[] arr) {
		int[] suffixGCD = new int[arr.length];
		suffixGCD[arr.length - 1] = arr[arr.length - 1];
		for (int i = arr.length - 2; i >= 0; i--) {
			suffixGCD[i] = gcd(suffixGCD[i + 1], arr[i]);
		}
		return suffixGCD;
	}

	public static int[] prefixGCD(int[] arr) {
		int[] prefixGCD = new int[arr.length];
		prefixGCD[0] = arr[0];
		for (int i = 1; i < arr.length; i++) {
			prefixGCD[i] = gcd(prefixGCD[i - 1], arr[i]);
		}
		return prefixGCD;
	}

	public static int DeleteoneToMaxGCDArrayBruteForce(int[] arr) {
		int maxGCD = 0;
		for (int i = 0; i < arr.length; i++) {
			int gcd = findGCD(arr, i);
			maxGCD = Math.max(maxGCD, gcd);
		}
		System.out.println("Maximum GCD after deleting one element: " + maxGCD);
		return maxGCD;
	}
	public static int findGCD(int[] arr, int indexToDelete) {	
		int gcd = 0;
		for (int i = 0; i < arr.length; i++) {
			if (i != indexToDelete) {
				gcd = gcd(gcd, arr[i]);
			}
		}
		return gcd;
	}
	public static int gcd(int gcd, int i) {
		if (gcd == 0) return i; // if gcd is 0, then we can take the first element as the gcd, and then compare it with the rest of the elements
		if (i == 0) return gcd; // if i is 0, then we can take the gcd as the gcd, and then compare it with the rest of the elements
		return gcd(i, gcd % i); // we are using the Euclidean algorithm to find the gcd of two numbers, which is based on the principle that the gcd of two numbers also divides their difference
	}

}
