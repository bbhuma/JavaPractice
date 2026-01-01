package com.scaler.JavaRefresherIntermediate.Sessionn19;

public class MinimumSwapsNeededForLoop {
	public static int minimumSwapsNeeded(int[] A, int threshold) {
		 int n = A.length;

	        // Step 1: Count how many elements are ≤ threshold
	        int totalGoodElements = 0;
	        for (int i = 0; i < n; i++) {
	            if (A[i] <= threshold)
	                totalGoodElements++;
	        }

	        // If no or single good element, no swaps are needed
	        if (totalGoodElements <= 1)
	            return 0;

	        // Step 2: Count bad elements (> threshold) in the first window
	        int currentBadCount = 0;
	        for (int i = 0; i < totalGoodElements; i++) {
	            if (A[i] > threshold)
	                currentBadCount++;
	        }

	        int minimumSwaps = currentBadCount;

	        // Step 3: Initialize window pointers
	        int left = 0;
	        int right = totalGoodElements - 1;

	        // Step 4: Slide the window using for-loop
	        for (; right < n - 1; ) {
	            // Move both pointers forward by 1
	            left++;
	            right++;

	            // Remove the effect of the element leaving the window
	            if (A[left - 1] > threshold)
	                currentBadCount--;

	            // Add the effect of the element entering the window
	            if (A[right] > threshold)
	                currentBadCount++;

	            // Update the minimum swaps needed
	            minimumSwaps = Math.min(minimumSwaps, currentBadCount);
	        }

	        return minimumSwaps;
	}

	public static void main(String[] args) {
		int[] A = { 1, 12, 10, 3, 14, 10, 5 };
		int[] B = { 8,3,10,20,22,13,1,2,55,5,15,50};
		System.out.println(minimumSwapsNeeded(A, 8));
		System.out.println(minimumSwapsNeeded(B, 5));
	}

}
