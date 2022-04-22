package com.sthatiko.leetcode;

//https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class RemoveParantheses {
    public static void main(String[] args) {

        myTest();
        Solution sol = new Solution();
        int nodeCount = 8;
        double asmOverHeadTotalInGbs = 200 + 50 * nodeCount * 16;
        double asmOverHeadTotalInTbs = BigDecimal.valueOf(asmOverHeadTotalInGbs/1024).setScale(3,BigDecimal.ROUND_HALF_UP).doubleValue();
        double dataPercentage = 0.4;
        double actualExadataStorageNeeded = BigDecimal.valueOf((232 + asmOverHeadTotalInTbs)/dataPercentage).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println( actualExadataStorageNeeded);
        System.out.println(1/3);
        System.out.println(BigDecimal.valueOf(6600.239137/1024.431121).setScale(10,BigDecimal.ROUND_FLOOR).doubleValue());
        System.out.println(BigDecimal.valueOf(6600.239137).divide(BigDecimal.valueOf(1024.431121), 10, BigDecimal.ROUND_FLOOR).doubleValue());
        System.out.println(BigDecimal.valueOf(1.2346).setScale(3,BigDecimal.ROUND_UP).doubleValue());
        System.out.println(BigDecimal.valueOf(1.2346).setScale(3,BigDecimal.ROUND_HALF_DOWN).doubleValue());
        System.out.println(BigDecimal.valueOf(1.2346).setScale(3,BigDecimal.ROUND_FLOOR).doubleValue());

    }

    static void myTest(){
        System.out.println("a.b.c.d".split("\\.")[1]);
        Map<String,Integer> m = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        m.put("ONE", 1);
        m.put("one",2);
        System.out.println(m.containsKey("OnE"));
    }

    private static List<Float> getProvisionableList(Float cpuCoreCount) {
        if(cpuCoreCount==null || cpuCoreCount==0) {
            return new ArrayList<>();
        }

        BigDecimal cpuCoreCountMax = BigDecimal.valueOf(cpuCoreCount).setScale(2, BigDecimal.ROUND_UP);

        List<Float> list = new ArrayList<>();

        // increment by 0.1 to get next provisionable value
        BigDecimal diff = BigDecimal.valueOf(0.1).setScale(2, BigDecimal.ROUND_DOWN);
        // initial value i.e 0.1
        BigDecimal cpuCoreCountValue = BigDecimal.valueOf(0.1).setScale(2, BigDecimal.ROUND_DOWN);
        for(; cpuCoreCountValue.doubleValue()<=cpuCoreCountMax.doubleValue(); cpuCoreCountValue=cpuCoreCountValue.add(diff)) {
            list.add(cpuCoreCountValue.floatValue());
        }

        return list;

    }
    static class Solution {
        public String minRemoveToMakeValid(String s) {
            if(s==null || s.length() == 0) return "";
            char[] input = s.toCharArray();
            StringBuilder sb = new StringBuilder(s);
            Stack<Integer> stack = new Stack<>();
            //List<Integer> orphaned = new ArrayList<>(); use stack instead, save negative index to indicate )
            for(int i=0;i<input.length; i++){
                char c = input[i];
                if(c=='(') stack.push(i);
                else if(c==')'){
                    if(!stack.isEmpty() && stack.peek()>=0) stack.pop();// implies stack has ( at top
                    else stack.push(-i);// else stack is empty or has ) at top
                }
            }
            while(!stack.isEmpty()) // stack will have indices in increasing order
                sb.deleteCharAt(Math.abs(stack.pop()));
            return sb.toString();
        }
    }
}
