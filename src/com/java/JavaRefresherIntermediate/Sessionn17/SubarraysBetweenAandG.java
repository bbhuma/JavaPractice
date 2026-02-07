package com.scaler.JavaRefresherIntermediate.Sessionn17;

import java.util.ArrayList;
import java.util.List;

public class SubarraysBetweenAandG {
    public static void main(String[] args) {
        String str = "acbagkaggag";
        List<String> substrings = new ArrayList<>();

        // For every 'a', find all 'g' after it
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a') {
                for (int j = i + 1; j < str.length(); j++) {
                    if (str.charAt(j) == 'g') {
                        substrings.add(str.substring(i, j + 1));
                    }
                }
            }
        }

        // Convert to 2D array
        String[][] result = new String[substrings.size()][1];
        for (int i = 0; i < substrings.size(); i++) {
            result[i][0] = substrings.get(i);
        }

        // Print all substrings
        System.out.println("All substrings between 'a' and 'g':");
        for (String[] arr : result) {
            System.out.println(arr[0]);
        }

        // Print count
        System.out.println("\nTotal count: " + substrings.size());
    }
}
