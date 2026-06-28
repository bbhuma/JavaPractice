package com.java.JavaRefresherIntermediate.Sessionn36;

import java.util.*;

public class SlidingWindowPatterns {

    // 1️⃣ Maximum Sum Subarray of size K
    public static int maxSumSubarrayK(int[] arr, int k){

        int sum = 0;

        for(int i=0;i<k;i++)
            sum += arr[i];

        int max = sum;

        for(int i=k;i<arr.length;i++){
            sum += arr[i];
            sum -= arr[i-k];
            max = Math.max(max,sum);
        }

        return max;
    }


    // 2️⃣ First negative number in every window
    public static List<Integer> firstNegative(int[] arr,int k){

        List<Integer> result = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        int i=0,j=0;

        while(j<arr.length){

            if(arr[j] < 0)
                q.add(arr[j]);

            if(j-i+1 < k)
                j++;

            else{

                if(q.isEmpty())
                    result.add(0);
                else
                    result.add(q.peek());

                if(arr[i] < 0)
                    q.poll();

                i++;
                j++;
            }
        }

        return result;
    }


    // 3️⃣ Count occurrences of anagram
    public static int countAnagrams(String txt,String pat){

        HashMap<Character,Integer> map = new HashMap<>();

        for(char c:pat.toCharArray())
            map.put(c,map.getOrDefault(c,0)+1);

        int count = map.size();

        int i=0,j=0,ans=0;
        int k = pat.length();

        while(j<txt.length()){

            char c = txt.charAt(j);

            if(map.containsKey(c)){
                map.put(c,map.get(c)-1);
                if(map.get(c)==0)
                    count--;
            }

            if(j-i+1 < k)
                j++;

            else{

                if(count==0)
                    ans++;

                char left = txt.charAt(i);

                if(map.containsKey(left)){
                    map.put(left,map.get(left)+1);
                    if(map.get(left)==1)
                        count++;
                }

                i++;
                j++;
            }
        }

        return ans;
    }


    // 4️⃣ Maximum of all subarrays of size K
    public static List<Integer> maxOfSubarray(int[] arr,int k){

        List<Integer> res = new ArrayList<>();
        Deque<Integer> dq = new LinkedList<>();

        int i=0,j=0;

        while(j<arr.length){

            while(!dq.isEmpty() && dq.peekLast() < arr[j])
                dq.pollLast();

            dq.addLast(arr[j]);

            if(j-i+1 < k)
                j++;

            else{

                res.add(dq.peekFirst());

                if(arr[i] == dq.peekFirst())
                    dq.pollFirst();

                i++;
                j++;
            }
        }

        return res;
    }


    // 5️⃣ Longest substring without repeating characters
    public static int longestUniqueSubstring(String s){

        HashSet<Character> set = new HashSet<>();

        int i=0,j=0,max=0;

        while(j<s.length()){

            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                max = Math.max(max,j-i+1);
                j++;
            }
            else{
                set.remove(s.charAt(i));
                i++;
            }
        }

        return max;
    }


    // 6️⃣ Longest substring with K unique characters
    public static int longestSubstringKUnique(String s,int k){

        HashMap<Character,Integer> map = new HashMap<>();

        int i=0,j=0,max=0;

        while(j<s.length()){

            map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);

            if(map.size() < k)
                j++;

            else if(map.size() == k){
                max = Math.max(max,j-i+1);
                j++;
            }

            else{

                while(map.size() > k){

                    char c = s.charAt(i);

                    map.put(c,map.get(c)-1);

                    if(map.get(c)==0)
                        map.remove(c);

                    i++;
                }

                j++;
            }
        }

        return max;
    }


    // 7️⃣ Longest substring with no more than K distinct characters
    public static int longestSubstringAtMostK(String s,int k){

        HashMap<Character,Integer> map = new HashMap<>();

        int i=0,j=0,max=0;

        while(j<s.length()){

            map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);

            while(map.size() > k){

                char c = s.charAt(i);
                map.put(c,map.get(c)-1);

                if(map.get(c)==0)
                    map.remove(c);

                i++;
            }

            max = Math.max(max,j-i+1);
            j++;
        }

        return max;
    }


    // 8️⃣ Minimum window substring
    public static String minWindow(String s,String t){

        HashMap<Character,Integer> map = new HashMap<>();

        for(char c:t.toCharArray())
            map.put(c,map.getOrDefault(c,0)+1);

        int count = map.size();

        int i=0,j=0,start=0,len=Integer.MAX_VALUE;

        while(j<s.length()){

            char c = s.charAt(j);

            if(map.containsKey(c)){
                map.put(c,map.get(c)-1);
                if(map.get(c)==0)
                    count--;
            }

            while(count==0){

                if(j-i+1 < len){
                    len = j-i+1;
                    start = i;
                }

                char left = s.charAt(i);

                if(map.containsKey(left)){
                    map.put(left,map.get(left)+1);
                    if(map.get(left) > 0)
                        count++;
                }

                i++;
            }

            j++;
        }

        return len==Integer.MAX_VALUE ? "" : s.substring(start,start+len);
    }


    // 9️⃣ Longest repeating character replacement
    public static int characterReplacement(String s,int k){

        int[] freq = new int[26];

        int i=0,maxCount=0,maxLen=0;

        for(int j=0;j<s.length();j++){

            freq[s.charAt(j)-'A']++;

            maxCount = Math.max(maxCount,freq[s.charAt(j)-'A']);

            while((j-i+1)-maxCount > k){
                freq[s.charAt(i)-'A']--;
                i++;
            }

            maxLen = Math.max(maxLen,j-i+1);
        }

        return maxLen;
    }


    // 🔟 Max consecutive ones with K flips
    public static int longestOnes(int[] arr,int k){

        int i=0,zeros=0,max=0;

        for(int j=0;j<arr.length;j++){

            if(arr[j]==0)
                zeros++;

            while(zeros > k){
                if(arr[i]==0)
                    zeros--;
                i++;
            }

            max = Math.max(max,j-i+1);
        }

        return max;
    }


    public static void main(String[] args){

        int[] arr = {2,1,5,1,3,2};

        System.out.println("Max sum subarray size K:");
        System.out.println(maxSumSubarrayK(arr,3));

        System.out.println("First negative in window:");
        System.out.println(firstNegative(new int[]{12,-1,-7,8,-15,30,16,28},3));

        System.out.println("Longest unique substring:");
        System.out.println(longestUniqueSubstring("abcabcbb"));

        System.out.println("Longest substring with K unique:");
        System.out.println(longestSubstringKUnique("aabacbebebe",3));

        System.out.println("Longest at most K distinct:");
        System.out.println(longestSubstringAtMostK("eceba",2));
    }
}
