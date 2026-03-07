package com.java.JavaRefresherIntermediate.Sessionn36;

import java.util.HashMap;
import java.util.HashSet;

public class FirstRepeatingElement {

    public static void main(String[] args) {

        int[] arr = {10, 5, 3, 4, 3, 5, 6};

        System.out.println("Brute Force : " + firstRepeatingBrute(arr));
        System.out.println("HashSet     : " + firstRepeatingSet(arr));
        System.out.println("HashMap     : " + firstRepeatingMap(arr));
        System.out.println("HashMap     : " + firstRepeatingelement(arr));
		System.out.println("HashSet     : " + firstRepeating(arr));
    }


    // ------------------------------------------------
    // 1️⃣ BRUTE FORCE
    // Time : O(N^2)
    // Space: O(1)
    // ------------------------------------------------
    public static int firstRepeatingBrute(int[] arr){

        int n = arr.length;
        int minIndex = Integer.MAX_VALUE;

        for(int i=0;i<n;i++){

            for(int j=i+1;j<n;j++){

                if(arr[i] == arr[j]){

                    minIndex = Math.min(minIndex,i);
                    break;
                }
            }
        }

        if(minIndex == Integer.MAX_VALUE)
            return -1;

        return arr[minIndex];
    }

    

    // ------------------------------------------------
    // 2️⃣ HASHSET METHOD
    // Traverse from right to left
    // Time : O(N)
    // Space: O(N)
    // ------------------------------------------------
    public static int firstRepeatingSet(int[] arr){

        HashSet<Integer> set = new HashSet<>();

        int result = -1;

        for(int i = arr.length-1; i>=0; i--){

            if(set.contains(arr[i])){
                result = arr[i];
            }else{
                set.add(arr[i]);
            }
        }

        return result;
    }


    
    // ------------------------------------------------
    // 3️⃣ OPTIMAL HASHMAP METHOD
    // store first occurrence index
    // Time : O(N)
    // Space: O(N)
    // ------------------------------------------------
    public static int firstRepeatingMap(int[] arr){
        HashMap<Integer,Integer> map = new HashMap<>();
        int minIndex = Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i])){
                minIndex = Math.min(minIndex, map.get(arr[i]));
            }else{
                map.put(arr[i],i);
            }
        }
        if(minIndex == Integer.MAX_VALUE)
            return -1;
        return arr[minIndex];
    }
    
    public static int firstRepeatingelement(int[] A) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int minIdx = Integer.MAX_VALUE;
		for (int i = A.length - 1; i >= 0; i--) {
			if (map.get(A[i]) == null) {
				map.put(A[i], 1);
			} else  {
				map.put(A[i], map.get(A[i]) + 1);
				minIdx = Math.min(minIdx, i);
			}
		}
		return minIdx < A.length ? A[minIdx] : -1;
	}
    
    public static int firstRepeating(int[] arr){
        HashSet<Integer> set = new HashSet<>();
        int res = -1;
        for(int i = arr.length-1; i>=0; i--){
            if(set.contains(arr[i]))
                res = arr[i];
            else
                set.add(arr[i]);
        }
        return res;
    }


}
