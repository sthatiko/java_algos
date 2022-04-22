package com.sthatiko.leetcode.strings;

import java.util.HashMap;
import java.util.Map;
// https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class LongestSubstring {

    public static void main(String[] args) {
        LongestSubstring ls = new LongestSubstring();
        System.out.println(ls.lengthOfLongestSubstring("au"));
    }

    public int lengthOfLongestSubstring(String s) { // Sliding window
        if(s.length() == 0 || s.length() ==1) return s.length();
        Map<Character, Integer> hm = new HashMap<>();
        char[] str = s.toCharArray();
        hm.put(str[0], 0);
        int result = 1, left = 0, right = 1;
        while(right< s.length()){
            if(!hm.containsKey(str[right]) || hm.get(str[right])< left) {
                hm.put(str[right], right);
                right++;
            }
            else{ // we found a char that is already present between left and right
                result = Math.max(result,right-left);
                left = hm.get(str[right])+1;
                hm.put(str[right],right);
                right++;
            }
        }
        return Math.max(result, right-left);
    }
}
