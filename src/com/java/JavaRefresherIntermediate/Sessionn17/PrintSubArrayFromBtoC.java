package com.scaler.JavaRefresherIntermediate.Sessionn17;
public class  PrintSubArrayFromBtoC {
    public static int[] printSubArrayFromBtoC(int[] A, int B, int C) {
        // Handle null or empty input
        if (A == null || A.length == 0) {
            return new int[0];
        }

        // Validate indices
        if (B < 0 || C >= A.length || B > C) {
            System.out.println("Invalid range: B = " + B + ", C = " + C);
            return new int[0];
        }

        // Create result array of appropriate size
        int[] ans = new int[C - B + 1];

        // Copy elements from A[B..C]
        for (int i = B; i <= C; i++) {
            ans[i - B] = A[i];
        }

        return ans;
    }

    // Example usage
    public static void main(String[] args) {
        //Bad way of doing 
        int[] A1= new int[5];
        A1[0] = 4;
        A1[1] = 3;
        A1[2] = 2;
        A1[3] = 6;
        A1[4] = 1;

        //Direct initialization of array and assiginment of values
        int[] A = {4, 3, 2, 6, 1, 7};

        // Normal range
        printArray(printSubArrayFromBtoC(A, 1, 3)); // [3, 2, 6]

        // Single element
        printArray(printSubArrayFromBtoC(A, 4, 4)); // [1]

        // Invalid: B > C
        printArray(printSubArrayFromBtoC(A, 5, 2)); // []

        // Invalid: C >= A.length
        printArray(printSubArrayFromBtoC(A, 2, 10)); // []

        // Invalid: negative B
        printArray(printSubArrayFromBtoC(A, -1, 3)); // []
    }

    private static void printArray(int[] arr) {
        if (arr.length == 0) {
            System.out.println("[]");
            return;
        }
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i < arr.length - 1) System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}

