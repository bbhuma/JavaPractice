package com.scaler.JavaRefresherIntermediate.Sessionn19;

public class CountingSubarraysWhoseSumIsLessThanB_Optimized {

	//Only works for non negative numbers with sum keep growing. 
    public static int countSubarraysLessThanB(int[] A, int B) {
        int n = A.length;
        int count = 0;
        int left = 0, sum = 0;

        for (int right = 0; right < n; right++) {
            sum += A[right];

            // shrink window until sum < B
            while (sum >= B && left <= right) {
                sum -= A[left];
                left++;
            }

            // all subarrays ending at right with start in [left..right] are valid
            count += (right - left + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] A = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int B = 23;
        System.out.println(countSubarraysLessThanB(A, B)); // ✅ Output: 26
    }
}
