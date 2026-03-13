package com.java.JavaRefresherIntermediate.Sessionn36;

import java.util.*;

public class PrefixSumPatterns {

    // 1️⃣ Subarray with given sum K (return subarray)
    public static int[] subarrayWithSumK(int[] arr, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int prefix = 0;
        map.put(0,-1);

        for(int i=0;i<arr.length;i++){
            prefix += arr[i];

            if(map.containsKey(prefix-k)){
                int start = map.get(prefix-k)+1;
                return Arrays.copyOfRange(arr,start,i+1);
            }

            map.put(prefix,i);
        }

        return new int[]{-1};
    }

    // 2️⃣ Count subarrays with sum K
    public static int countSubarraySumK(int[] arr,int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);

        int prefix=0;
        int count=0;

        for(int num:arr){
            prefix += num;

            if(map.containsKey(prefix-k))
                count += map.get(prefix-k);

            map.put(prefix,map.getOrDefault(prefix,0)+1);
        }

        return count;
    }

    // 3️⃣ Longest subarray with sum K
    public static int longestSubarraySumK(int[] arr,int k){

        HashMap<Integer,Integer> map = new HashMap<>();
        int prefix=0;
        int maxLen=0;

        for(int i=0;i<arr.length;i++){

            prefix += arr[i];

            if(prefix==k)
                maxLen = i+1;

            if(map.containsKey(prefix-k))
                maxLen = Math.max(maxLen,i-map.get(prefix-k));

            map.putIfAbsent(prefix,i);
        }

        return maxLen;
    }

    // 4️⃣ Subarray with sum 0
    public static boolean subarraySumZero(int[] arr){

        HashSet<Integer> set = new HashSet<>();
        int prefix=0;

        for(int num:arr){
            prefix += num;

            if(prefix==0 || set.contains(prefix))
                return true;

            set.add(prefix);
        }

        return false;
    }

    // 5️⃣ Longest subarray with sum 0
    public static int longestSubarrayZeroSum(int[] arr){

        HashMap<Integer,Integer> map = new HashMap<>();
        int prefix=0;
        int max=0;

        map.put(0,-1);

        for(int i=0;i<arr.length;i++){

            prefix += arr[i];

            if(map.containsKey(prefix))
                max = Math.max(max,i-map.get(prefix));
            else
                map.put(prefix,i);
        }

        return max;
    }

    // 6️⃣ Count subarrays with sum 0
    public static int countSubarrayZeroSum(int[] arr){

        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);

        int prefix=0;
        int count=0;

        for(int num:arr){
            prefix += num;

            count += map.getOrDefault(prefix,0);

            map.put(prefix,map.getOrDefault(prefix,0)+1);
        }

        return count;
    }

    // 7️⃣ Longest subarray with equal 0s and 1s
    public static int longestEqualZeroOne(int[] arr){

        HashMap<Integer,Integer> map = new HashMap<>();
        int prefix=0;
        int max=0;

        map.put(0,-1);

        for(int i=0;i<arr.length;i++){

            int val = arr[i]==0 ? -1 : 1;
            prefix += val;

            if(map.containsKey(prefix))
                max = Math.max(max,i-map.get(prefix));
            else
                map.put(prefix,i);
        }

        return max;
    }

    // 8️⃣ Count subarrays with equal 0s and 1s
    public static int countEqualZeroOne(int[] arr){

        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);

        int prefix=0;
        int count=0;

        for(int num:arr){

            int val = num==0 ? -1 : 1;
            prefix += val;

            count += map.getOrDefault(prefix,0);

            map.put(prefix,map.getOrDefault(prefix,0)+1);
        }

        return count;
    }

    // 9️⃣ Count subarrays divisible by K
    public static int countSubarrayDivisibleByK(int[] arr,int k){

        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);

        int prefix=0;
        int count=0;

        for(int num:arr){

            prefix += num;

            int mod = prefix % k;

            if(mod<0)
                mod += k;

            count += map.getOrDefault(mod,0);

            map.put(mod,map.getOrDefault(mod,0)+1);
        }

        return count;
    }

    // 🔟 Longest subarray divisible by K
    public static int longestSubarrayDivisibleByK(int[] arr,int k){

        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);

        int prefix=0;
        int max=0;

        for(int i=0;i<arr.length;i++){

            prefix += arr[i];

            int mod = prefix % k;

            if(mod<0)
                mod += k;

            if(map.containsKey(mod))
                max = Math.max(max,i-map.get(mod));
            else
                map.put(mod,i);
        }

        return max;
    }


    public static void main(String[] args) {

        int[] arr = {1,2,3,-2,5};

        System.out.println("Subarray with sum K:");
        System.out.println(Arrays.toString(subarrayWithSumK(arr,6)));

        System.out.println("Count subarray sum K:");
        System.out.println(countSubarraySumK(arr,6));

        System.out.println("Longest subarray sum K:");
        System.out.println(longestSubarraySumK(arr,6));

        System.out.println("Subarray sum zero exists:");
        System.out.println(subarraySumZero(arr));

        System.out.println("Longest zero sum:");
        System.out.println(longestSubarrayZeroSum(arr));

        System.out.println("Count zero sum:");
        System.out.println(countSubarrayZeroSum(arr));
    }
}