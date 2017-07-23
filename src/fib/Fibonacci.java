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

    static Map<Long, Long> memo = new HashMap<>();


    //An optimised fibonacci function that runs faster and more efficiently
    public static long optimisedFib(long n){

        if(memo.containsKey(n)){
            return memo.get(n);
        }

        if(n < 2){
            memo.put(n, n);
            return n;
        }

        long f = optimisedFib(n-1) + optimisedFib(n-2);
        memo.put(n, f);

        return f ;

    }

    public static  void main(String[] args){
        long startTime = Calendar.getInstance().getTimeInMillis();
        System.out.printf("%,12d%n", optimisedFib(10));
        long endTime = Calendar.getInstance().getTimeInMillis();

        System.out.println("Duration: " + (endTime - startTime));
    }



}
