package com.scaler.JavaRefresherIntermediate.Sessionn19;

public class CountingSubarraysWhoseSumIsLessthanB {
	public static int countingSubarraysWhoseSumIsLessthanB(int[] A,int B) {
		int n= A.length;
		int count =0;
		for(int i=0;i<n;i++){
			int sum=0;
			for(int j=i;j<n;j++) {
				sum += A[j];
				if(sum<B) count++;
			}
		}
		return count;
	}
	public static int[] prefixSum(int[] A) {
		int[] prefix = new int[A.length];
		prefix[0]= A[0];
		for(int i=1;i<A.length;i++) {
			prefix[i] = prefix[i-1]+A[i];
		}
		return prefix;
	}
	public static void main(String[] args) {
		int[] A = {0,1,2,3,4,5,6,7,8,9};
		System.out.println(countingSubarraysWhoseSumIsLessthanB(A,23)); // 3 is sum

	}
	

}
