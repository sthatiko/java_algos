package com.sthatiko.leetcode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak2 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.wordBreak("catsanddog", Arrays.asList("cat","cats","and","sand","dog")));
    }
    static class Solution {
        Map<String,List<String>> memo = new HashMap<>();
        public List<String> wordBreak(String s, List<String> wordDict) {
            List<String> result = new ArrayList<>();
            if(s == null || s.length() == 0) return result;
            if(memo.containsKey(s)) return memo.get(s);
            if(wordDict.contains(s)) result.add(s); // don't return here. ex: hotdog, hot and dog could be in dict, so we should return [hotdog, hot dog]

            for(int i=0;i<s.length();i++){
                String left = s.substring(i);
                if(wordDict.contains(left)){
                    List<String> res = wordBreak(s.substring(0,i), wordDict);
                    if(res.size() >0){
                        for(String r: res){
                            result.add(left + " " + r);
                        }
                    }
                }
            }
            memo.put(s,result);
            return result;
        }
    }
}
