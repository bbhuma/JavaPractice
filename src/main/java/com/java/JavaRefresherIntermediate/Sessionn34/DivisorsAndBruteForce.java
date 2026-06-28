package com.java.JavaRefresherIntermediate.Sessionn34;

import java.util.*;

public class DivisorsAndBruteForce {

    public static void main(String[] args) {

        int a = -36;
        int b = 60;

        System.out.println("Number A: " + a);
        printDivisorsAndPrime(a);

        System.out.println("\nNumber B: " + b);
        printDivisorsAndPrime(b);

        System.out.println("\nCommon Divisors of A and B: " + getCommonDivisors(a, b));

        System.out.println("\nBrute Force GCD: " + gcdBrute(a, b));
        System.out.println("Brute Force LCM: " + lcmBrute(a, b));

        int[] arr = {12, 15, 18, 30};
        System.out.println("\nArray: " + Arrays.toString(arr));
        System.out.println("Max GCD from any pair (Brute): " + maxGCDBrute(arr));
        
        System.out.println("\nGCD of Entire Array: " + gcdEntireArray(arr));
        System.out.println("\nLCM of Entire Array: " + lcmEntireArray(arr));
    }

    // =====================================
    // Print Divisors and Check Prime
    // =====================================
    public static void printDivisorsAndPrime(int n) {

        List<Integer> divisors = getDivisors(n);
        System.out.println("Divisors: " + divisors);

        if (isPrime(n))
            System.out.println("Is Prime? YES");
        else
            System.out.println("Is Prime? NO");
    }

    // =====================================
    // Get Divisors of a Number
    // =====================================
    public static List<Integer> getDivisors(int n) {

        List<Integer> divisors = new ArrayList<>();
        n = Math.abs(n);

        if (n == 0) {
            divisors.add(0);
            return divisors;
        }

        for (int i = 1; i <= n; i++) {
            if (n % i == 0)
                divisors.add(i);
        }

        return divisors;
    }

    // =====================================
    // Check Prime (Brute)
    // =====================================
    public static boolean isPrime(int n) {

        n = Math.abs(n);

        if (n <= 1)
            return false;

        for (int i = 2; i < n; i++) {
            if (n % i == 0)
                return false;
        }

        return true;
    }

    // =====================================
    // Get Common Divisors
    // =====================================
    public static List<Integer> getCommonDivisors(int a, int b) {

        a = Math.abs(a);
        b = Math.abs(b);

        List<Integer> common = new ArrayList<>();

        if (a == 0 && b == 0) {
            common.add(-1);
            return common;
        }

        int min = Math.min(a, b);

        for (int i = 1; i <= min; i++) {
            if (a % i == 0 && b % i == 0)
                common.add(i);
        }

        return common;
    }

    // =====================================
    // GCD - Brute Force
    // =====================================
    public static int gcdBrute(int a, int b) {

        a = Math.abs(a);
        b = Math.abs(b);

        if (a == 0 && b == 0)
            return -1;

        if (a == 0)
            return b;

        if (b == 0)
            return a;

        int min = Math.min(a, b);
        int gcd = 1;

        for (int i = 1; i <= min; i++) {
            if (a % i == 0 && b % i == 0)
                gcd = i;
        }

        return gcd;
    }

    // =====================================
    // LCM - Brute Force
    // =====================================
    public static int lcmBrute(int a, int b) {

        a = Math.abs(a);
        b = Math.abs(b);

        if (a == 0 || b == 0)
            return 0;

        int max = Math.max(a, b);
        int lcm = max;

        while (true) {
            if (lcm % a == 0 && lcm % b == 0)
                return lcm;
            lcm++;
        }
    }

    // =====================================
    // Max GCD from All Pairs (Brute)
    // =====================================
    public static int maxGCDBrute(int[] arr) {

        if (arr == null || arr.length < 2)
            return -1;

        int maxGCD = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int gcd = gcdBrute(arr[i], arr[j]);
                maxGCD = Math.max(maxGCD, gcd);
            }
        }

        return maxGCD;
    }
 // =====================================
 // GCD of Entire Array
 // =====================================
 public static int gcdEntireArray(int[] arr) {

     if (arr == null || arr.length == 0)
         return -1;

     int result = arr[0];

     for (int i = 1; i < arr.length; i++) {
         result = gcdBrute(result, arr[i]);
         if (result == 1)
             return 1; // early stop
     }

     return result;
 }


 // =====================================
 // LCM of Entire Array
 // =====================================
 public static int lcmEntireArray(int[] arr) {

     if (arr == null || arr.length == 0)
         return -1;

     int result = arr[0];

     for (int i = 1; i < arr.length; i++) {
         result = lcmBrute(result, arr[i]);
         if (result == 0)
             return 0;
     }

     return result;
 }
}