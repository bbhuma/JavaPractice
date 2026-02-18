package com.java.JavaRefresherIntermediate.Sessionn29;

public class AddOneToNumberofArray {

	public static void main(String[] args) {
		int[] arr1 = { 1, 2, 9 };
		int[] arr2 = { 1, 9, 9 };
		int[] arr = { 9, 9, 9 };
		arr = addOneToNumberofArray(arr);
		for (int x : arr) {
			System.out.print(x + " ");
		}
	}

	public static int[] addOneToNumberofArray(int[] arr) {
	    int n = arr.length;
	    for (int i = n - 1; i >= 0; i--) {
	        if (arr[i] < 9) {
	            arr[i]++;     // add 1
	            return arr;   // stop immediately
	        }
	        arr[i] = 0;       // if 9, make it 0 and continue
	    }
	    // If loop finishes completely
	    // → means all digits were 9
	    int[] newArr = new int[n + 1];
	    newArr[0] = 1;
	    return newArr;
	}

	public static int[] addOneToNumberofArrayPrctice(int[] arr) {
		int n = arr.length;
		boolean flag = true;
		int[] newArr = new int[n + 1];
		for (int x : arr) {
			if (x != 9) {
				flag = false; // if any one digit is not 9, then flag = false
			}
		}
		if (flag) {
			newArr[0] = 1;
		}
		for (int i = n - 1; i >= 0; i--) {
			if (arr[i] < 9) {
				arr[i] = arr[i] + 1; // add one if digit is less than 9, this is a carry forward as well
				break;
			} else {
				arr[i] = 0; // if digit =9 , make it 0, carry will any how be added in above if
				continue;
			}
		}
		return flag ? newArr : arr;
	}

}
