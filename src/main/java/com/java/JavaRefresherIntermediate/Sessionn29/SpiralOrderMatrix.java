package com.java.JavaRefresherIntermediate.Sessionn29;

public class SpiralOrderMatrix {
	public static void main(String[] args) {
		int[][] answer = generateMatrix(5);
		System.out.print("[");
		for(int i=0;i<answer.length;i++) {
			System.out.print("[");
			for(int j=0;j<answer[i].length;j++) {
				System.out.print(answer[i][j]+ " ");
			}
			if(!(i==answer.length-1)) {
			System.out.print("],");
			System.out.println();
			}else {
				System.out.print("]");
			}
		}
		System.out.print("]");
	}
	public static int[][] generateMatrix(int A) {
		int[][] matrix = new int[A][A];
		int value = 1;
		int r = 0, c = 0;
		if (A <= 0)
			return new int[0][0]; // new keyword is must,else error
		while (A > 1) {
			for (int i = 1; i < A; i++) {
				matrix[r][c] = value;
				value++;
				c++; // c= A by end, print 0,A
			}
			for (int i = 1; i < A; i++) {
				matrix[r][c] = value;
				value++;
				r++;
			}
			for (int i = 1; i < A; i++) {
				matrix[r][c] = value;
				value++;
				c--;
			}
			for (int i = 1; i < A; i++) {
				matrix[r][c] = value;
				value++;
				r--;
			}
			// very important to move to next inner layer, otherwise infinite loop
			// we are back to r,c and A positions of current layer
			A -= 2; // 0,0 to 1,1 to 2,2 ..... A-1,A-1
			c++;
			r++;
		}
		if (A == 1) {
			matrix[r][c] = value;
		}

		return matrix;
	}
}
