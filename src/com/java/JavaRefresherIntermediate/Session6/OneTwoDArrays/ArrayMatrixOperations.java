package com.scaler.JavaRefresherIntermediate.Session6.OneTwoDArrays;
import java.util.*;

public class ArrayMatrixOperations {
    // ========== MAIN ==========
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // User decides size of 1D array and inputs elements
        System.out.print("Enter size of 1D array: ");
        int n = sc.nextInt();
        int[] arr = input1DArray(sc, n);

        // User decides size of 2D array and inputs elements if matrix
        System.out.print("Enter number of rows for 2D array: ");
        int rows = sc.nextInt();
        System.out.print("Enter number of columns for 2D array: ");
        int cols = sc.nextInt();
        int[][] mat = input2DArray(sc, rows, cols);

        // Matrix operations
        printMatrixByRow(mat);
        printMatrixByCol(mat);
        printByColumnsLikeRowWise(mat);
        System.out.println("Transpose:");
        printMatrix(transpose(mat));

        // Inverse (only for square matrix)
        if (rows == cols) {
            System.out.println("Inverse Matrix:");
            double[][] inv = inverseMatrix(mat);
            printMatrix(inv);
        }

        // Array operations
        findFrequency(arr);
        System.out.println("Frequency array:");
        printArray(freqArray(arr));

        System.out.println("Left shift by 2:");
        printArray(leftShift(arr, 2));
        System.out.println("Right shift by 2:");
        printArray(rightShift(arr, 2));

        System.out.println("Strictly increasing? " + isStrictlyIncreasing(arr));
        System.out.println("Non-decreasing? " + isNonDecreasing(arr));

        System.out.println("Insert element 99 at position 2:");
        printArray(insertElement(arr, 2, 99));

        System.out.println("Remove element at position 3:");
        printArray(removeElement(arr, 3));

        // ArrayList conversion
        convertArrayToArrayList(arr);

        // Traversals
        printLeftToRightTopToBottom(mat);
        printRightToLeftTopToBottom(mat);
        printLeftToRightBottomToTop(mat);
        printRightToLeftBottomToTop(mat);
        printTopToBottomLeftToRight(mat);
        printBottomToTopLeftToRight(mat);
        printTopToBottomRightToLeft(mat);
        printBottomToTopRightToLeft(mat);

        // Diagonals
        printPrimaryDiagonal(mat);
        printSecondaryDiagonal(mat);
        printZigzagDiagonals(mat);

        // Print matrix col-by-col but in row-wise format
        System.out.println("Matrix printed column by column (without modifying matrix):");
        printMatrixColumnWiseAsRows(mat);

        sc.close();
    }

    // ========== INPUT METHODS ==========
    public static int[] input1DArray(Scanner sc, int n) {
        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements for 1D array:");
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        return arr;
    }

    public static int[][] input2DArray(Scanner sc, int rows, int cols) {
        int[][] mat = new int[rows][cols];
        System.out.println("Enter elements for " + rows + "x" + cols + " matrix:");
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                mat[i][j] = sc.nextInt();
        return mat;
    }

    // ========== MATRIX METHODS ==========
    public static void printMatrixByRow(int[][] mat) {
        System.out.println("Matrix by rows:");
        for (int[] row : mat) {
            for (int val : row)
                System.out.print(val + " ");
            System.out.println();
        }
    }

    public static void printMatrixByCol(int[][] mat) {
        System.out.println("Matrix by columns:");
        for (int j = 0; j < mat[0].length; j++) {
            for (int i = 0; i < mat.length; i++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] transpose(int[][] mat) {
        int rows = mat.length, cols = mat[0].length;
        int[][] trans = new int[cols][rows];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                trans[j][i] = mat[i][j];
        return trans;
    }

    public static double[][] inverseMatrix(int[][] mat) {
        int n = mat.length;
        double[][] a = new double[n][n];
        double[][] inv = new double[n][n];

        // copy int matrix into double
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = mat[i][j];
            }
            inv[i][i] = 1;
        }

        // Gaussian elimination
        for (int i = 0; i < n; i++) {
            double diag = a[i][i];
            if (diag == 0) throw new ArithmeticException("Matrix is singular!");
            for (int j = 0; j < n; j++) {
                a[i][j] /= diag;
                inv[i][j] /= diag;
            }
            for (int k = 0; k < n; k++) {
                if (k != i) {
                    double factor = a[k][i];
                    for (int j = 0; j < n; j++) {
                        a[k][j] -= factor * a[i][j];
                        inv[k][j] -= factor * inv[i][j];
                    }
                }
            }
        }
        return inv;
    }

    // ========== 1D ARRAY METHODS ==========
    public static void findFrequency(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int val : arr)
            freq.put(val, freq.getOrDefault(val, 0) + 1);
        System.out.println("Frequency: " + freq);
    }

    public static int[] freqArray(int[] arr) {
        int[] freqArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int val : arr)
                if (val == arr[i])
                    count++;
            freqArr[i] = count;
        }
        return freqArr;
    }

    public static int[] leftShift(int[] arr, int k) {
        if (k >= arr.length)
            return arr;
        int[] shifted = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            shifted[i] = arr[(i + k) % arr.length];
        }
        return shifted;
    }

    public static int[] rightShift(int[] arr, int k) {
        if (k >= arr.length)
            return arr;
        int[] shifted = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            shifted[(i + k) % arr.length] = arr[i];
        }
        return shifted;
    }

    public static boolean isStrictlyIncreasing(int[] arr) {
        for (int i = 1; i < arr.length; i++)
            if (arr[i] <= arr[i - 1])
                return false;
        return true;
    }

    public static boolean isNonDecreasing(int[] arr) {
        for (int i = 1; i < arr.length; i++)
            if (arr[i] < arr[i - 1])
                return false;
        return true;
    }

    public static int[] insertElement(int[] arr, int pos, int num) {
        int index = pos - 1; // convert position to index
        if (index < 0 || index > arr.length)
            return arr;
        int[] newArr = new int[arr.length + 1];
        for (int i = 0, j = 0; i < newArr.length; i++) {
            if (i == index)
                newArr[i] = num;
            else
                newArr[i] = arr[j++];
        }
        return newArr;
    }

    public static int[] removeElement(int[] arr, int pos) {
        int index = pos - 1; // convert position to index
        if (index < 0 || index >= arr.length)
            return arr;
        int[] newArr = new int[arr.length - 1];
        for (int i = 0, j = 0; i < arr.length; i++) {
            if (i == index)
                continue;
            newArr[j++] = arr[i];
        }
        return newArr;
    }

    // ========== ARRAYLIST CONVERSIONS ==========
    public static void convertArrayToArrayList(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int val : arr)
            list.add(val);
        System.out.println("ArrayList: " + list);

        // Insertion (position 3 means index 2)
        list.add(2, 99);
        System.out.println("After insertion: " + list);

        // Deletion (position 2 means index 1)
        list.remove(1);
        System.out.println("After deletion: " + list);
    }

    // ========== UTILITY ==========
    public static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void printMatrix(int[][] mat) {
        for (int[] row : mat)
            System.out.println(Arrays.toString(row));
    }

    public static void printMatrix(double[][] mat) {
        for (double[] row : mat)
            System.out.println(Arrays.toString(row));
    }

    // ========== MATRIX TRAVERSALS ==========
    // Row-wise
    public static void printLeftToRightTopToBottom(int[][] mat) {
        System.out.println("Row-wise Left → Right, Top → Bottom:");
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
        }
        System.out.println();
    }

    public static void printRightToLeftTopToBottom(int[][] mat) {
        System.out.println("Row-wise Right → Left, Top → Bottom:");
        for (int i = 0; i < mat.length; i++) {
            for (int j = mat[0].length - 1; j >= 0; j--) {
                System.out.print(mat[i][j] + " ");
            }
        }
        System.out.println();
    }

    public static void printLeftToRightBottomToTop(int[][] mat) {
        System.out.println("Row-wise Left → Right, Bottom → Top:");
        for (int i = mat.length - 1; i >= 0; i--) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
        }
        System.out.println();
    }

    public static void printRightToLeftBottomToTop(int[][] mat) {
        System.out.println("Row-wise Right → Left, Bottom → Top:");
        for (int i = mat.length - 1; i >= 0; i--) {
            for (int j = mat[0].length - 1; j >= 0; j--) {
                System.out.print(mat[i][j] + " ");
            }
        }
        System.out.println();
    }

    // Column-wise
    public static void printTopToBottomLeftToRight(int[][] mat) {
        System.out.println("Column-wise Top → Bottom, Left → Right:");
        for (int j = 0; j < mat[0].length; j++) {
            for (int i = 0; i < mat.length; i++) {
                System.out.print(mat[i][j] + " ");
            }
        }
        System.out.println();
    }

    public static void printBottomToTopLeftToRight(int[][] mat) {
        System.out.println("Column-wise Bottom → Top, Left → Right:");
        for (int j = 0; j < mat[0].length; j++) {
            for (int i = mat.length - 1; i >= 0; i--) {
                System.out.print(mat[i][j] + " ");
            }
        }
        System.out.println();
    }

    public static void printTopToBottomRightToLeft(int[][] mat) {
        System.out.println("Column-wise Top → Bottom, Right → Left:");
        for (int j = mat[0].length - 1; j >= 0; j--) {
            for (int i = 0; i < mat.length; i++) {
                System.out.print(mat[i][j] + " ");
            }
        }
        System.out.println();
    }

    public static void printBottomToTopRightToLeft(int[][] mat) {
        System.out.println("Column-wise Bottom → Top, Right → Left:");
        for (int j = mat[0].length - 1; j >= 0; j--) {
            for (int i = mat.length - 1; i >= 0; i--) {
                System.out.print(mat[i][j] + " ");
            }
        }
        System.out.println();
    }

    // ========== DIAGONAL TRAVERSALS ==========
    public static void printPrimaryDiagonal(int[][] mat) {
        System.out.println("Primary Diagonal (Top-left → Bottom-right):");
        for (int i = 0; i < Math.min(mat.length, mat[0].length); i++) {
            System.out.print(mat[i][i] + " ");
        }
        System.out.println();
    }

    public static void printSecondaryDiagonal(int[][] mat) {
        System.out.println("Secondary Diagonal (Top-right → Bottom-left):");
        for (int i = 0; i < Math.min(mat.length, mat[0].length); i++) {
            System.out.print(mat[i][mat[0].length - 1 - i] + " ");
        }
        System.out.println();
    }

    public static void printZigzagDiagonals(int[][] mat) {
        System.out.println("Zigzag Diagonal Traversal:");
        int rows = mat.length, cols = mat[0].length;
        for (int d = 0; d < rows + cols - 1; d++) {
            if (d % 2 == 0) {
                // upward
                int r = Math.min(d, rows - 1);
                int c = d - r;
                while (r >= 0 && c < cols) {
                    System.out.print(mat[r][c] + " ");
                    r--;
                    c++;
                }
            } else {
                // downward
                int c = Math.min(d, cols - 1);
                int r = d - c;
                while (c >= 0 && r < rows) {
                    System.out.print(mat[r][c] + " ");
                    r++;
                    c--;
                }
            }
        }
        System.out.println();
    }

    // ========== CUSTOM ==========
    public static void printMatrixColumnWiseAsRows(int[][] mat) {
        for (int j = 0; j < mat[0].length; j++) {
            for (int i = 0; i < mat.length; i++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void printByColumnsLikeRowWise(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int total = rows * cols;

        System.out.println("Printing by columns (but same as row-wise):");
        for (int k = 0; k < total; k++) {
            int row = k / cols;   // which row in row-wise order
            int col = k % cols;   // which col in row-wise order
            System.out.print(mat[row][col] + " ");
        }
        System.out.println();
    }
}
