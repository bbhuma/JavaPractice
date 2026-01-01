package com.scaler.JavaRefresherIntermediate.Sessionn17;
public class CountAtoGPairs {
    public static void main(String[] args) {
        String str = "acbagkaggag";

        int countG = 0;     // counts how many 'g's found so far (right side)
        int countAG = 0;    // total valid (a, g) pairs

        // Traverse from right to left
        for (int i = str.length() - 1; i >= 0; i--) {
            char c = str.charAt(i);
            if (c == 'g') {
                countG++; // Found a 'g', increment counter
            } else if (c == 'a') {
                countAG += countG; // Each 'a' can pair with all 'g's to its right
            }
        }

        System.out.println("Total (a, g) pairs where i < j: " + countAG);
    }
}
