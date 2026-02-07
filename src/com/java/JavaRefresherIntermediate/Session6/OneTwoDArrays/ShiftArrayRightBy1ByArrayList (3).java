package com.scaler.JavaRefresherIntermediate.Session6.OneTwoDArrays;

import java.util.Scanner;

public class ShiftArrayRightBy1ByArrayList {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		int[] array =new int[size+1];
		for(int i=0;i<size;i++) {
			int num = scan.nextInt();
			array[i]= num;
		}
		int position = scan.nextInt();
		int newnum = scan.nextInt();
		// shift the array elements from position-1 index to size-1
		for(int i=size-1;i>= position-1;i--) {
			array[i+1]=array[i];
		}
		array[position-1]=newnum;
		//System.out.print(Arrays.toString(arrayNew));
		// Print till size-1, ignore last element. 
		for(int i=0;i<size+1;i++) {
			System.out.print(array[i]+" ");
		}
		scan.close();
	}
	

}
