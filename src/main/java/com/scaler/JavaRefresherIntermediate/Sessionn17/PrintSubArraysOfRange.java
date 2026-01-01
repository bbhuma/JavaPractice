package com.scaler.JavaRefresherIntermediate.Sessionn17;

public class PrintSubArraysOfRange {

    // Prints elements between start and end indexes (inclusive)
    public static void printSubarrayInRange(int[] arr, int start, int end) {
        if (start < 0 || end >= arr.length || start > end) {
            System.out.println("Invalid range");
            return;
        }

        System.out.print("Subarray between indexes " + start + " and " + end + ": ");
        for (int i = start; i <= end; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(); // new line after printing subarray
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        int start = 3; // index 3 → element 4
        int end = 5;   // index 5 → element 6

        printSubarrayInRange(arr, start, end);
    }
}
