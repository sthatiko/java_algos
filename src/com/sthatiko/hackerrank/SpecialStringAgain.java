package com.sthatiko.hackerrank;

// https://www.hackerrank.com/challenges/special-palindrome-again/problem
// bruteforce TLE

public class SpecialStringAgain {

    private static Boolean isSpecial(String s){
        int n = s.length() ;
        if(n==1) return true;
        for(int i=0,j=n-1;i<j;i++,j--){
            if(s.charAt(i) != s.charAt(j)){
                return false ;
            }
            else{
                if(i!=0 && s.charAt(i) != s.charAt(i-1)) return false;
            }
        }
        return true;
    }

    private static long substrCount(int n, String s) {
        int result = n;
        for(int size=2;size<=n;size++){
            for(int i=0;i<=n-size;i++){
                if(isSpecial(s.substring(i,i+size))) result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
	    System.out.println(substrCount(7,"abcbaba"));
    }
}
