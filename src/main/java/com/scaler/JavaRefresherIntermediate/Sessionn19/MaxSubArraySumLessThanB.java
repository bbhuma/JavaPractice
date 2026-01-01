package com.scaler.JavaRefresherIntermediate.Sessionn19;

public class MaxSubArraySumLessThanB {
    public static int maxSubarray(int A, int B, int[] C) {
        int maxSum = 0;  // Store the maximum subarray sum found (<= B)
        int[] prefixSum = prefixSum(C); // Precompute prefix sums

        // Outer loop: start index of subarray
        for (int i = 0; i < A; i++) {
            // Inner loop: end index of subarray
            for (int j = i; j < A; j++) {

                // Calculate sum of subarray C[i..j] using prefix sums
                int sum;
                if (i == 0) sum = prefixSum[j];
                else sum = prefixSum[j] - prefixSum[i - 1];

                // Update maxSum if this subarray sum is valid and larger
                if (sum <= B) maxSum = Math.max(maxSum, sum);
            }
        }

        // Return the maximum subarray sum <= B
        return maxSum;
    }

    // Helper to calculate prefix sums
    public static int[] prefixSum(int[] C) {
        int n = C.length;
        int[] prefix = new int[n];

        prefix[0] = C[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + C[i];
        }
        return prefix;
    }

    public static void main(String[] args) {
       
        int[] C = {2, 1, 3, 4, 5};
        int A = C.length;
        int B = 12;

        System.out.println(maxSubarray(A, B, C)); // Output: 12
    }
}

