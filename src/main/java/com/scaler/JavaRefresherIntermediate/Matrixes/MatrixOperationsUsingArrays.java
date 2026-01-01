package com.scaler.JavaRefresherIntermediate.Matrixes;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class MatrixOperationsUsingArrays {
    public static void main(String[] args) {
        int[][] matrixA = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
         int[][] matrixB = {
            {9, 8, 7},
            {6, 5, 4},
            {3, 2, 1}
        };
        int[][] matrixC = acceptInputMatrix();
        System.out.println("Sum of Matrices:");
        printMatrix(matrixC);

        int[][] sumMatrix = addMatrices(matrixA, matrixB);
        System.out.println("Sum of Matrices:");
        printMatrix(sumMatrix);

        int[][] productMatrix = multiplyMatrices(matrixA, matrixB);
        System.out.println("Product of Matrices:");
        printMatrix(productMatrix);

        int[] rowSums = rowWiseSumArray(matrixA);
        System.out.println("Sum of Matrices:");
        printArray(rowSums);    

        int[] colomnSums = colomnWiseSumArray(matrixA);
        System.out.println("Sum of Matrices:");
        printArray(colomnSums);

        int[][] inverseMatrix = inverseMatrix(matrixA);
        System.out.println("Inverse of Matrix:");
        printMatrix(inverseMatrix); 

        int[][] transposeMatrix = transposeMatrix(matrixA);
        System.out.println("Transpose of Matrix:");
        printMatrix(transposeMatrix); 

        System.out.println("Row-Wise sum[]"+ rowWiseSumArray(matrixA));
        System.out.println("Coloumn-Wise sum[]"+ colomnWiseSumArray(matrixA));

        System.out.println("Frequency of element 2 in array {1,2,2,3,3,3} : "+ frequencyOfElementsInArray(new int[]{1,2,2,3,3,3}, 2));
        System.out.println("Frequency Array[]"+ frequencyElementArrayOfAllElementsDirectImpl(new int[]{1,2,2,3,3,3}));      
        
        int[] freqArray = frequencyElementArrayOfAllElements(new int[]{1,2,2,3,3,3});
        System.out.println("Frequency Array[]"+ freqArray);
        printArray(freqArray);
    }
    public static int[][] acceptInputMatrix() {
        // This method can be implemented to accept user input for a matrix.
        // For simplicity, we will return a predefined matrix here.
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows and columns:");
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        int[][] matrix = new int[rows][cols];
        System.out.println("Enter matrix elements:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
         sc.close();
        return matrix;
                    // return new int[][] {
                    //     {1, 2, 3},
                    //     {4, 5, 6},
                    //     {7, 8, 9}
                    //};
       
    }
    public static int frequencyOfElementsInArray(int[] array,int k){
        int count = 0;
        for(int i=0; i<array.length; i++){  
            if(array[i] == k){
                count++;
            }
        }   
        return count;
    }

    public static int[] frequencyElementArrayOfAllElements(int[] array){
        int[] freq = new int[array.length];
        for(int i=0; i<array.length; i++){
            freq[i] = frequencyOfElementsInArray(array, array[i]);
        }
        return freq;
    }
    public static int[] frequencyElementArrayOfAllElementsDirectImpl(int[] array){
        int[] freq = new int[array.length];
        for(int i=0; i<array.length; i++){
            int count = 0;
            for(int j=0; j<array.length; j++){
                if(array[i] == array[j]){
                    count++;
                }
            }
            freq[i] = count;
        }
        return freq;
    }
    public static int[][] addMatrices(int[][] a, int[][] b) {
        int rows = a.length;
        int cols = a[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = a[i][j] + b[i][j];
            }
        }
        return result;
    }
    public static int[][] multiplyMatrices(int[][] a, int[][] b) {
        int rowsA = a.length;
        int colsA = a[0].length;
        int colsB = b[0].length;
        int[][] result = new int[rowsA][colsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return result;
    }
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
    public static void printArray(int[] array) {
        for (int val : array) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static int[][] transposeMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] transposed = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }
        return transposed;
    }
    public static int[][] inverseMatrix(int[][] matrix) {
        if (matrix.length != matrix[0].length) {
            System.out.println("Inverse not possible");
            return null;
        }
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(i==j && matrix[i][j] == 0){
                    System.out.println("Inverse not possible");
                    return null;
                }
            }
        }
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(i==j){
                    matrix[i][j] = 1/matrix[i][j];
                }
                else{
                    matrix[i][j] = -matrix[i][j];
                }
            }
        }

        return matrix;
    }
    public static int[] rowWiseSumArray(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] rowSums = new int[rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                rowSums[i] += matrix[i][j];
            }
        }
        return rowSums;
    }
    public static int[] colomnWiseSumArray(int[][] matrix){
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] colomnSums = new int[cols];

        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                colomnSums[i] += matrix[j][i];
            }
        }
        return colomnSums;
    }

    public static HashMap<Integer,Integer> frequencyOfElementsInArrayUsingHashMap(int[] array){
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for(int i=0; i<array.length; i++){
            freqMap.put(array[i], freqMap.getOrDefault(array[i], 0) + 1);
        }
        return freqMap;
    }

    public static  HashMap<Integer, Integer> frequencyOfElementsInArrayUsingHashMapGreaterThan1(int[] array){
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for(int i=0; i<array.length; i++){
            freqMap.put(array[i], freqMap.getOrDefault(array[i], 0) + 1);
        }
        HashMap<Integer, Integer> result = new HashMap<>();
        for(Entry<Integer, Integer> entry : freqMap.entrySet()){
            if(entry.getValue() > 1){
                result.put(entry.getKey(), entry.getValue());
            }
        }
        System.out.println("Elements with frequency greater than 1: " + result);
        return result;
    }

    public static int[] printFrequencyOfElementsInArrayUsingHashMapGreaterThan1(int[] array){
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for(int i=0; i<array.length; i++){
            freqMap.put(array[i], freqMap.getOrDefault(array[i], 0) + 1);
        }
        int[] result = new int[freqMap.size()];
        int index = 0;
        for(Entry<Integer, Integer> entry : freqMap.entrySet()){
            if(entry.getValue() > 1){
                result[index++] = entry.getKey();
            }
        }
        return result;
    }



}
