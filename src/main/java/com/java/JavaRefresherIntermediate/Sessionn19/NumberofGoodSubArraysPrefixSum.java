package com.java.JavaRefresherIntermediate.Sessionn19;

public class NumberofGoodSubArraysPrefixSum {

	public static int numberofGoodSubArrays(int[] A, int B) {
		int n= A.length;
		int goodSubArrays =0;
		for(int i=0;i<n;i++) {
			int sum =0;
			for(int j=i;j<n;j++) {
				sum +=A[j];
				int length = j-i+1;
				if(length%2!=0 && sum >B) {
					goodSubArrays++;
				}
				else if(length%2==0 && sum <B) goodSubArrays++;
				//else continue;
			}
		}
		
		return goodSubArrays;
	}

	public static void main(String[] args) {
		int[] A = {0,1,2,3,4,5,6,7,8,9};
		System.out.println(numberofGoodSubArrays(A,3));
	}

}
