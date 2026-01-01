package com.scaler.JavaRefresherIntermediate.Session6.OneTwoDArrays;

import java.util.ArrayList;
import java.util.Scanner;

public class ShiftArrayRightBy1ByArray {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		ArrayList<Integer> list = new ArrayList<>();

		// int[] array =new int[size+1];
		for (int i = 0; i < size; i++) {
			//int num = scan.nextInt();
			list.add(scan.nextInt());
		}
		int position = scan.nextInt();
		int newnum = scan.nextInt();

		list.add(position - 1, newnum);

		for (int num : list) {
			System.out.print(num + " ");
		}
		scan.close();
	}

}
