package com.java.JavaRefresherIntermediate.Sessionn34;

import java.util.Arrays;

public class GCDLCMArray {

    public static void main(String[] args) {

        int[] arr = {48, 18, 30, -24};

        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("----------------------------------");

        System.out.println("GCD (Iterative): " + gcdArrayIterative(arr));
        System.out.println("GCD (Recursive): " + gcdArrayRecursive(arr, arr.length));

        System.out.println("----------------------------------");

        System.out.println("LCM (Iterative): " + lcmArrayIterative(arr));
        System.out.println("LCM (Recursive): " + lcmArrayRecursive(arr, arr.length));
    }

    // =========================
    // BASIC GCD (Euclidean)
    // =========================
    public static int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // =========================
    // BASIC LCM
    // =========================
    public static int lcm(int a, int b) {
        if (a == 0 || b == 0)
            return 0;
        return Math.abs(a / gcd(a, b) * b);
    }

    // =========================
    // GCD OF ARRAY - ITERATIVE
    // =========================
    public static int gcdArrayIterative(int[] arr) {
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result = gcd(result, arr[i]);
        }
        return result;
    }

    // =========================
    // GCD OF ARRAY - RECURSIVE
    // =========================
    public static int gcdArrayRecursive(int[] arr, int n) {
        if (n == 1)
            return Math.abs(arr[0]);

        return gcd(arr[n - 1], gcdArrayRecursive(arr, n - 1));
    }

    // =========================
    // LCM OF ARRAY - ITERATIVE
    // =========================
    public static int lcmArrayIterative(int[] arr) {
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result = lcm(result, arr[i]);
        }
        return result;
    }

    // =========================
    // LCM OF ARRAY - RECURSIVE
    // =========================
    public static int lcmArrayRecursive(int[] arr, int n) {
        if (n == 1)
            return Math.abs(arr[0]);

        return lcm(arr[n - 1], lcmArrayRecursive(arr, n - 1));
    }
}