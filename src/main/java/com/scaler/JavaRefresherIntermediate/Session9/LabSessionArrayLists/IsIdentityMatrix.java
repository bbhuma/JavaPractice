package com.scaler.JavaRefresherIntermediate.Session9.LabSessionArrayLists;

import java.util.ArrayList;
import java.util.List;

public class IsIdentityMatrix {
    public int solve(final List<ArrayList<Integer>> A) {
        for(int i=0;i<A.size();i++){
            for(int j=0;j<A.get(i).size();j++){
                if(i==j && A.get(i).get(j)!=1){
                    return 0;
                }else if(i!=j && A.get(i).get(j)!=0){
                    return 0;
                }
            }
            
        }
        return 1;
    }
    public ArrayList<ArrayList<Integer>> createMatrix(int[][] arr){
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            ArrayList<Integer> row = new ArrayList<>();
            for(int j=0;j<arr[i].length;j++){
                row.add(arr[i][j]);
            }
            matrix.add(row);
        }
        return matrix;
    }
    public static void main(String[] args) {
        IsIdentityMatrix obj = new IsIdentityMatrix();
        int[][] arr = {
            {1, 0, 0},
            {0, 1, 0},
            {0, 0, 1}
        };
        ArrayList<ArrayList<Integer>> matrix = obj.createMatrix(arr);
        int result = obj.solve(matrix);
        System.out.println(result); // Output: 1
    }
    public ArrayList<Integer> matrixMultiply(ArrayList<ArrayList<Integer>> A, ArrayList<ArrayList<Integer>> B) {
        int n = A.size();
        int m = A.get(0).size(); 
        int p = B.get(0).size();
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < p; j++) {
                int sum = 0;
                for (int k = 0; k < m; k++) {
                    sum += A.get(i).get(k) * B.get(k).get(j);
                }
                result.add(sum);
            }
        }
        return result;
    }
    
}
