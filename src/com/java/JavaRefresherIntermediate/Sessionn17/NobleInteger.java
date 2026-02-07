package com.scaler.JavaRefresherIntermediate.Sessionn17;

import java.util.Arrays;

public class NobleInteger {
    public static int findNobleInteger(int[] A) {
        // Sort the array
        Arrays.sort(A);

        // Traverse the array to find the noble integer
        for (int i = 0; i < A.length; i++) {
            // Check if the current element is equal to the number of elements greater than it
            if (A[i] == A.length - 1 - i) {
                return A[i];
            }
        }

        // If no noble integer is found, return -1
        return -1;
    }
    public static int totalCountOfNobleIntegersInArray(int[] A) {
        // Sort the array
        Arrays.sort(A);

        int count = 0;
        // Traverse the array to find the noble integers
        for (int i = 0; i < A.length; i++) {
            // Check if the current element is equal to the number of elements greater than it
            if (A[i] == A.length - 1 - i) {
                count++;
            }
        }
        //return total count of noble integers
        return count;
    }

    public static void main(String[] args) {
        int[] A = {3, 2, 1, 3, 3};
        int[] B = {0,1,2,3,4,5,6};
        int nobleInteger = findNobleInteger(B);
        int totalNobleIntegersB = totalCountOfNobleIntegersInArray(B);
        if (nobleInteger != -1) {
            System.out.println("Noble Integer: " + nobleInteger + " Total Noble Integers: " + totalNobleIntegersB);
        } else {
            System.out.println("No Noble Integer found");
        }
        int totalNobleIntegers = totalCountOfNobleIntegersInArray(A);
        System.out.println("Total Noble Integers: " + totalNobleIntegers);
    }
}
