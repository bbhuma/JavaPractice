package com.scaler.JavaRefresherIntermediate.Sessionn17;

import java.util.Arrays;

public class ClosestMinMaxSubArray {
    public int closestMinMaxSubArray(int[] A) {
        int n = A.length;
        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;

        // Find min and max values in the array
        for (int num : A) {
            if (num < minVal) {
                minVal = num;
            }
            if (num > maxVal) {
                maxVal = num;
            }
        }

        int lastMinIndex = -1;
        int lastMaxIndex = -1;
        int minLength = Integer.MAX_VALUE;

        // Traverse the array to find the closest min-max subarray
        for (int i = 0; i < n; i++) {
            if (A[i] == minVal) {
                lastMinIndex = i;
                if (lastMaxIndex != -1) {
                    minLength = Math.min(minLength, i - lastMaxIndex + 1);
                }
            }
            if (A[i] == maxVal) {
                lastMaxIndex = i;
                if (lastMinIndex != -1) {
                    minLength = Math.min(minLength, i - lastMinIndex + 1);
                }
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static void main(String[] args) {
        ClosestMinMaxSubArray obj = new ClosestMinMaxSubArray();
        int[] A = {1, 3, 2, 1, 4, 3, 4, 2};
        int result1 = obj.closestMinMaxSubArrayOptimized(A);
        int result2 = obj.closestMinMaxSubArray(A);
        System.out.println(result1); // Output: 2
        System.out.println(result2); 
    }
    public int closestMinMaxSubArrayOwn(int[] A) {
        //sorting a copy of the array to find min and max
        // int[] B = A.clone();
        // Arrays.sort(B);
        // int min = B[0];
        // int max = B[A.length - 1];
        int min = Arrays.stream(A).min().getAsInt();
        int max = Arrays.stream(A).max().getAsInt();
        /*
         * int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
            for (int num : A) {
                min = Math.min(min, num);
                max = Math.max(max, num);
            }
         */
        //int[] minArr= new int[A.length];
        //int[] maxArr= new int[A.length];
        int[] subarrayLengthsOfMinMax = new int[A.length];

        for(int i = 0; i < A.length; i++) {
            if (A[i] == min ) {
                for (int j = i + 1; j < A.length; j++) {
                    if (A[j] == max) {
                         subarrayLengthsOfMinMax[i]= j - i + 1;
                    }
                }
            }
            else if (A[i] == max ) {
                for (int j = i + 1; j < A.length; j++) {
                    if (A[j] == min) {
                         subarrayLengthsOfMinMax[i]= j - i + 1;
                    }
                }
            }
        }
        Arrays.sort(subarrayLengthsOfMinMax);

        return subarrayLengthsOfMinMax[0];
    }

    public int closestMinMaxSubArrayOptimized(int[] A) {
        int min = Arrays.stream(A).min().getAsInt();
        int max = Arrays.stream(A).max().getAsInt();

        // If all elements are the same
        if (min == max) return 1;

        int minIndex = -1, maxIndex = -1;
        int smallestLength = A.length; // initialize with large value

        for (int i = 0; i < A.length; i++) {
            if (A[i] == min) {
                minIndex = i;
                if (maxIndex != -1) {
                    smallestLength = Math.min(smallestLength, i - maxIndex + 1);
                }
            } else if (A[i] == max) {
                maxIndex = i;
                if (minIndex != -1) {
                    smallestLength = Math.min(smallestLength, i - minIndex + 1);
                }
            }
        }

    return smallestLength;
    }
    
}
