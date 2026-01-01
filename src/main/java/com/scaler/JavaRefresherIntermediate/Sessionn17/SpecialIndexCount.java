package com.scaler.JavaRefresherIntermediate.Sessionn17;

public class SpecialIndexCount {
    public int specialIndexCountofIndexes(int[] A) {
        int count =0;
        int[] prefixEven = evenIndexPrefixSum(A);
        int[] prefixOdd = oddIndexPrefixSum(A);
        for(int i=0;i<A.length;i++){
            int leftSum=0;
            int rightSum=0;
            if(i%2==0){
                //leftSum = prefixEven[i==0?0:i-1];
                leftSum = (i > 0) ? prefixEven[i - 1] : 0;
                rightSum = prefixOdd[A.length-1]-prefixOdd[i];
                if(leftSum==rightSum){
                    count++;
                }
            }else{
                leftSum = (i > 0) ? prefixOdd[i - 1] : 0;
                rightSum = prefixEven[A.length-1]-prefixEven[i];
                if(leftSum==rightSum){
                    count++;
                }
            }
        }
        return count;
    }
    public int[] oddIndexPrefixSum(int[] A) {
        int[] prefixSums = new int[A.length];
        prefixSums[0] = 0;
        for (int i = 1; i < A.length; i ++) {
             if(i%2!=0) prefixSums[i] = prefixSums[i - 2] + A[i];
             else prefixSums[i] = prefixSums[i - 2];
        }
        return prefixSums;
    }
    public int[] evenIndexPrefixSum(int[] A) {
        int[] prefixSums = new int[A.length];
        prefixSums[0] = A[0];
        for (int i = 1; i < A.length; i ++) {
            if(i%2==0)  prefixSums[i] = prefixSums[i - 2] + A[i];
            else prefixSums[i] = prefixSums[i - 2];
        }
        return prefixSums;
    }
    public static void main(String[] args) {
        SpecialIndexCount obj = new SpecialIndexCount();
        int[] A = {2, 1, 6, 4};
        int result = obj.specialIndexCountofIndexes(A);
        System.out.println(result); 
    }
    
}
