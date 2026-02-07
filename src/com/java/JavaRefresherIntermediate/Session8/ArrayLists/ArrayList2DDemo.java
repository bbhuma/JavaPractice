package com.scaler.JavaRefresherIntermediate.Session8.ArrayLists;

import java.util.*;
import java.util.stream.Collectors;

public class ArrayList2DDemo {

    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);

        // ===== 1D ArrayList input =====
        System.out.print("Enter number of elements in ArrayList: ");
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        System.out.println("Your 1D ArrayList: " + list);

        // ===== 2D ArrayList (matrix) input =====
        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();

        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        System.out.println("Enter elements of " + rows + "x" + cols + " matrix:");
        for (int i = 0; i < rows; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                row.add(sc.nextInt());
            }
            matrix.add(row);
        }
        System.out.println("Your Matrix (Row by Row):");
        printMatrix(matrix);

        // Print column by column (left → right)
        System.out.println("\nMatrix column by column (top to bottom, left to right):");
        printColumnWise(matrix);

        // Print column by column (right → left)
        System.out.println("\nMatrix column by column (top to bottom, right to left):");
        printColumnWiseReverse(matrix);

        // Transpose of matrix
        System.out.println("\nTranspose of Matrix:");
        ArrayList<ArrayList<Integer>> transpose = transposeMatrix(matrix);
        printMatrix(transpose);

        // Inverse of matrix if square
        if (rows == cols) {
            System.out.println("\nInverse of Matrix (if invertible):");
            double[][] inv = inverseMatrix(to2DArray(matrix));
            if (inv != null) {
                print2DArray(inv);
            } else {
                System.out.println("Matrix is not invertible.");
            }
        }

        // Flatten 2D list using flatMap
        System.out.println("\nFlatten 2D ArrayList using flatMap:");
        List<Integer> flattened = matrix.stream()
                                        .flatMap(row -> row.stream())
                                        .collect(Collectors.toList());
        System.out.println("Flattened list: " + flattened);
    }

    /** Print matrix row by row */
    static void printMatrix(ArrayList<ArrayList<Integer>> matrix) {
        for (ArrayList<Integer> row : matrix) {
            System.out.println(row);
        }
    }

    /** Print column by column (left to right) */
    static void printColumnWise(ArrayList<ArrayList<Integer>> matrix) {
        int rows = matrix.size();
        int cols = matrix.get(0).size();
        for (int j = 0; j < cols; j++) {
            for (int i = 0; i < rows; i++) {
                System.out.print(matrix.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    /** Print column by column (right to left) */
    static void printColumnWiseReverse(ArrayList<ArrayList<Integer>> matrix) {
        int rows = matrix.size();
        int cols = matrix.get(0).size();
        for (int j = cols - 1; j >= 0; j--) {
            for (int i = 0; i < rows; i++) {
                System.out.print(matrix.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    /** Transpose of matrix */
    static ArrayList<ArrayList<Integer>> transposeMatrix(ArrayList<ArrayList<Integer>> matrix) {
        int rows = matrix.size();
        int cols = matrix.get(0).size();
        ArrayList<ArrayList<Integer>> transpose = new ArrayList<>();
        for (int j = 0; j < cols; j++) {
            ArrayList<Integer> newRow = new ArrayList<>();
            for (int i = 0; i < rows; i++) {
                newRow.add(matrix.get(i).get(j));
            }
            transpose.add(newRow);
        }
        return transpose;
    }

    /** Convert ArrayList<ArrayList<Integer>> to 2D double array */
    static double[][] to2DArray(ArrayList<ArrayList<Integer>> matrix) {
        int rows = matrix.size();
        int cols = matrix.get(0).size();
        double[][] arr = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                arr[i][j] = matrix.get(i).get(j);
            }
        }
        return arr;
    }

    /** Print 2D double array */
    static void print2DArray(double[][] arr) {
        for (double[] row : arr) {
            System.out.println(Arrays.toString(row));
        }
    }

    /** Inverse of matrix using Gaussian elimination (for square matrices) */
    static double[][] inverseMatrix(double[][] A) {
        int n = A.length;
        double[][] aug = new double[n][2 * n];

        // Create augmented matrix [A|I]
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                aug[i][j] = A[i][j];
            }
            aug[i][i + n] = 1;
        }

        // Forward elimination
        for (int i = 0; i < n; i++) {
            // Pivot (swap rows if needed)
            if (aug[i][i] == 0) {
                int swapRow = i + 1;
                while (swapRow < n && aug[swapRow][i] == 0) swapRow++;
                if (swapRow == n) return null; // not invertible
                double[] temp = aug[i];
                aug[i] = aug[swapRow];
                aug[swapRow] = temp;
            }

            // Normalize pivot row
            double pivot = aug[i][i];
            for (int j = 0; j < 2 * n; j++) {
                aug[i][j] /= pivot;
            }

            // Eliminate other rows
            for (int k = 0; k < n; k++) {
                if (k != i) {
                    double factor = aug[k][i];
                    for (int j = 0; j < 2 * n; j++) {
                        aug[k][j] -= factor * aug[i][j];
                    }
                }
            }
        }

        // Extract inverse
        double[][] inv = new double[n][n];
        for (int i = 0; i < n; i++) {
            System.arraycopy(aug[i], n, inv[i], 0, n);
        }
        return inv;
    }
}
