package com.java.JavaRefresherIntermediate.Sessionn31.LabSession;

import java.util.*;

public class SubarrayBitwiseOR {
	 // ============================================================
    // MAIN METHOD FOR TESTING
    // ============================================================
    public static void main(String[] args) {

        int[] arr = {1, 2, 4, 1, 2, 4, 1, 2, 4, 1, 2, 4};

        System.out.println("Brute Force: " + bruteForce(arr));
        System.out.println("Semi Optimized: " + semiOptimized(arr));
        System.out.println("Bit Contribution Optimized: " + optimizedBitContribution(arr));
        System.out.println("DP HashSet Method,show disctinct OR subarrays: " + dpHashSetMethod(arr));
    }

    static final long MOD = 1_000_000_007;

    // ============================================================
    // 1️⃣ BRUTE FORCE - O(N^3)
    // ============================================================
    public static long bruteForce(int[] arr) {
        int n = arr.length;
        long sum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {

                int currentOR = 0;

                for (int k = i; k <= j; k++) {
                    currentOR |= arr[k];
                }

                sum = (sum + currentOR) % MOD;
            }
        }

        return sum;
    }

    // ============================================================
    // 2️⃣ SEMI OPTIMIZED - O(N^2)
    // Reuse OR instead of recalculating
    // ============================================================
    public static long semiOptimized(int[] arr) {
        int n = arr.length;
        long sum = 0;

        for (int i = 0; i < n; i++) {
            int currentOR = 0;

            for (int j = i; j < n; j++) {
                currentOR |= arr[j];
                sum = (sum + currentOR) % MOD;
            }
        }

        return sum;
    }

    // ============================================================
    // 3️⃣ FULLY OPTIMIZED - BIT CONTRIBUTION METHOD - O(32*N)
    // ============================================================
    public static long optimizedBitContribution(int[] arr) {
        int n = arr.length;
        long totalSubarrays = (long) n * (n + 1) / 2;
        long answer = 0;

        for (int bit = 0; bit < 32; bit++) {

            long zeroStreak = 0;
            long zeroSubarrays = 0;

            for (int i = 0; i < n; i++) {

                if ((arr[i] & (1 << bit)) == 0) {
                    zeroStreak++;
                } else {
                    zeroSubarrays += (zeroStreak * (zeroStreak + 1)) / 2;
                    zeroStreak = 0;
                }
            }

            // Add remaining zero streak
            zeroSubarrays += (zeroStreak * (zeroStreak + 1)) / 2;

            long bitSetSubarrays = totalSubarrays - zeroSubarrays;

            long contribution = (bitSetSubarrays % MOD) * ((1L << bit) % MOD) % MOD;

            answer = (answer + contribution) % MOD;
        }

        return answer;
    }

    // ============================================================
    // 4️⃣ HASHSET / DP APPROACH (Distinct OR propagation)
    // Time: ~O(N * log(max))
    // ============================================================
    public static long dpHashSetMethod(int[] arr) {
        long result = 0;

        Set<Integer> prev = new HashSet<>();

        for (int num : arr) {

            Set<Integer> current = new HashSet<>();
            current.add(num);

            for (int val : prev) {
                current.add(val | num);
            }

            prev = current;

            for (int val : current) {
                result = (result + val) % MOD;
            }
        }

        return result;
    }

   
}
