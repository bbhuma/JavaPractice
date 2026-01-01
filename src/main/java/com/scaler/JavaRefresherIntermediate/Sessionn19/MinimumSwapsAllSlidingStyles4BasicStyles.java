
package com.scaler.JavaRefresherIntermediate.Sessionn19;

public class MinimumSwapsAllSlidingStyles4BasicStyles {

    /**
     * Variation 1 — Pure for-loop style with two variables (compact & clean)
     */
    public static int minSwaps_forLoopDualPointers(int[] array, int threshold) {
        int n = array.length;
        int windowSize = 0;

        // Count all "good" elements (≤ threshold)
        for (int val : array)
            if (val <= threshold)
                windowSize++;

        if (windowSize <= 1) return 0;

        // Count "bad" elements (> threshold) in first window
        int badCount = 0;
        for (int i = 0; i < windowSize; i++)
            if (array[i] > threshold)
                badCount++;

        int minSwaps = badCount; //starting point

        // Sliding using dual pointers in for
        for (int left = 0, right = windowSize; right < n; left++, right++) {
            if (array[left] > threshold) badCount--;
            if (array[right] > threshold) badCount++;
            minSwaps = Math.min(minSwaps, badCount);
        }
        return minSwaps;
    }

    /**
     * Variation 2 — While-loop style with explicit left/right
     * (Most readable for beginners)
     */
    public static int minSwaps_whileLoopClassic(int[] array, int threshold) {
        int n = array.length;
        int windowSize = 0;

        for (int val : array)
            if (val <= threshold)
                windowSize++;

        if (windowSize <= 1) return 0;

        int badCount = 0;
        for (int i = 0; i < windowSize; i++)
            if (array[i] > threshold)
                badCount++;

        int minSwaps = badCount;
        int left = 0;
        int right = windowSize - 1;

        // Sliding while right still has room to move
        while (right < n - 1) {
            left++;
            right++;
            if (array[left - 1] > threshold) badCount--;
            if (array[right] > threshold) badCount++;
            minSwaps = Math.min(minSwaps, badCount);
        }
        return minSwaps;
    }

    /**
     * Variation 3 — for-loop with internal manual update
     * (while-like control inside for)
     */
    public static int minSwaps_forLoopManualUpdate(int[] array, int threshold) {
        int n = array.length;
        int windowSize = 0;
        for (int val : array)
            if (val <= threshold)
                windowSize++;

        if (windowSize <= 1) return 0;

        int badCount = 0;
        for (int i = 0; i < windowSize; i++)
            if (array[i] > threshold)
                badCount++;

        int minSwaps = badCount;
        int left = 0, right = windowSize - 1;

        // for loop with no start/update part → acts like while
        for (; right < n - 1; ) {
            left++;
            right++;
            if (array[left - 1] > threshold) badCount--;
            if (array[right] > threshold) badCount++;
            minSwaps = Math.min(minSwaps, badCount);
        }
        return minSwaps;
    }

    /**
     * Variation 4 — Nested for-loops for first + sliding phases
     * (explicit separation of initialization and movement)
     */
    public static int minSwaps_nestedForStyle(int[] array, int threshold) {
        int n = array.length;
        int windowSize = 0;
        for (int val : array)
            if (val <= threshold)
                windowSize++;

        if (windowSize <= 1) return 0;

        int badCount = 0;
        for (int i = 0; i < windowSize; i++)
            if (array[i] > threshold)
                badCount++;

        int minSwaps = badCount;

        // Explicit sliding in a separate for loop
        for (int left = 1; left <= n - windowSize; left++) {
            int right = left + windowSize - 1;

            if (array[left - 1] > threshold) badCount--;
            if (array[right] > threshold) badCount++;

            minSwaps = Math.min(minSwaps, badCount);
        }
        return minSwaps;
    }

    // MAIN — run all variations
    public static void main(String[] args) {
        int[] array = {1, 12, 10, 3, 14, 10, 5};
        int threshold = 8;

        System.out.println("Variation 1 (for-loop dual pointers): " + minSwaps_forLoopDualPointers(array, threshold));
        System.out.println("Variation 2 (while-loop classic): " + minSwaps_whileLoopClassic(array, threshold));
        System.out.println("Variation 3 (for-loop manual update): " + minSwaps_forLoopManualUpdate(array, threshold));
        System.out.println("Variation 4 (nested for-loops): " + minSwaps_nestedForStyle(array, threshold));
    }
}

