package fib;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by emmanuel on 7/21/17.
 */
public class Fibonacci {
    public static long fib(long n){
        if(n < 2){
            return n;//return n when n < 2;
        }

        return fib(n-1) + fib(n-2);
    }

    //An optimised fibonacci function that runs faster and more efficiently
    public static long optimisedFib(int n, Map<Integer, Long> memo){

        if(memo.containsKey(n)){
            return memo.get(n);
        }

        if(n < 2){
            return n;
        }

        long f = optimisedFib(n-1, memo) + optimisedFib(n-2, memo);
        memo.put(n, f);

        return f ;
    }

    public static  void main(String[] args){
        long startTime = Calendar.getInstance().getTimeInMillis();
        System.out.println("With basic Fib:");
        System.out.println("Result: " + fib(10));
        long endTime = Calendar.getInstance().getTimeInMillis();
        System.out.println("Duration: " + (endTime - startTime));
        System.out.println();

        //With Optimised fib
        startTime = Calendar.getInstance().getTimeInMillis();
        System.out.println("With Optimised Fib:");
        System.out.println("Result: " + optimisedFib(10, new HashMap<>()));
        endTime = Calendar.getInstance().getTimeInMillis();
        System.out.println("Duration: " + (endTime - startTime));
    }
}
