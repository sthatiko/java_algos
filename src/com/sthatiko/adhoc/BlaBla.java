package com.sthatiko.adhoc;

public class BlaBla {
    public static void main(String[] args) {
        System.out.println(fibonacci(5));
    }
    // 1, 1, 2, 3, 5, 8
    private static int fibonacci(int n){
        int fib1=1, fib2 =1, fib3 = 0 ;
        if(n == 1 || n == 2) return 1;
        for(int i=3;i<=n;i++){
            fib3 = fib2 + fib1;
            fib1 = fib2;
            fib2 = fib3;
        }
        return fib3;
    }
}
