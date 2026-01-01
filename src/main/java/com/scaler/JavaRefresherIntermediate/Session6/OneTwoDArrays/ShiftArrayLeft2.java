package com.scaler.JavaRefresherIntermediate.Session6.OneTwoDArrays;

import java.util.Arrays;
import java.util.Scanner;

public class ShiftArrayLeft2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		int[] array =new int[size];
		for(int i=0;i<size;i++) {
			int num = scan.nextInt();
			array[i]= num;
		}
		int position = scan.nextInt();
		int[] arrayNew =new int[size-1];
		for(int i=0;i<position;i++) {
			arrayNew[i]=array[i];
		}
		for(int i=position-1;i<size-1;i++) {
			arrayNew[i]=array[i+1];
		}
		//System.out.print(Arrays.toString(arrayNew));
		for(int i=0;i<size-1;i++) {
			System.out.println(arrayNew[i]);
		}
		scan.close();
	}
	

}
