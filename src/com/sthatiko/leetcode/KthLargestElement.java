package com.sthatiko.leetcode;

import java.util.PriorityQueue;

public class KthLargestElement {
    public static void main(String[] args) {

    }
    static class Solution{
        public int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            for(int num: nums){
                minHeap.offer(num);
                if(minHeap.size() > k){
                    minHeap.poll();
                }
            }
            return minHeap.poll();
        }
    }
}
