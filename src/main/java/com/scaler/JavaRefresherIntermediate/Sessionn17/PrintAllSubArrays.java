package com.scaler.JavaRefresherIntermediate.Sessionn17;

public class PrintAllSubArrays {
    public static void printSubarrays(int[] arr) {  
        int n = arr.length;  
        System.out.println("All possible subarrays are: "+ n*(n+1)/2);
        // Loop for starting index  
        for (int i = 0; i < n; i++) {  
            // Loop for ending index  
            for (int j = i; j < n; j++) {  
                // Print subarray between current starting and ending indices  
                for (int k = i; k <= j; k++) {  
                    System.out.print(arr[k] + " ");  
                }  
                System.out.println(); // New line after each subarray  
            }  
        }  
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        printSubarrays(arr);
    }
}
