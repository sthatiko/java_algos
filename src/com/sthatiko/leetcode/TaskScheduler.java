package com.sthatiko.leetcode;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
//https://leetcode.com/problems/task-scheduler/
public class TaskScheduler {
    public static void main(String[] args) {
        Solution sol = new Solution();
        BigDecimal bd = new BigDecimal(2300/1024, new MathContext(3, RoundingMode.DOWN));
        //BigDecimal g = BigDecimal.valueOf(2300/1024,3,)
        System.out.println(BigDecimal.valueOf(2177d/1024).setScale(3,BigDecimal.ROUND_DOWN).doubleValue());
        System.out.println(sol.leastInterval(new char[]{'A','A','A','B','B','B'}, 2));
    }

    static class Solution {
        public int leastInterval(char[] tasks, int n) {
            if(n==0) return tasks.length;
            if(tasks.length == 0) return 0;
            int result = 0;
            Map<Character,Integer> hm = new HashMap<>();
            for(char task: tasks){
                hm.put(task,hm.getOrDefault(task,0) +1);
            }
            List<TaskFrequency> list = hm.entrySet().stream().map(e->new TaskFrequency(e.getKey(), e.getValue())).collect(Collectors.toList());
            PriorityQueue<TaskFrequency> heap = new PriorityQueue<>(list);

            while(!heap.isEmpty()){
                int k = n+1;//every n+1 element can be same. so of n=2, A B C A
                list = new ArrayList<>();
                while( k>0 && !heap.isEmpty()){ // condition 1
                    TaskFrequency tf = heap.poll();
                    tf.count--;
                    list.add(tf);
                    result++;
                    k--;
                }
                for(TaskFrequency tf: list){
                    if(tf.count>0)heap.offer(tf); // add back valid tasks
                }
                if(heap.isEmpty()) break;// all tasks have been scheduled, else below
                result+=k;// we reached here it means condition 1 failed.  if it failed because of heap being empty it
                // means that we still have k >0, so cpu need to be idle that many times for cooling period
            }
            return result;
        }
    }

    static class TaskFrequency implements Comparable<TaskFrequency>{
        int count;
        char letter;
        public TaskFrequency(char letter, int count){
            this.count = count;
            this.letter = letter;
        }

        @Override
        public int compareTo(TaskFrequency o) {
            return Integer.compare(o.count,count);
        }
    }
}
