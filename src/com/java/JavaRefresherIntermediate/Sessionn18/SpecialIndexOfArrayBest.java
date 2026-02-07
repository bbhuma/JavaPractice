package com.scaler.JavaRefresherIntermediate.Sessionn18;
public class SpecialIndexOfArrayBest {
    public static int countSpecialIndices(int[] arr) {
        int n = arr.length;
        int leftSum = 0;
        int rightSum = 0;
        for (int i = 0; i < n; i++) {
            // Implementation logic here
            int[] pfEven= prefixEven(arr);
            int[] pfOdd= prefixOdd(arr);
            if (i % 2 == 0) {
                // Even index
                leftSum = pfEven[i];
                rightSum = pfOdd[n - 1] - pfOdd[i];
            } else {
                // Odd index
                leftSum = pfOdd[i];
                rightSum = pfEven[n - 1] - pfEven[i];
            }
            if(leftSum==rightSum){
                return i;
            }
        }
        return -1;
    }
    private static int[] prefixEven(int[] arr) {
        int n = arr.length;
        int[] prefixEven = new int[n];
        prefixEven[0] = (0 % 2 == 0) ? arr[0] : 0;

        for (int i = 1; i < n; i++) {
            prefixEven[i] = prefixEven[i - 1];
            if (i % 2 == 0) {
                prefixEven[i] += arr[i];
            }
        }

        return prefixEven;
    }
    private static int[] prefixOdd(int[] arr) {
        int n = arr.length;
        int[] prefixOdd = new int[n];
        prefixOdd[0] = (0 % 2 != 0) ? arr[0] : 0;

        for (int i = 1; i < n; i++) {
            prefixOdd[i] = prefixOdd[i - 1];
            if (i % 2 != 0) {
                prefixOdd[i] += arr[i];
            }
        }

        return prefixOdd;
    }
     public static void main(String[] args) {
        int[] arr = {2, 1, 6, 3};
        int result = countSpecialIndices(arr);
        if (result != -1) {
            System.out.println("Special index: " + result);
        } else {
            System.out.println("No special index found.");
        }
    }

}
