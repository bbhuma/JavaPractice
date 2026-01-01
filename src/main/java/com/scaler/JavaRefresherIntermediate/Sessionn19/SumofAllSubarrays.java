package com.scaler.JavaRefresherIntermediate.Sessionn19;

//Sum of all sub arrays by contribution technique
public class SumofAllSubarrays {
	private static long sumOfAllSubArrays(int[] A) {
		long sum =0;
		int n= A.length;
		for(int i=0;i<A.length;i++) {
			sum += (long)A[i]*(i+1)*(n-i);
		}
		return sum;
	}

	public static void main(String[] args) {
		int[] A = {10,12,21,23,45,2,3,5,3,1};
		long sumOfAllSubArrays = sumOfAllSubArrays(A);
		System.out.println(sumOfAllSubArrays);
	}

}
