package com.sthatiko.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class KFrequentElements {
    public static void main(String[] args) {
        int[] input = new int[]{1,1,1,2,2,3};
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.topKFrequent(input, 2)));
    }

    static class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer,Integer> hm = new HashMap<>();
            for(int num: nums){
                hm.put(num,hm.getOrDefault(num,0) +1);
            }
            Map<Integer,Integer> sortedMap = new LinkedHashMap<>();
            hm.entrySet()
                    .stream()
                    .sorted((e1,e2) -> e2.getValue().compareTo(e1.getValue()))
                    .forEachOrdered(entry -> sortedMap.put(entry.getKey(), entry.getValue()));
            List<Integer> l = new ArrayList<>(sortedMap.keySet());
            return l.subList(0,k).stream().mapToInt( i->i ).toArray();
        }
    }
}
