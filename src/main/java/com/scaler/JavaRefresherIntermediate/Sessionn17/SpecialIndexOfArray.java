package com.scaler.JavaRefresherIntermediate.Sessionn17;
public class SpecialIndexOfArray {
    public static int findSpecialIndex(int[] A) {
        int n = A.length;

        // Calculate total sum of the array
        int totalSum = 0;
        for (int num : A) {
            totalSum += num;
        }

        int leftSum = 0;

        // Traverse the array to find the special index
        for (int i = 0; i < n; i++) {
            // Right sum is total sum minus left sum minus current element
            int rightSum = totalSum - leftSum - A[i];

            // Check if left sum equals right sum
            if (leftSum == rightSum) {
                return i; // Return the first special index found
            }

            // Update left sum for next iteration
            leftSum += A[i];
        }

        // If no special index is found, return -1
        return -1;
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
