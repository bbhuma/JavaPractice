package com.scaler.JavaRefresherIntermediate.Sessionn10.StringsHashing;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {

		int n = 1000000;
		int x = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				// Just wasting time
				x++;
			}
		}
		System.out.println("Done");
	}

	public static String stringOperations(String str) {
		StringBuilder sb = new StringBuilder();
		char[] charArray = str.toCharArray();
		boolean repeated = true;
		for (int i = 0; i < charArray.length; i++) {
			for (int j = i + 1; j < charArray.length; j++) {
				if (charArray[i] == charArray[j])
					repeated = true;
			}
			if (!repeated)
				sb.append(charArray[i]);
		}
		// str.chars().distinct().forEach(c-> sb.append((char)c));

		// using read char, find index of char, if index =-1 add to sb.
		for (int i = 0; i < str.length(); i++) {
			char charAt = str.charAt(i);
			int index = str.indexOf(charAt);
			if (index == -1) {
				sb.append(charAt);
			}
		}
		return sb.toString();

	}

	public static String reversestr(String str) {

		StringBuilder sb = new StringBuilder();
		// str.chars().forEach( c-> );
		for (int i = str.length() - 1; i >= 0; i++) {
			sb.append(str.charAt(i));
		}
		return sb.toString();
	}

	public static String[] reversestrArray(String[] strArr) {
		// StringBuilder[] sbArr = new StringBuilder[strArr.length];
		// str.chars().forEach( c-> );
		for (int i = 0; i < strArr.length; i++) {
			String reversestr = reversestr(strArr[i]);
			strArr[i] = reversestr;
		}
		return strArr;
	}

	public static void printstrArray(String[] strArr) {
		int[] arr = {1,2,3,4,4};
		Arrays.stream(arr).distinct().forEach(System.out::println);
		
		
		
		for (int i=0; i<strArr.length ; i++) {
			System.out.print(strArr[i]+ " ");
		}
		Arrays.stream(strArr)
		.map(str -> new StringBuilder().reverse().toString())
		//.forEach(str -> System.out.println(str+" "));
		.forEach(System.out::print);
		
		Arrays.stream(strArr)
				.filter(str -> !str.isBlank())
				.map(str-> new StringBuilder().reverse().toString())
				.sorted()
				.distinct()
				.forEach(str -> System.out.println(str + " "));
		
		//Arrays.str
		
		
	}

}