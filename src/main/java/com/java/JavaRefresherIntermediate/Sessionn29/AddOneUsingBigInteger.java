package com.java.JavaRefresherIntermediate.Sessionn29;

import java.math.BigInteger;

public class AddOneUsingBigInteger {

    public static void main(String[] args) {

        int[] arr1 = {1, 2, 9};
        int[] arr2 = {9, 9, 9};
        int[] arr3 = {0, 0, 0};
        int[] arr4 = {0,0,0,0,0,9,9,9,1,2,9,9,9,9,9,9,9,9,9,9};

        print(addOne(arr1));
        print(addOne(arr2));
        print(addOne(arr3));
        print(addOne(arr4));
    }

    public static int[] addOne(int[] arr) {

        // 1️⃣ Convert array → String
        StringBuilder sb = new StringBuilder();
        for (int digit : arr) {
            sb.append(digit);
        }

        // 2️⃣ Convert String → BigInteger
        BigInteger number = new BigInteger(sb.toString());

        // 3️⃣ Add 1
        number = number.add(BigInteger.ONE);

        // 4️⃣ Convert back to String
        String resultString = number.toString();

        // 5️⃣ Convert String → int[]
        int[] result = new int[resultString.length()];
        for (int i = 0; i < resultString.length(); i++) {
            result[i] = resultString.charAt(i) - '0';
        }

        return result;
    }

    public static void print(int[] arr) {
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}
