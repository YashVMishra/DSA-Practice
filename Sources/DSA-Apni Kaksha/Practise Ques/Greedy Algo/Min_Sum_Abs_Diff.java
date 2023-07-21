//https://practice.geeksforgeeks.org/problems/minimum-sum-of-absolute-differences-of-pairs/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

import java.util.Arrays;

public class Min_Sum_Abs_Diff {
    public static void main(String[] args) {
        int[] A = { 4, 1, 8, 7 };
        int[] B = { 2, 3, 6, 5 };
        System.out.println(findMinSum(A, B, A.length));
    }

    public static long findMinSum(int[] A, int[] B, int N) {
        Arrays.sort(A);
        Arrays.sort(B);

        long sum = 0;
        for (int i = 0; i < N; i++) {
            sum += Math.abs(A[i] - B[i]);
        }

        return sum;
    }
}
