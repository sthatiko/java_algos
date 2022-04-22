package com.sthatiko.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        Solution s = new Solution();
        String result = s.minWindow("ADOBECODEBANC","ABC");
        System.out.println(result);
    }
}

class Solution {
    public String minWindow(String s, String t) {
        int[] charMap = new int[122];
        for(char c: t.toCharArray()){
            charMap[c]++;
        }
        int start =0, end = 0, minLen = Integer.MAX_VALUE, counter = t.length(), minStart = 0;
        while(end < s.length()){
            char rc = s.charAt(end);
            if(charMap[rc] > 0) counter--;
            charMap[rc]--;// a negative value indicates we found a char that is not needed
            end++;
            while(counter ==0){
                // counter is 0 indicates that we have found some substring that has all chars in t.
                // So move start to right to decrease window size
                if(minLen > end - start ){
                    minLen = end - start;
                    minStart = start;
                }
                char lc = s.charAt(start);
                if(charMap[lc]>=0)counter++;
                charMap[lc]++;
                start++;
            }
        }
        return minLen == Integer.MAX_VALUE?"":s.substring(minStart, minStart+minLen);
    }

    private boolean contains(String s, String t){
        if(s.length() < t.length()) return false;
        Map<Character, Integer> needed = new HashMap<>();
        for(char c: t.toCharArray()){
            needed.put(c,needed.getOrDefault(c,0) + 1);
        }
        for(Character c: s.toCharArray()){
            needed.put(c, needed.getOrDefault(c,0) - 1);
        }
        for(Integer v: needed.values()){
            if(v>0)
                return false;
        }
        return true;
    }
}
