
//https://practice.geeksforgeeks.org/problems/permutations-in-array1747/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

import java.util.Arrays;

public class Permutations_In_Array {
    public static void main(String[] args) {
        long a[] = { 2, 1, 3 };
        long b[] = { 7, 8, 9 };

        System.out.println(isPossible(a, b, a.length, 10));
    }

    public static boolean isPossible(long a[], long b[], int n, long k) {
        // Your code goes here

        Arrays.sort(a);
        Arrays.sort(b);

        if (a[a.length - 1] + b[b.length - 1] >= k) {
            return true;
        }

        return false;
    }
}