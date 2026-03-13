package com.java.JavaRefresherIntermediate.Sessionn37;

import java.util.*;

public class MergeSortedArraysPatterns {

    /*
    =====================================================
    1️⃣ Two Pointer Merge (Most Optimal)
    Time  : O(n + m)
    Space : O(n + m)
    =====================================================
    */
    public static int[] mergeTwoPointer(int[] a, int[] b) {

        int n = a.length;
        int m = b.length;

        int[] result = new int[n + m];

        int i = 0, j = 0, k = 0;

        while (i < n && j < m) {

            if (a[i] <= b[j]) {
                result[k++] = a[i++];
            } else {
                result[k++] = b[j++];
            }
        }

        while (i < n)
            result[k++] = a[i++];

        while (j < m)
            result[k++] = b[j++];

        return result;
    }



    /*
    =====================================================
    2️⃣ Copy + Sort Method (Simplest)
    Time  : O((n+m) log(n+m))
    Space : O(n+m)
    =====================================================
    */
    public static int[] mergeCopySort(int[] a, int[] b) {

        int[] result = new int[a.length + b.length];

        System.arraycopy(a, 0, result, 0, a.length);
        System.arraycopy(b, 0, result, a.length, b.length);

        Arrays.sort(result);

        return result;
    }



    /*
    =====================================================
    3️⃣ In-place Merge Using Swap + Insert
    Time  : O(n * m)
    Space : O(1)
    =====================================================
    */
    public static void mergeInPlaceSwap(int[] a, int[] b) {

        int n = a.length;
        int m = b.length;

        for (int i = 0; i < n; i++) {

            if (a[i] > b[0]) {

                int temp = a[i];
                a[i] = b[0];
                b[0] = temp;

                int first = b[0];
                int k;

                for (k = 1; k < m && b[k] < first; k++) {
                    b[k - 1] = b[k];
                }

                b[k - 1] = first;
            }
        }
    }



    /*
    =====================================================
    4️⃣ GAP Method (Shell Sort Inspired)
    Time  : O((n+m) log(n+m))
    Space : O(1)
    =====================================================
    */
    public static void mergeGapMethod(int[] a, int[] b) {

        int n = a.length;
        int m = b.length;

        int gap = (n + m + 1) / 2;

        while (gap > 0) {

            int i = 0;
            int j = gap;

            while (j < n + m) {

                int val1 = get(a, b, i);
                int val2 = get(a, b, j);

                if (val1 > val2) {
                    set(a, b, i, val2);
                    set(a, b, j, val1);
                }

                i++;
                j++;
            }

            if (gap == 1)
                gap = 0;
            else
                gap = (gap + 1) / 2;
        }
    }

    private static int get(int[] a, int[] b, int index) {

        if (index < a.length)
            return a[index];

        return b[index - a.length];
    }

    private static void set(int[] a, int[] b, int index, int value) {

        if (index < a.length)
            a[index] = value;
        else
            b[index - a.length] = value;
    }



    /*
    =====================================================
    MAIN METHOD (Testing)
    =====================================================
    */
    public static void main(String[] args) {

        int[] a = {1, 3, 5, 7};
        int[] b = {2, 4, 6, 8};

        System.out.println("Two Pointer Merge:");
        System.out.println(Arrays.toString(mergeTwoPointer(a, b)));

        System.out.println("\nCopy + Sort Merge:");
        System.out.println(Arrays.toString(mergeCopySort(a, b)));

        int[] a2 = {1,4,7,8,10};
        int[] b2 = {2,3,9};

        mergeInPlaceSwap(a2, b2);
        System.out.println("\nIn-place Swap Merge:");
        System.out.println(Arrays.toString(a2) + " " + Arrays.toString(b2));

        int[] a3 = {1,5,9};
        int[] b3 = {2,3,8};

        mergeGapMethod(a3, b3);
        System.out.println("\nGap Method Merge:");
        System.out.println(Arrays.toString(a3) + " " + Arrays.toString(b3));
    }
}
