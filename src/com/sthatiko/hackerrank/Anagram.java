package com.sthatiko.hackerrank;

//https://orareview.us.oracle.com/79782800

public class Anagram {
    public static void main(String[] args) {
        /*
        aaabbb
        ab
        abc
        mnop
        xyyx
        xaxbbbxx
         */
        System.out.println(anagram("fdhlvosfpafhalll"));
    }

    static int anagram(String s) {
        int l = s.length();
        if(l%2 == 1) return -1;
        int result = 0;
        char[] chrs1 = s.substring(0,l/2).toCharArray(), chrs2 = s.substring(l/2).toCharArray();
        int[] counts = new int[26];
        for(char c :chrs1) counts[c - 'a']++;
        for(char c :chrs2) counts[c-'a']--;
        for(int val:counts) result += Math.abs(val);
        return result/2;
    }

}
