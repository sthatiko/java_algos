package com.sthatiko.leetcode.strings;

public class AddStrings {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.addStrings("456","77"));
    }

    static class Solution {
        public String addStrings(String num1, String num2) {
            char[] nums1 = num1.toCharArray();
            char[] nums2 = num2.toCharArray();
            StringBuilder stack = new StringBuilder();
            int i,j,c = 0;
            for( i=nums1.length-1,j=nums2.length-1;i>=0&&j>=0;i--,j--){
                int x = nums1[i] - '0';
                int y = nums2[j] - '0';
                stack.append((c+x+y)%10);
                c=(c+x+y)/10;
            }
            if(j<0){
                while(i>=0){
                    int x = nums1[i] - '0';
                    stack.append((c+x)%10);
                    c=(c+x)/10;
                    i--;
                }
            }else{
                while(j>=0){
                    int x = nums2[j] - '0';
                    stack.append((c+x)%10);
                    c=(c+x)/10;
                    j--;
                }
            }
            if(c!=0) stack.append(c);
            return stack.reverse().toString();
        }
    }
}
