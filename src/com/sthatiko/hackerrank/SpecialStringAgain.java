package com.sthatiko.hackerrank;

// https://www.hackerrank.com/challenges/special-palindrome-again/problem
// bruteforce TLE

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class SpecialStringAgain {

    private static class Tuple{
        Character chr;
        Integer count;

        private Tuple(Character chr, Integer count){
            this.chr = chr;
            this.count = count;
        }
    }

    private static long substrCount(int n, String s) {
        int result = 0;
        ArrayList<Tuple> counts = new ArrayList<>();
        char prev = ' ' ;
        int count = 0;
        // first pass: get all consecutively same letters and their count
        for(int i=0;i<n;i++){
            char c = s.charAt(i);
            if(c == prev){
                count++ ;
            }else{
                if(prev != ' '){
                    counts.add(new Tuple(prev,count));
                }
                count = 1;
                prev = c ;
            }
        }
        counts.add(new Tuple(prev,count));
        // get count of all special substring formed by those consecutive same letters "aaaa" , lenght = 4, res = 4*(4+1)/2 = 10
        for(Tuple t :counts){
            result += (t.count*(t.count+1))/2;
        }
        //calculate results for 2nd case like aaaabaaaa
        int g = counts.size();
        for(int i=1;i<g-1;i++){
            if(counts.get(i-1).chr == counts.get(i+1).chr && counts.get(i).count ==1){
                result += Math.min(counts.get(i-1).count,counts.get(i+1).count);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String tc = "asasd";
	    System.out.println(substrCount(tc.length(),tc));
    }
}
