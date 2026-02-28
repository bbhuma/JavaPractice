package com.java.JavaRefresherIntermediate.Sessionn34;

public class ModularArithmeticRevision {
			/*
			(a + b) % m = ((a % m) + (b % m)) % m
			(a - b) % m = ((a % m) - (b % m) + m) % m
			(a * b) % m = ((a % m) * (b % m)) % m
			(a / b) % m = a * inv(b) % m // where inv(b) is the modular inverse of b modulo m, usually asked
			(a^b) % m = (a % m)^b % m // large exponentiation can be done using fast exponentiation (binary exponentiation) to avoid overflow and reduce time complexity
			*/

    static final long MOD = 1_000_000_007; // Common prime modulus, fits in int, avoids overflow, and is widely used in competitive programming

    public static void main(String[] args) {

        long a = -25;
        long b = 7;

        System.out.println("Basic Modulo:");
        basicModulo(a, b);

        System.out.println("\nModular Addition:");
        System.out.println(modAdd(a, b, MOD));

        System.out.println("\nModular Subtraction:");
        System.out.println(modSub(a, b, MOD));

        System.out.println("\nModular Multiplication:");
        System.out.println(modMul(a, b, MOD));

        System.out.println("\nFast Modular Exponentiation:");
        System.out.println(modPow(5, 13, MOD));

        System.out.println("\nModular Inverse (Fermat):");
        System.out.println(modInverseFermat(5, MOD));

        System.out.println("\nModular Division:");
        System.out.println(modDivide(10, 5, MOD));

        System.out.println("\nFactorial Mod:");
        System.out.println(factorialMod(5, MOD));

        System.out.println("\nnCr Mod:");
        System.out.println(nCrMod(5, 2, MOD));

        System.out.println("\nGCD & LCM:");
        System.out.println("GCD: " + gcd(48, 18));
        System.out.println("LCM: " + lcm(48, 18));
    }

    // =========================
    // BASIC MODULO
    // =========================
    public static void basicModulo(long a, long b) {
        System.out.println("a % b = " + (a % b));
        System.out.println("Corrected positive mod = " + ((a % b + b) % b));
    }

    // =========================
    // MODULAR ADDITION
    // =========================
    public static long modAdd(long a, long b, long mod) {
        return ((a % mod + b % mod) % mod + mod) % mod;
    }

    // =========================
    // MODULAR SUBTRACTION
    // =========================
    public static long modSub(long a, long b, long mod) {
        return ((a % mod - b % mod) % mod + mod) % mod;
    }

    // =========================
    // MODULAR MULTIPLICATION
    // =========================
    public static long modMul(long a, long b, long mod) {
        return ((a % mod) * (b % mod)) % mod;
    }

    // =========================
    // FAST POWER (Binary Exponentiation)
    // =========================
    public static long modPow(long base, long exp, long mod) {

        base = (base % mod + mod) % mod;
        long result = 1;

        while (exp > 0) {
            if ((exp & 1) == 1)
                result = modMul(result, base, mod);

            base = modMul(base, base, mod);
            exp >>= 1;
        }

        return result;
    }

    // =========================
    // MODULAR INVERSE (Fermat's Theorem)
    // Only works if mod is prime
    // =========================
    public static long modInverseFermat(long a, long mod) {
        return modPow(a, mod - 2, mod);
    }

    // =========================
    // MODULAR DIVISION
    // (a / b) % mod = a * inv(b) % mod
    // =========================
    public static long modDivide(long a, long b, long mod) {
        return modMul(a, modInverseFermat(b, mod), mod);
    }

    // =========================
    // FACTORIAL MOD
    // =========================
    public static long factorialMod(int n, long mod) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result = modMul(result, i, mod);
        }
        return result;
    }

    // =========================
    // nCr % mod
    // =========================
    public static long nCrMod(int n, int r, long mod) {

        if (r > n) return 0;

        long numerator = factorialMod(n, mod);
        long denominator = modMul(factorialMod(r, mod),
                                  factorialMod(n - r, mod), mod);

        return modDivide(numerator, denominator, mod);
    }

    // =========================
    // GCD
    // =========================
    public static long gcd(long a, long b) {
        a = Math.abs(a);
        b = Math.abs(b);

        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // =========================
    // LCM
    // =========================
    public static long lcm(long a, long b) {
        if (a == 0 || b == 0) return 0;
        return Math.abs(a / gcd(a, b) * b);
    }
}