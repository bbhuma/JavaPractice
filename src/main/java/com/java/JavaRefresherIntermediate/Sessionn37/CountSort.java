package com.java.JavaRefresherIntermediate.Sessionn37;

public class CountSort {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 1, 1, 3, 4, 2};

        countSort(arr);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void countSort(int[] arr) {

        // Find the maximum element
        int max = arr[0];

        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }

        // Create the count array
        int[] count = new int[max + 1];

        // Count the frequency of each element
        for (int num : arr) {
            count[num]++;
        }

        // Rebuild the original array in sorted order
        int index = 0;

        for (int i = 0; i < count.length; i++) {

            while (count[i] > 0) {
                arr[index] = i;
                index++;
                count[i]--;
            }
        }
    }
}