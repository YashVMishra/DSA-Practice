/*
WAP to print the nth fibonacci number.
*/

import java.util.Scanner;

public class Fibonacci_Series {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the nth number you want from the fibonacci series");
        int n=sc.nextInt();
        // Did n-1 coz the code that we have written will print 1 when n=1.
        System.out.println(fib(n-1));
        sc.close();
        // series starting from 0,1,1,2,3,5,8,13....
    }
     static int fib(int n){
        if(n<=1){
            return n;
        }
        return fib(n-1) + fib(n-2);
     }
}
