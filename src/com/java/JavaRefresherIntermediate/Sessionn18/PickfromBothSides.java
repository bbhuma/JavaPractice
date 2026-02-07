package com.scaler.JavaRefresherIntermediate.Sessionn18;
public class PickfromBothSides {
	public static int pickfromBothSides(int[] A, int B) {
        int n= A.length;
        int[] prefix = prefixRight(A);
        int[] suffix = suffixLeft(A);
        int maxSum = Integer.MIN_VALUE;
        int maxSum1 = suffix[n-B]; // i==0
        int maxSum2 = prefix[B-1]; // i==B
        maxSum = Math.max(maxSum1,maxSum2);
        for(int i=1;i<B;i++){
            int sum =0;
            sum = prefix[i-1]+ suffix[n-(B-i)];
            maxSum = Math.max(maxSum,sum);
        }
        return maxSum;
    }
    public static int[] prefixRight(int[] A){
        int n = A.length;
        int[] prefix = new int[n];
        prefix[0] = A[0];
        for(int i=1;i<n;i++){
            prefix[i] = prefix[i-1]+ A[i];
        }
        return prefix;
    } 
    public static int[] suffixLeft(int[] A){
        int n = A.length;
        int[] suffix = new int[n];
        suffix[n-1] = A[n-1];
        for(int i=n-2;i>=0;i--){
            suffix[i] = suffix[i+1]+ A[i];
        }
        return suffix;
    }
    public static void main(String[] args) {
		int[] A = {1,2,3,4,5,6,7};
		pickfromBothSides(A,3);
	}

}
