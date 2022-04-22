package com.sthatiko.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class KFrequentWords {
    public static void main(String[] args) {
        String[] input = new String[]{"i", "love", "leetcode", "i", "love", "coding"};
        Solution sol = new Solution();
        System.out.println(sol.topKFrequent(input, 2));
    }


    static class Solution {
        public List<String> topKFrequent(String[] words, int k) {

            List<String> result = new LinkedList<>();
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < words.length; i++) {
                if (map.containsKey(words[i]))
                    map.put(words[i], map.get(words[i]) + 1);
                else
                    map.put(words[i], 1);
            }

            PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                    (a, b) -> a.getValue() == b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue() - b.getValue()
            );

            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                pq.offer(entry);
                if (pq.size() > k)
                    pq.poll();
            }

            while (!pq.isEmpty())
                result.add(0, pq.poll().getKey());

            return result;
        }
    }
}


