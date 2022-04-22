package com.sthatiko.leetcode.dp;

import java.util.Arrays;
import java.util.List;

public class WordBreak {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.wordBreak("applepenapple", Arrays.asList("apple", "pen")));
    }

    static class Solution {
        // recursion optimized with memoization
        List<String> dict;
        int[] dpArr ;  // dpArr[i] is true if s.substring(i,s.length()) is made of words from dict
        String s;

        public boolean wordBreak(String s, List<String> wordDict) {// bottom up dp construction

            boolean[] dp = new boolean[s.length()+1];// dp[i] is true if s.substring(0,i) is made of words from dict
            dp[0] = true;
            for(int i=1;i<=s.length();i++){
                for(int j=0;j<i;j++){// loop over all substrings ending at i , i excluded
                    if(dp[j] && wordDict.contains(s.substring(j,i))  ){
                        dp[i] = true;
                        break;
                    }
                }
            }
            return dp[s.length()];
        }
        public boolean wordBreak2(String s, List<String> wordDict) {
            this.dict = wordDict;
            this.dpArr = new int[s.length()+1];
            this.s = s;
            return helper(0);
        }

        public boolean helper(int start){// -1 false, 1 true, 0 not processed yet
            int end = this.s.length();
            if(this.dict.contains(this.s.substring(start,end)))
                return true;
            if(this.dpArr[start] !=0)
                return this.dpArr[start] != -1;
            for(int i=start+1;i<s.length();i++){
                String left = this.s.substring(start,i);
                if(this.dict.contains(left) && helper(i)) {
                    this.dpArr[start]=1;
                    return true;
                }
            }
            this.dpArr[start]= -1;
            return false;
        }
    }
}
