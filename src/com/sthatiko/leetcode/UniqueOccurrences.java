package com.sthatiko.leetcode;

import java.util.*;
import java.util.stream.Collectors;

class UniqueOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> m = new HashMap<>();
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        list.forEach(k -> m.put(k,m.getOrDefault(k,0) + 1));
        list = new ArrayList<>(m.values());
        m.clear();
        for(Integer i: list)
            if(m.containsKey(i)) return false;
            else m.put(i,1);
        return true;
    }

    public static void main(String[] args) {
        UniqueOccurrences s = new UniqueOccurrences();
        System.out.println(s.uniqueOccurrences(new int[]{1,2}));
    }

}
