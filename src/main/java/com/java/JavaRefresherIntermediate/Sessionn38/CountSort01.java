package com.java.JavaRefresherIntermediate.Sessionn38;

import java.util.Arrays;
import java.util.OptionalInt;

public class CountSort01 {

	public static void main(String[] args) {
		int[] arr = {0,0,1,0,1,1,0,0,0,1,0,1,1,0};
		int[] ans = countSort01(arr);
		for (int num : ans) {
			System.out.print(num + " ");
		}
	}

	public static int[] countSort01(int[] arr) {
		int max = Arrays.stream(arr).max().getAsInt();
		int[] count = new int[max+1];
		for (int i = 0; i < arr.length; i++) {
			count[arr[i]]++;
			/*
			 * if (arr[i] == 0) count[0]++; if (arr[i] == 1) count[1]++;
			 */
		}
		int index=0; //to loop & fill  through the array
		for(int i=0; i<count.length;i++) {
			for(int j=0;j<count[i];j++) {
				arr[index++] = i;
				
				// index++;
				// i = ఏ value రాస్తున్నాం? (0, 1, 2...)
				// index = ఏ position లో రాస్తున్నాం?
			}
		}
		return arr;
	}

}
