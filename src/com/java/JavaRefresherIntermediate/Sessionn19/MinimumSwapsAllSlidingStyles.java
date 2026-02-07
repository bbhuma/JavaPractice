package com.java.JavaRefresherIntermediate.Sessionn19;

public class MinimumSwapsAllSlidingStyles {

    // ---------------------------------------------------------------
    // Variation 1 — for-loop dual pointers (compact)
    // ---------------------------------------------------------------
    public static int minSwaps_forLoopDualPointers(int[] arr, int threshold) {
        int n = arr.length;
        int window = countGood(arr, threshold);
        if (window <= 1) return 0;

        int bad = countBad(arr, 0, window - 1, threshold);
        int minSwaps = bad;

        for (int left = 0, right = window; right < n; left++, right++) {
            if (arr[left] > threshold) bad--;
            if (arr[right] > threshold) bad++;
            minSwaps = Math.min(minSwaps, bad);
        }
        return minSwaps;
    }

    // ---------------------------------------------------------------
    // Variation 2 — classic while-loop (cleanest for beginners)
    // ---------------------------------------------------------------
    public static int minSwaps_whileClassic(int[] arr, int threshold) {
        int n = arr.length;
        int window = countGood(arr, threshold);
        if (window <= 1) return 0;

        int bad = countBad(arr, 0, window - 1, threshold);
        int minSwaps = bad;

        int left = 0, right = window - 1;
        while (right < n - 1) {
            left++;
            right++;
            if (arr[left - 1] > threshold) bad--;
            if (arr[right] > threshold) bad++;
            minSwaps = Math.min(minSwaps, bad);
        }
        return minSwaps;
    }

    // ---------------------------------------------------------------
    // Variation 3 — for-loop manual update (acts like while)
    // ---------------------------------------------------------------
    public static int minSwaps_forManualUpdate(int[] arr, int threshold) {
        int n = arr.length;
        int window = countGood(arr, threshold);
        if (window <= 1) return 0;

        int bad = countBad(arr, 0, window - 1, threshold);
        int minSwaps = bad;

        int left = 0, right = window - 1;
        for (; right < n - 1; ) {
            left++;
            right++;
            if (arr[left - 1] > threshold) bad--;
            if (arr[right] > threshold) bad++;
            minSwaps = Math.min(minSwaps, bad);
        }
        return minSwaps;
    }

    // ---------------------------------------------------------------
    // Variation 4 — nested for-loops (explicit phase separation)
    // ---------------------------------------------------------------
    public static int minSwaps_nestedFor(int[] arr, int threshold) {
        int n = arr.length;
        int window = countGood(arr, threshold);
        if (window <= 1) return 0;

        int bad = countBad(arr, 0, window - 1, threshold);
        int minSwaps = bad;

        for (int left = 1; left <= n - window; left++) {
            int right = left + window - 1;
            if (arr[left - 1] > threshold) bad--;
            if (arr[right] > threshold) bad++;
            minSwaps = Math.min(minSwaps, bad);
        }
        return minSwaps;
    }

    // ---------------------------------------------------------------
    // Variation 5 — for-loop outer + while inner
    // (useful when sub-sliding needed inside main sliding)
    // ---------------------------------------------------------------
    public static int minSwaps_forOuterWhileInner(int[] arr, int threshold) {
        int n = arr.length;
        int window = countGood(arr, threshold);
        if (window <= 1) return 0;

        int minSwaps = Integer.MAX_VALUE;

        for (int start = 0; start + window <= n; start++) {
            int end = start + window - 1;
            int bad = 0;

            int i = start;
            while (i <= end) {
                if (arr[i] > threshold) bad++;
                i++;
            }
            minSwaps = Math.min(minSwaps, bad);
        }
        return minSwaps;
    }

    // ---------------------------------------------------------------
    // Variation 6 — while-loop outer + for-loop inner
    // (compute once, slide manually)
    // ---------------------------------------------------------------
    public static int minSwaps_whileOuterForInner(int[] arr, int threshold) {
        int n = arr.length;
        int window = countGood(arr, threshold);
        if (window <= 1) return 0;

        int left = 0, right = window - 1;
        int minSwaps = Integer.MAX_VALUE;

        while (right < n) {
            int bad = 0;
            for (int i = left; i <= right; i++) {
                if (arr[i] > threshold) bad++;
            }
            minSwaps = Math.min(minSwaps, bad);
            left++;
            right++;
        }
        return minSwaps;
    }

    // ---------------------------------------------------------------
    // Variation 7 — for-loop with dynamic reset (rare, advanced)
    // (forces a restart of window dynamically)
    // ---------------------------------------------------------------
    public static int minSwaps_forLoopReset(int[] arr, int threshold) {
        int n = arr.length;
        int window = countGood(arr, threshold);
        if (window <= 1) return 0;

        int bad = countBad(arr, 0, window - 1, threshold);
        int minSwaps = bad;
        int left = 0, right = window - 1;

        for (int iter = 0; iter < n * 2; iter++) { // artificial bound
            if (right >= n - 1) break;

            if (arr[left] > threshold) bad--;
            left++;
            right++;
            if (arr[right] > threshold) bad++;

            minSwaps = Math.min(minSwaps, bad);

            // Reset logic — demonstrate dynamic window restart
            if (iter % window == 0) {
                left = iter / window;
                right = left + window - 1;
            }
        }
        return minSwaps;
    }

    // ---------------------------------------------------------------
    // Helper Methods
    // ---------------------------------------------------------------
    private static int countGood(int[] arr, int threshold) {
        int cnt = 0;
        for (int x : arr) if (x <= threshold) cnt++;
        return cnt;
    }

    private static int countBad(int[] arr, int l, int r, int threshold) {
        int cnt = 0;
        for (int i = l; i <= r; i++) if (arr[i] > threshold) cnt++;
        return cnt;
    }

    // ---------------------------------------------------------------
    // MAIN — call all variations
    // ---------------------------------------------------------------
    public static void main(String[] args) {
        int[] arr = {1, 12, 10, 3, 14, 10, 5};
        int threshold = 8;

        System.out.println("1️⃣ for-loop dual pointers:       " + minSwaps_forLoopDualPointers(arr, threshold));
        System.out.println("2️⃣ while-loop classic:           " + minSwaps_whileClassic(arr, threshold));
        System.out.println("3️⃣ for manual update:            " + minSwaps_forManualUpdate(arr, threshold));
        System.out.println("4️⃣ nested for-loops:             " + minSwaps_nestedFor(arr, threshold));
        System.out.println("5️⃣ for outer + while inner:      " + minSwaps_forOuterWhileInner(arr, threshold));
        System.out.println("6️⃣ while outer + for inner:      " + minSwaps_whileOuterForInner(arr, threshold));
        System.out.println("7️⃣ for-loop with reset:          " + minSwaps_forLoopReset(arr, threshold));
    }
}
