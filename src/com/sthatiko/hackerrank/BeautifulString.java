package com.sthatiko.hackerrank;
//https://www.hackerrank.com/challenges/beautiful-binary-string/problem
public class BeautifulString {
    public static void main(String[] args) {
        System.out.println(beautifulBinaryString("0100101010"));
    }

    private static int beautifulBinaryString(String b) {
        int N = b.length();
        if(N <3 ) return 0;
        StringBuilder sb = new StringBuilder(b);
        int result = 0;
        for(int i = 2;i<N;i++){
            char l = sb.charAt(i - 2), m = sb.charAt(i - 1), r = sb.charAt(i);
            if(l=='0' && m=='1' && r=='0'){
                sb.setCharAt(i,'1');
                result++;
            }
        }
        return result;
    }
}
