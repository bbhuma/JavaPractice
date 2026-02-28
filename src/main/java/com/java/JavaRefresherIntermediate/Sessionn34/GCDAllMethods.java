package com.java.JavaRefresherIntermediate.Sessionn34;

import java.math.BigInteger;
import java.util.Arrays;

public class GCDAllMethods {

    public static void main(String[] args) {

        int a = -148;
        int b = 18;

        System.out.println("Numbers: " + a + " , " + b);
        System.out.println("-----------------------------------");

        System.out.println("1. Brute Force GCD: " + gcdBrute(a, b));
        System.out.println("2. Reverse Loop GCD: " + gcdReverse(a, b));
        System.out.println("3. Euclidean Iterative GCD: " + gcdIterative(a, b));
        System.out.println("4. Euclidean Recursive GCD: " + gcdRecursive(a, b));
        System.out.println("5. Subtraction Method GCD: " + gcdSubtraction(a, b));
        System.out.println("6. Binary GCD (Stein's): " + gcdBinary(a, b));
        System.out.println("7. BigInteger GCD: " + gcdBig(a, b));

        int[] arr = {48, -18, 30, 0};
        System.out.println("\nArray: " + Arrays.toString(arr));
        System.out.println("8. GCD of Array: " + gcdArray(arr));

        System.out.println("\nLCM using GCD relation:");
        System.out.println("LCM(" + a + "," + b + ") = " + lcm(a, b));
        System.out.println("LCM of Array = " + lcmArray(arr));
    }

    // =========================
    // COMMON NORMALIZATION
    // =========================
    private static long normalize(long x) {
        if (x == Long.MIN_VALUE) return Math.abs((long) Integer.MIN_VALUE);
        return Math.abs(x);
    }

    // =========================
    // 1️⃣ Brute Force
    // =========================
    public static int gcdBrute(int a, int b) {
        a = (int) normalize(a);
        b = (int) normalize(b);

        if (a == 0 && b == 0) return -1;
        if (a == 0) return b;
        if (b == 0) return a;

        int min = Math.min(a, b);
        int gcd = 1;

        for (int i = 1; i <= min; i++) {
            if (a % i == 0 && b % i == 0)
                gcd = i;
        }
        return gcd;
    }

    // =========================
    // 2️⃣ Reverse Loop
    // =========================
    public static int gcdReverse(int a, int b) {
        a = (int) normalize(a);
        b = (int) normalize(b);

        if (a == 0 && b == 0) return -1;
        if (a == 0) return b;
        if (b == 0) return a;

        int min = Math.min(a, b);
        for (int i = min; i >= 1; i--) {
            if (a % i == 0 && b % i == 0)
                return i;
        }
        return 1;
    }

    // =========================
    // 3️⃣ Euclidean Iterative (Best)
    // =========================
    public static int gcdIterative(int a, int b) {
        a = (int) normalize(a);
        b = (int) normalize(b);

        if (a == 0 && b == 0) return -1;
        if (a == 0) return b;
        if (b == 0) return a;

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // =========================
    // 4️⃣ Euclidean Recursive
    // =========================
    public static int gcdRecursive(int a, int b) {
        a = (int) normalize(a);
        b = (int) normalize(b);

        if (a == 0 && b == 0) return -1;
        if (b == 0) return a;

        return gcdRecursive(b, a % b);
    }

    // =========================
    // 5️⃣ Subtraction Method
    // =========================
    public static int gcdSubtraction(int a, int b) {
        a = (int) normalize(a);
        b = (int) normalize(b);

        if (a == 0 && b == 0) return -1;
        if (a == 0) return b;
        if (b == 0) return a;

        while (a != b) {
            if (a > b)
                a -= b;
            else
                b -= a;
        }
        return a;
    }

    // =========================
    // 6️⃣ Binary GCD (Stein's)
    // =========================
    public static int gcdBinary(int a, int b) {
        a = (int) normalize(a);
        b = (int) normalize(b);

        if (a == 0 && b == 0) return -1;
        if (a == 0) return b;
        if (b == 0) return a;

        int shift = Integer.numberOfTrailingZeros(a | b);
        a >>= Integer.numberOfTrailingZeros(a);

        while (b != 0) {
            b >>= Integer.numberOfTrailingZeros(b);
            if (a > b) {
                int temp = a;
                a = b;
                b = temp;
            }
            b -= a;
        }
        return a << shift;
    }

    // =========================
    // 7️⃣ BigInteger
    // =========================
    public static int gcdBig(int a, int b) {
        if (a == 0 && b == 0) return -1;
        BigInteger x = BigInteger.valueOf(a);
        BigInteger y = BigInteger.valueOf(b);
        return x.gcd(y).intValue();
    }

    // =========================
    // 8️⃣ GCD of Array
    // =========================
    public static int gcdArray(int[] arr) {
        if (arr == null || arr.length == 0) return -1;

        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result = gcdIterative(result, arr[i]);
            if (result == 1) return 1; // early stop
        }
        return result;
    }

    // =========================
    // LCM (safe)
    // =========================
    public static int lcm(int a, int b) {
        if (a == 0 || b == 0) return 0;

        int gcd = gcdIterative(a, b);
        if (gcd == -1) return -1;

        long result = (long) a / gcd * b;
        return (int) Math.abs(result);
    }

    // =========================
    // LCM of Array
    // =========================
    public static int lcmArray(int[] arr) {
        if (arr == null || arr.length == 0) return -1;

        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result = lcm(result, arr[i]);
            if (result == 0) return 0;
        }
        return result;
    }
}