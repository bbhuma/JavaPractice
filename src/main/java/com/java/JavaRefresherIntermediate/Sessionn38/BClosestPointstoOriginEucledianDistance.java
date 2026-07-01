package com.java.JavaRefresherIntermediate.Sessionn38;

import java.util.Arrays;
import java.util.stream.Collectors;

public class BClosestPointstoOriginEucledianDistance {

	public static void main(String[] args) {
	int[][] arr = {{1, 3}, {-2, 2}, {5, 8}, {0, 1}};
	int[][] ans = bClosestPointstoOriginEucledianDistance(arr, 3);
	
	System.out.print("[");
	for(int i=0;i<ans.length;i++) {
		System.out.print("[");
		for(int j=0;j<ans[i].length;j++) {
			System.out.print(ans[i][j]);
			if(j != ans[i].length-1 )System.out.print(",");
		}
		System.out.print("]");
		if(i != ans.length-1 )System.out.print(",");
	}
	System.out.print("]");

	}
	public static int[][] bClosestPointstoOriginEucledianDistance(int[][] arr,int B) {
		
		// This does not return anything, simply sorts array based on comparator.
		Arrays.sort(arr, (a,b)->Integer.compare(a[0]*a[0]+a[1]*a[1],b[0]*b[0]+b[1]*b[1]));
		
		int[][] ans = new int[B][2];
		for(int i=0; i<B;i++) {
			for(int j=0;j<ans[i].length;j++) {
				ans[i][j] = arr[i][j];
			}
		}
		return ans; 
	}

}
