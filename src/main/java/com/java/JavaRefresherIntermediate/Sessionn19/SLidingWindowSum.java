package com.java.JavaRefresherIntermediate.Sessionn19;

public class SLidingWindowSum {
	public static int sidingWindowSum(int[] A,int B) {
		if(A==null || A.length ==0)return 0;
		int n= A.length;
		if(B>n) return 0;
		if(A.length ==1)return A[0];
		int answer = Integer.MIN_VALUE;
		int sum =0;
		int i=0, j=B-1;
		for(int k=i;k<=j;k++){ // 0 to k-1 -> k elements
			sum += A[k];
		}
		answer = Math.max(answer, sum);
		i++; j++;
		while(j<n) {
			sum = sum + A[j]-A[i-1];
			answer = Math.max(answer, sum);
			i++;j++;
		}
		
		return answer;
	}

	public static void main(String[] args) {
		int[] A = {0,1,2,3,4,5,6,7,8,9};
		System.out.println(sidingWindowSum(A,3));

	}

}
