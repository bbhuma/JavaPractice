package com.scaler.JavaRefresherIntermediate.Sessionn18;
public class SpecialIndexOfArrayUsingPrefixumArrays {
    public static int countSpecialIndices(int[] arr) {
        int n = arr.length;
        int[] prefixOdd = prefixOdd(arr);
        int[] prefixEven = prefixEven(arr);
        int specialCount = 0;

        for (int i = 0; i < n; i++) {
            int leftEven = (i > 0) ? prefixEven[i - 1] : 0;
            int leftOdd = (i > 0) ? prefixOdd[i - 1] : 0;
            int rightEven = prefixEven[n - 1] - prefixEven[i];
            int rightOdd = prefixOdd[n - 1] - prefixOdd[i];

            if (leftEven + rightOdd == leftOdd + rightEven) {
                specialCount++;
            }
        }

        return specialCount;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 6, 4};
        int result = countSpecialIndices(arr);
        int resultLR = countSpecialIndicesLeftRight(arr);
        System.out.println("Number of special indices: " + result);
        System.out.println("Number of special indices (Left-Right): " + resultLR);
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
    public static int countSpecialIndicesLeftRight(int[] arr) {
        int n = arr.length;
        int[] leftEvenSum = new int[n];
        int[] leftOddSum = new int[n];
        int[] rightEvenSum = new int[n];
        int[] rightOddSum = new int[n];

        // Calculate left prefix sums
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                leftEvenSum[i] = leftEvenSum[i - 1];
                leftOddSum[i] = leftOddSum[i - 1];
            }
            if (i % 2 == 0) {
                leftEvenSum[i] += arr[i];
            } else {
                leftOddSum[i] += arr[i];
            }
        }

        // Calculate right prefix sums
        for (int i = n - 1; i >= 0; i--) {
            if (i < n - 1) {
                rightEvenSum[i] = rightEvenSum[i + 1];
                rightOddSum[i] = rightOddSum[i + 1];
            }
            if (i % 2 == 0) {
                rightEvenSum[i] += arr[i];
            } else {
                rightOddSum[i] += arr[i];
            }
        }

        int specialCount = 0;

        // Check each index
        for (int i = 0; i < n; i++) {
            int totalEvenSum = 0;
            int totalOddSum = 0;

            // Left side sums
            if (i > 0) {
                totalEvenSum += leftEvenSum[i - 1];
                totalOddSum += leftOddSum[i - 1];
            }

            // Right side sums
            if (i < n - 1) {
                if (i % 2 == 0) {
                    totalEvenSum += rightOddSum[i + 1];
                    totalOddSum += rightEvenSum[i + 1];
                } else {
                    totalEvenSum += rightEvenSum[i + 1];
                    totalOddSum += rightOddSum[i + 1];
                }
            }

            if (totalEvenSum == totalOddSum) {
                specialCount++;
            }
        }

        return specialCount;
    }
}
