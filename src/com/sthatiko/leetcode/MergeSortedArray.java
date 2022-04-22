package com.sthatiko.leetcode;

import java.util.Arrays;
//https://leetcode.com/problems/merge-sorted-array/submissions/

// solve from the end
public class MergeSortedArray {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        sol.merge(nums1,3,nums2,3);
        System.out.println(Arrays.toString(nums1));
    }

    static class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int k = m+n-1, i = m-1, j = n-1;
            while(i>=0 && j>=0){
                if(nums1[i]>= nums2[j]){
                    nums1[k]=nums1[i];
                    i--;
                }else{
                    nums1[k]=nums2[j];
                    j--;
                }
                k--;
            }
            if(i<0){// nums1 elements are all done, copy nums2 to nums1
                while(j>=0){
                    nums1[k]=nums2[j];
                    j--;
                    k--;
                }
            }
        }
        public void merge1(int[] nums1, int m, int[] nums2, int n) {
            int[] result = new int[m+n];
            int i=0, j=0, k=0;
            while(i<m && j<n){
                if(nums1[i] <= nums2[j]){
                    result[k] = nums1[i];
                    i++;
                }else{
                    result[k] = nums2[j];
                    j++;
                }
                k++;
            }
            if(i==m){
                while(j<n){
                    result[k] = nums2[j];
                    j++;
                    k++;
                }
            }else{
                while(i<m){
                    result[k] = nums1[i];
                    i++;
                    k++;
                }
            }
            System.arraycopy(result,0, nums1, 0, m+n);
        }
    }
}


