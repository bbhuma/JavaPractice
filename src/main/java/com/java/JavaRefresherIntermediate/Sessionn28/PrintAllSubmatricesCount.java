package com.java.JavaRefresherIntermediate.Sessionn28;

public class PrintAllSubmatricesCount {
	public static void main(String[] args) {
		int[][] arr = { { 1, 2, 3 }, { 3, 4, 5 }, { 6, 7, 8 } };
		printAllSubmatrices(arr);
	}

	public static void printAllSubmatrices(int[][] arr) {
		int n = arr.length;
		int m = arr[0].length;
		int counter = 0; // at each point counter will help us verify total number of submatrices, now submatrices = 0;
		for (int startRow = 0; startRow < n; startRow++) {
			for (int endRow = startRow; endRow < n; endRow++) {
				for (int startCol = 0; startCol < m; startCol++) {
					for (int endCol = startCol; endCol < m; endCol++) {
						
						// Print the submatrix from (startRow, startCol) to (endRow, endCol)
						for (int i = startRow; i <= endRow; i++) {
							for (int j = startCol; j <= endCol; j++) {
								System.out.print(arr[i][j] + " ");
							}
							System.out.println();
							
						}
						counter++;
						System.out.println("----");
					}
				}

			}
		}
		System.out.println("Total Submatrices: " + counter);
		System.out.println("Expected Total Submatrices: " + (n * (n + 1) / 2) * (m * (m + 1) / 2));
	}

}
