package com.scaler.JavaRefresherIntermediate.Sessionn18;
public class SubarrayWithGivenSumandLength {
    public static int subarrayWithGivenSumandLength(int[] A, int B, int C) {
        int N = A.length;
        //int[] prefix = prefixSum(A);
        //int sum = prefix[B-1];
        int sum =0;
        int maxsum = 0;
        for(int i=0;i<B;i++){
            sum += A[i]; 
        }
        for(int i=B;i<N;i++){
            sum = sum + A[i]- A[i-B];
            if (sum==C) {
                return 1;
            }
            maxsum= Math.max(maxsum, sum);
        }
        System.out.println(maxsum);
        return -1;
    }
    public static void main(String[] args) {
        int[] A = {12,10,13,15,17,19,20};
        subarrayWithGivenSumandLength(A,3,20);
    }

    // public static int[] prefixSum(int[] A){
    //     int[] prefix = new int[A.length];
    //     prefix[0] = A[0];
    //     for(int i=1;i<A.length;i++){
    //         prefix[i] = prefix[i-1]+ A[i];
    //     }
    //     return prefix;
    // }
    
}
