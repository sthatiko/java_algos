package com.sthatiko.leetcode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConcatenatedWords {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.findAllConcatenatedWordsInADict(new String[]{}));
    }
    static class Solution {
        List<String> result = new ArrayList<>();
        public List<String> findAllConcatenatedWordsInADict(String[] words) {
            List<String> dict = Arrays.asList(words);
            dict.sort(Comparator.comparingInt(String::length));
            Set<String> preWords = new HashSet<>();
            int i =0;
            for(String word: dict){
                i++;
                if(wordBreak(word, preWords)) result.add(word);
                preWords.add(word);
            }
            return result;
        }

        public boolean wordBreak(String s, Set<String> wordDict) {// bottom up dp construction
            if(s.length() == 0) return false;
            boolean[] dp = new boolean[s.length()+1];// dp[i] is true if s.substring(0,i) is made of words from dict
            dp[0] = true;
            for(int i=1;i<=s.length();i++){
                for(int j=0;j<i;j++){// loop over all substrings ending at i , i excluded
                    if(s.substring(j,i).equals(s)) continue;
                    if(dp[j] && wordDict.contains(s.substring(j,i))  ){
                        dp[i] = true;
                        break;
                    }
                }
            }
            return dp[s.length()];
        }
    }
}
