package com.java.JavaRefresherIntermediate.Sessionn19;

public class SubarrayWithLeastAverage {
	 public static int subarrayWithLeastAverage(int[] A, int B) {
	        if(A== null || A.length ==0) return 0;
	        int n= A.length;

	        int firstSum =0;
	        for(int i=0;i<B;i++){
	            firstSum+= A[i];
	        }
	        int leastSum= firstSum;
	        int leastIndex=0;

	        int sum =firstSum; //running window sum
	        for(int i =1,j=B;j<n;i++,j++){
	            //sum = sum + A[j]- A[j-B];
	            sum = sum + A[j]- A[i-1];
	            //sum = sum/B;
	            if(sum < leastSum) { //update both index and sum at once, to keep track of.
	            	leastIndex = i;
	            	leastSum = sum;
	            }
	            
	            
	        }
	        return leastIndex;
	    }

	 public static void main(String[] args) {
		int[] A = {};
		System.out.println(subarrayWithLeastAverage(A,3)); // 3 is sliding window
	}
}
