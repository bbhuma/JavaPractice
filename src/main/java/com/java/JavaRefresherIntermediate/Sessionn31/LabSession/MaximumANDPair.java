package com.java.JavaRefresherIntermediate.Sessionn31.LabSession;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumANDPair {

	public static void main(String[] args) {
		int[] arr1 = { 53, 39, 88 };
		int[] arr = { 38, 44, 84, 12 };
		int ans = maximumANDPairOptimized(arr);
		System.out.println(ans);
	}

	public static int maximumANDPairBruteforce(int[] arr) {
		int n = arr.length;
		int localMax = 0;
		int max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				localMax = arr[i] & arr[j];
				max = Math.max(max, localMax);
			}
		}
		return max;
	}

	// does not always guarantee a right answer, dont use it.
	public static int maximumANDPairSorted(int[] arr) {
		Arrays.sort(arr);
		int max = 0;

		for (int i = arr.length - 1; i > 0; i--) {
			max = Math.max(max, arr[i] & arr[i - 1]);
		}

		return max;
	}

	public static int maximumANDPairBitBucket(int[] arr) {

		List<Integer> candidates = new ArrayList<>();
		for (int num : arr) {
			candidates.add(num);
		}

		for (int i = 31; i >= 0; i--) {

			List<Integer> temp = new ArrayList<>();

			for (int num : candidates) {
				if ((num & (1 << i)) != 0) {
					temp.add(num);
				}
			}

			if (temp.size() >= 2) {
				candidates = temp; // update old lost with new filtered list , if condition satisfied.
			}
		}
		return candidates.get(0) & candidates.get(1);
	}

	public static int maximumANDPairOptimized(int[] arr) {

		int n = arr.length;
		int max_ans = 0; // build your answer into this.

		// Check bits from MSB to LSB
		for (int i = 31; i >= 0; i--) {

			int count = 0;

			// Try setting i-th bit in current answer
			int possible_answer = max_ans | (1 << i); //set thw ith bit in max answer

			// Count how many elements satisfy this pattern
			for (int j = 0; j < n; j++) {
				if ((arr[j] & possible_answer) == possible_answer) {
					count++;

					// No need to check more if already 2 found
					if (count == 2) {
						break;
					}
				}
			}
			// If at least two numbers support this bit, update answer
			if (count >= 2) {
				max_ans = possible_answer;
			}
		}
		return max_ans;
	}

}
