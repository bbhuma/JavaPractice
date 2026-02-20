package com.java.JavaRefresherIntermediate.Sessionn31.LabSession;

public class SingleNumberII {

	public static void main(String[] args) {
		int[] arr = {1,2,3,1,2,3,1,2,3,5};
		int ans = singleNumberII(arr);
		System.out.println(ans);
	}

	public static int singleNumberII(int[] arr) {
		int n = arr.length;
		int result = 0;
		for (int i = 0; i < 32; i++) {
			int sum = 0;
			for (int j = 0; j < n; j++) {
				if (((arr[j] >> i)&1)==1 ){
					sum++;
				}
			}
			if((sum % 3)!=0)  result = result | (1 << i);
		}

		return result;
	}

}
