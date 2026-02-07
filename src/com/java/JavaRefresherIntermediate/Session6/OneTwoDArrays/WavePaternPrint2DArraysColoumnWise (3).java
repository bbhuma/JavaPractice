package com.scaler.JavaRefresherIntermediate.Session6.OneTwoDArrays;

import java.util.Scanner;

public class WavePaternPrint2DArraysColoumnWise {
	
	

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int rows = scan.nextInt();
		int[][] matrix = new int[rows][rows];
		for(int i=0;i<rows;i++) {
			System.out.println( "Enter elements of row: ");
			for(int j=0;j<rows;j++) {
				matrix[i][j]= scan.nextInt();
				//System.out.print(matrix[i][j]+ " ");
			}
			//System.out.println();
		}
		for(int i=0;i<rows;i++) {
			if(i%2 == 0){
                for(int j=0;j<rows;j++) {
                System.out.print(matrix[j][i]+ " ");
                }
            }
            else {
                for(int j=rows-1;j>=0;j--) {
                System.out.print(matrix[j][i]+ " ");
                }
            }
			System.out.println();
		}
		scan.close();
	}

}
