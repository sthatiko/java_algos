package com.sthatiko.util;

public class MathUtil {
    public static int gcd(int a, int b){
        if (a%b == 0) return b;
        return gcd(b,a%b);
    }

    public static void main(String[] args) {
        System.out.println(gcd(12,5));
    }
}
