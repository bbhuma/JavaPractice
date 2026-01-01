package com.scaler.JavaRefresherIntermediate.Session6.OneTwoDArrays;

import java.util.Scanner;

public class PrintColoumnByColumn {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter number of rows:");
		int rows = scan.nextInt();
		System.out.println("Enter number of cols:");
		int cols = scan.nextInt();
		int[][] matrix = new int[rows][cols];
		System.out.println("Enter 2D array elements and print them as well :");
		for(int i=0;i<rows;i++) {
			System.out.println( "Enter elements of row: ");
			for(int j=0;j<cols;j++) {
				matrix[i][j]= scan.nextInt();
				//System.out.print(matrix[i][j]+ " ");
			}
			System.out.println();
		}
		System.out.println("Enter array elements of Transpose of a matrix is coloumn by coloumn:");
		for(int i=0;i<cols;i++) {
			for(int j=0;j<rows;j++) {
			System.out.print(matrix[j][i]+ " ");
			}
			System.out.println();
		}
		scan.close();

	}

}
