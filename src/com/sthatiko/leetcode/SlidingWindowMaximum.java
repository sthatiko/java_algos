package com.sthatiko.leetcode;

import java.util.Arrays;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] input = new int[]{1,3,-1,-3,5,3,6,7};
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.maxSlidingWindow(input, 3)));
    }
    static class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int[] left_max = new int[nums.length];
            int[] right_max = new int[nums.length];
            for(int i=0;i<nums.length;i++){
                if(i%k == 0 ) left_max[i] = nums[i];
                else{
                    left_max[i] = Math.max(nums[i], left_max[i-1]);
                }
            }
            for(int i=nums.length-1;i>=0;i--){
                if((i+1)%k == 0 || i== nums.length - 1) right_max[i] = nums[i];
                else{
                    right_max[i] = Math.max(nums[i], right_max[i+1]);
                }
            }
            int[] result = new int[nums.length-k + 1 ];
            // for each window starting at i and ending at i+k-1
            for(int i= 0; i< result.length;i++){
                result[i] = Math.max(right_max[i], left_max[i+k-1]);
            }
            return result;
        }
    }
}
