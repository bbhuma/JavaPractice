package com.scaler.JavaRefresherIntermediate.Sessionn17;

public class SpecialIndexOptimized {
    public int specialIndexOptimized(int[] A) {
        int n = A.length;
        int[] prefixEven = new int[n];
        int[] prefixOdd = new int[n];
        
        // Build prefix sums
        prefixEven[0] = A[0];
        for (int i = 1; i < n; i++) {
            prefixEven[i] = prefixEven[i - 1];
            prefixOdd[i] = prefixOdd[i - 1];
            if (i % 2 == 0) prefixEven[i] += A[i];
            else prefixOdd[i] += A[i];
        }
        
        int count = 0;
        for (int i = 0; i < n; i++) {
            int evenSum, oddSum;
            
            // Left part sums
            if (i == 0) {
                evenSum = prefixOdd[n - 1] - prefixOdd[i];
                oddSum = prefixEven[n - 1] - prefixEven[i];
            } else {
                evenSum = prefixEven[i - 1] + (prefixOdd[n - 1] - prefixOdd[i]);
                oddSum = prefixOdd[i - 1] + (prefixEven[n - 1] - prefixEven[i]);
            }
            
            if (evenSum == oddSum)
                count++;
        }
        
        return count;
    }
    public int moreOptimized(int[] A) {
        int n = A.length;
        int totalEven = 0, totalOdd = 0;
        
        // Step 1: Compute total even and odd sums
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) totalEven += A[i];
            else totalOdd += A[i];
        }
        
        int leftEven = 0, leftOdd = 0;
        int count = 0;
        
        // Step 2: Traverse and check for each index
        for (int i = 0; i < n; i++) {
            // Remove current element from totals
            if (i % 2 == 0) totalEven -= A[i];
            else totalOdd -= A[i];
            
            // Compare leftEven + rightOdd == leftOdd + rightEven
            if (leftEven + totalOdd == leftOdd + totalEven)
                count++;
            
            // Add current element to left sums
            if (i % 2 == 0) leftEven += A[i];
            else leftOdd += A[i];
        }
        
        return count;
    }
    public static void main(String[] args) {
        SpecialIndexOptimized obj = new SpecialIndexOptimized();
        int[] A = {2, 1, 6, 4};
        int result = obj.specialIndexOptimized(A);
        int result2 = obj.moreOptimized(A);
        System.out.println(result); 
    }
}

