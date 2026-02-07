package src.main.java.com.scaler.JavaRefresherIntermediate.Sessionn26;

// This class finds the maximum sum of a contiguous subarray
public class MaxSumOfContiguousSubarray {

	// Main method: execution starts here
	public static void main(String[] args) {

		// Input array containing both positive and negative numbers
		int[] A = { -2, 3, 1, -5, 6, 7, 8, -10 };

		// Calling maxSubArray method and printing the result
		System.out.println(maxSubArrayOptimized(A));
	}

	// Method to find maximum sum of any contiguous subarray
	public static int maxSubArray(final int[] A) {

		// Initialize maxPossibleSum with first element
		// This handles the edge case when all elements are negative
		int maxPossibleSum = A[0];

		// Length of the array
		int n = A.length;

		// Generate prefix sum array using helper method
		int[] prefixSum = pfSummethod(A);

		// Iterate through the array
		for (int i = 0; i < n; i++) {

			// Temporary variable to hold sum at index i
			int sum = 0;

			// Add prefix sum value at current index
			sum += prefixSum[i];

			// If prefix sum is positive, it can contribute to max subarray sum
			if (prefixSum[i] > 0)
				maxPossibleSum = Math.max(maxPossibleSum, prefixSum[i]);
			else
				// If prefix sum is zero or negative,
				// consider the current element itself
				maxPossibleSum = Math.max(maxPossibleSum, A[i]);
		}

		// Return the maximum subarray sum found
		return maxPossibleSum;
	}

	// Method to compute prefix sum array (Kadane style)
	public static int[] pfSummethod(int[] arr) {

		// Array to store prefix sums
		int[] pfSumarr = new int[arr.length];

		// Variable to maintain running prefix sum
		int pfSum = 0;

		// Iterate through input array
		for (int i = 0; i < arr.length; i++) {

			// Add current element to running sum
			pfSum += arr[i];

			// If running sum is positive, store it
			if (pfSum > 0)
				pfSumarr[i] = pfSum;
			else
				// If running sum becomes zero or negative,
				// reset it to 0 (start new subarray)
				pfSum = 0;
		}

		// Return the prefix sum array
		return pfSumarr;
	}

	public static int maxSubArrayReadble(int[] A) {

		int n = A.length;

		// Edge case: assume first element is the answer initially
		int maxSum = A[0];

		// Build prefix sum array (Kadane-style)
		int[] prefixSum = buildPositivePrefixSum(A);

		// Traverse prefix sum array to find maximum subarray sum
		for (int i = 0; i < n; i++) {

			if (prefixSum[i] > 0) {
				// Positive running sum can form a valid subarray
				maxSum = Math.max(maxSum, prefixSum[i]);
			} else {
				// When running sum is 0, fallback to single element
				maxSum = Math.max(maxSum, A[i]);
			}
		}

		return maxSum;
	}

	public static int[] buildPositivePrefixSum(int[] arr) {

		int[] prefixSum = new int[arr.length];
		int runningSum = 0;

		for (int i = 0; i < arr.length; i++) {

			runningSum += arr[i];

			if (runningSum > 0) {
				// Store positive running sum
				prefixSum[i] = runningSum;
			} else {
				// Reset running sum if it becomes non-positive
				runningSum = 0;
				prefixSum[i] = 0;
			}
		}

		return prefixSum;
	}

	public static int maxSubArrayOptimized(int[] A) {

		int n = A.length;

		// Edge case: assume first element is the answer initially
		int currMax = A[0];
		int maxSum = A[0];

		// Traverse prefix sum array to find maximum subarray sum
		for (int i = 1; i < n; i++) {
			currMax = Math.max(A[i], currMax + A[i]); // If previous sum < 0 → start fresh or If previous sum ≥ 0 →
														// continue
			maxSum = Math.max(maxSum, currMax);
		}

		return maxSum;
	}

}
