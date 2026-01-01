package com.scaler.JavaRefresherIntermediate.Sessionn18;

import java.util.ArrayList;

public class findSpecialIndexUsingPrefixSum {
    public static int findSpecialIndex(int[] A) {
        int n = A.length;

        // Create prefix sum array
        int[] prefixSum = new int[n];
        prefixSum[0] = A[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + A[i];
        }
        ArrayList <Integer> results = new ArrayList<>();
        // Traverse the array to find the special index
        for (int i = 0; i < n; i++) {
            int leftSum = (i == 0) ? 0 : prefixSum[i - 1];
            int rightSum = prefixSum[n - 1] - prefixSum[i];

            // Check if left sum equals right sum
            if (leftSum == rightSum) {
                results.add(i);
                // return i; // Return the first special index found
            }
        }
        if(results.size() > 0){
            return results.get(0);
        }
        else{
            return -1;
        }
        // If no special index is found, return -1
       // return -1;
    }

    public static void main(String[] args) {
        int[] A = {2, 3, -1, 8, 4};
        int specialIndex = findSpecialIndex(A);
        if (specialIndex != -1) {
            System.out.println("Special Index: " + specialIndex);
        } else {
            System.out.println("No Special Index found");
        }
    }
}
