package com.scaler.JavaRefresherIntermediate.Matrixes;

public class Solution {
    public static void main(String[] args) {
        long n = 100000;
        long x= 1;
        int y= 100000;
        long[] arr = new long[y];
        //char[] ch = new char[y];
        boolean[] b = new boolean[y];
        double[] d = new double[y];
        float[] f = new float[y];   
        short[] s = new short[y];
        byte[] by = new byte[y];
        String[] str = new String[y];
        
        for(int i=0;i<y;i++){
            	arr[i]=i+1;
                System.err.println(arr[i]);
                        }
        for (long i = 0; i < n; i++) {
            for (long j = 0; j < n; j++) {
            	x=x+2;
            	System.out.println(x);
            	
            }
        }
        System.out.println("Done");
    }
}
