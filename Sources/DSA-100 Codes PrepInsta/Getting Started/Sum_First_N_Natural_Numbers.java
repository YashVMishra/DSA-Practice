//https://prepinsta.com/java-program/program-to-find-the-sum-of-first-n-natural-numbers-in-java/

// Given an integer input of N, the objective is to find the sum of all the natural numbers until 
// the given input integer. To do so we can use different approaches to write the Java code and some 
// such methods are mentioned below,

public class Sum_First_N_Natural_Numbers {
    public static void main(String[] args) {
        int num = 10;
        System.out.println(sum(num));
        System.out.println(sum_2(num));
        System.out.println(sum_3(1, num));
        System.out.println(sum_4(num));
    }

    // using loop.
    public static long sum(int num) {
        long result = 0;

        for (int i = 1; i <= num; i++) {
            result += i;
        }

        return result;
    }

    // using formula.
    public static long sum_2(int num) {
        long result = (num * (num + 1)) / 2;

        return result;
    }

    // using recursion.
    public static long sum_3(int num, int count) {
        if (num == count) {
            return num;
        }

        long result = num + sum_3(num + 1, count);

        return result;
    }

    // using recurison
    public static long sum_4(int num) {
        if (num == 0) {
            return num;
        }

        long result = num + sum_4(num - 1);

        return result;
    }
}
