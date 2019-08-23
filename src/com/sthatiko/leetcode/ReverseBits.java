package com.sthatiko.leetcode;

//https://leetcode.com/problems/reverse-bits/

public class ReverseBits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for(int i=0;i<32;i++){
            int end = n&1;
            n>>=1;
            res = res << 1;
            res = res | end;
        }
        return res;
    }

    public static void main(String[] args) {
        ReverseBits s = new ReverseBits();
        int in = Integer.parseInt("-101",2);
        System.out.println(Integer.toBinaryString(in));
        int r = s.reverseBits(in);
        System.out.println(Integer.toBinaryString(r));
    }
}