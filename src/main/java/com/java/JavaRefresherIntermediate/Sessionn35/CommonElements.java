package com.java.JavaRefresherIntermediate.Sessionn35;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CommonElements {

	public static void main(String[] args) {
		int[] arr1 = {1, 2, 3, 4, 5, 2, 3, 1};
		int[] arr2 = {3, 4, 5, 6, 7};
		System.out.println("Common elements in the two arrays are: ");
		int[] ans1 = commonElements(arr1, arr2);
		int[] ans2 = commonElementsSetMethod(arr1, arr2);
		System.out.println("");
		System.out.print("HashMap Way "+"[");
		for(int i : ans1) {
			System.out.print(i+" ");
			
		}
		System.out.print("]");
		System.out.println("");
		System.out.print("Set Way "+"[");
		for(int i : ans2) {
			System.out.print(i+" ");
			
		}
		System.out.print("]");
		

	}
	public static int[] commonElements(int[] arr1,int[] arr2) {
		HashMap<Integer, Integer> freqMap = new HashMap<>();
		for (int i = 0; i < arr1.length; i++) {
			freqMap.put(arr1[i], freqMap.getOrDefault(arr1[i], 0) + 1);
		}
		List<Integer> commonElements = new ArrayList<>();
		for (int i = 0; i < arr2.length; i++) {
			if (freqMap.containsKey(arr2[i]) && freqMap.get(arr2[i]) > 0) {
				commonElements.add(arr2[i]);
				System.out.print(arr2[i] + " ");
				freqMap.put(arr2[i], freqMap.get(arr2[i]) - 1);
			}
		}
		return commonElements.stream().mapToInt(i -> i).toArray();
	}
	
	public static int[] commonElementsSetMethod(int[] arr1,int[] arr2) {
		Set<Integer> set1 = new HashSet<>();
		Set<Integer> set2 = new HashSet<>();
		for (int i = 0; i < arr1.length; i++) {
			set1.add(arr1[i]);
		}
		for (int i = 0; i < arr2.length; i++) {
			set2.add(arr2[i]);
		}
		List<Integer> commonElements = new ArrayList<>();
		for (Integer num : set1) {
			if (set2.contains(num)) {
				commonElements.add(num);
			}
		}
		return commonElements.stream().mapToInt(i -> i).toArray();
	}
}
