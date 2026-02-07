package com.scaler.JavaRefresherIntermediate.Session8.ArrayLists;

import java.util.ArrayList;

public class ArrayListMethods {

	public static void main(String[] args) {

	}
	
	public ArrayList<ArrayList<Integer>> transposeMatirx(ArrayList<ArrayList<Integer>> A) {
		ArrayList<ArrayList<Integer>> transpose = new ArrayList<ArrayList<Integer>>();
		//ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		int rows =A.size();
		int cols = A.get(0).size(); 
		
		for(int i=0; i<cols ;i++) {
			ArrayList<Integer> al = new ArrayList<>();
			for (int j = 0; j < rows; j++) {
				al.add(A.get(j).get(i));
			}
			transpose.add(al);
		}
		
		for (ArrayList<Integer> col : A) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (Integer row : col) {
				list.add(row);
			}
			transpose.add(list);
		}
		
		for (int i = 0; i < A.get(0).size(); i++) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int j = 0; j < A.size(); j++) {
				//list.get(i).add(A.get(i).get(j));
			}

		}
		return transpose;
	}
	public static ArrayList<Integer> cubesOfArrayElements(ArrayList<Integer> A){
		ArrayList<Integer> list = new ArrayList<Integer>();
		int size = A.size();
		
		for (int i = 0; i < size; i++) {
//			int cube = A.get(i);
//			cube = cube*cube*cube;
			list.add(A.get(i)*A.get(i)*A.get(i));
		}
		
		return list;
	}
	
	public ArrayList<ArrayList<Integer>> multiplesOfseachElement(ArrayList<Integer> A, ArrayList<Integer> B) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		int rowsA = A.size();
		int rowsB = B.size();
		
		for(int i=0; i<rowsA; i++) {
			ArrayList<Integer> al = new ArrayList<Integer>();
			for(int j=0; j< rowsB;j++) {
			if(A.get(i)%B.get(j) == 0) al.add(A.get(j));
			}
			list.add(al);
		}
		return list;
    }
	public ArrayList<ArrayList<Integer>> multiplesOfseachElementNew(ArrayList<Integer> A, ArrayList<Integer> B) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		int rowsA = A.size();
		int rowsB = B.size();
		
		for(int i=0; i<rowsA; i++) {
			ArrayList<Integer> al = new ArrayList<Integer>();
			for(int j=0; j< rowsB;j++) {
			if(A.get(i)%B.get(j) == 0) al.add(A.get(j));
			}
			list.add(al);
		}
		return list;
    }
	

}
