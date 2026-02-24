package com.java.JavaRefresherIntermediate.Sessionn33;

public class FindLastOccurrenceAllWays {
	
	public static void main(String[] args) {

        int[] arr = {4, 9, 3, 9, 2, 9};
        int target = 9;

        // 1️⃣ Global Variable
        globalAns = -1;
        findLast_Global(arr, 0, target);
        System.out.println("Global Variable: " + globalAns);

        // 2️⃣ Forward Recursion (Post Work)
        System.out.println("Post Recursion: " +
                findLast_PostRecursion(arr, 0, target));

        // 3️⃣ Cleaner Forward Recursion
        System.out.println("Clean Forward: " +
                findLast_Clean(arr, 0, target));

        // 4️⃣ Reverse Recursion
        System.out.println("Reverse Recursion: " +
                findLast_Reverse(arr, arr.length - 1, target));

        // 5️⃣ Reverse Iterative (Best)
        System.out.println("Iterative (Best): " +
                findLast_Iterative(arr, target));
        
     // 6 Forward Iterative (Best)
        System.out.println("Forward Iterative: " +
                findLast_ForwardIterative(arr, target));
        
        //7 Forward Recursive with Last Index as a parameter carry forward (Best for understanding recursion, but not practical)
        System.out.println("Forward Recursive with Last Index: " +
                findLast_ForwardRecursive(arr, 0, target, -1));
        
    }

    // ------------------------------------------------------------
    // 1️⃣ Global Variable Approach (Beginner Friendly, Not Ideal)
    // ------------------------------------------------------------

    static int globalAns; // global variables are not ideal, but can be used for simple problems to avoid complexity of return values and parameters

    public static void findLast_Global(int[] arr, int i, int target) {

        if (i == arr.length)
            return;

        if (arr[i] == target)
            globalAns = i;   // keeps updating

        findLast_Global(arr, i + 1, target);
    }

    // ------------------------------------------------------------
    // 2️⃣ Forward Recursion (Post-Recursion Work)
    // ------------------------------------------------------------

    public static int findLast_PostRecursion(int[] arr, int i, int target) {

        if (i == arr.length)
            return -1;

        if (arr[i] == target) {
            int smallAns = findLast_PostRecursion(arr, i + 1, target);
            return smallAns != -1 ? smallAns : i;
        }

        return findLast_PostRecursion(arr, i + 1, target);
    }

    // ------------------------------------------------------------
    // 3️⃣ Cleaner Forward Recursion (More Readable)
    // ------------------------------------------------------------

    public static int findLast_Clean(int[] arr, int i, int target) {

        if (i == arr.length)
            return -1;

        int smallAns = findLast_Clean(arr, i + 1, target);

        if (smallAns != -1)
            return smallAns;

        if (arr[i] == target)
            return i;

        return -1;
    }

    // ------------------------------------------------------------
    // 4️⃣ Reverse Recursion (Much Cleaner & Better)
    // ------------------------------------------------------------

    public static int findLast_Reverse(int[] arr, int i, int target) {

        if (i < 0)
            return -1;

        if (arr[i] == target)
            return i;

        return findLast_Reverse(arr, i - 1, target);
    }

    // ------------------------------------------------------------
    // 5️⃣ Iterative Solution (BEST Practical Solution)
    // ------------------------------------------------------------

    public static int findLast_Iterative(int[] arr, int target) {

        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == target)
                return i;
        }

        return -1;
    }

    public static int findLast_ForwardIterative(int[] arr, int target) {

        int lastIndex = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                lastIndex = i;   // overwrite each time
            }
        }

        return lastIndex;
    }
    public static int findLast_ForwardRecursive(int[] arr, int i, int target, int lastIndex) {

        if (i == arr.length)
            return lastIndex;

        if (arr[i] == target)
            lastIndex = i;   // overwrite

        return findLast_ForwardRecursive(arr, i + 1, target, lastIndex); // lastIndex gets updated in each recursive call
    }
    
    
}