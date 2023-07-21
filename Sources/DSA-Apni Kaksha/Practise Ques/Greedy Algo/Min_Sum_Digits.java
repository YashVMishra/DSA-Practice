//https://practice.geeksforgeeks.org/problems/min-sum-formed-by-digits3551/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

import java.util.Arrays;

public class Min_Sum_Digits {
    public static void main(String[] args) {
        int[] arr = { 5, 3, 0, 7, 4 };
        System.out.println(minSum(arr, arr.length));
        // System.out.println(Arrays.toString(arr));
    }

    public static long minSum(int arr[], int n) {
        // Your code goes here
        Arrays.sort(arr);

        long num1 = 0;
        long num2 = 0;

        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                num1 = (num1 * 10) + arr[i];
            }

            else {
                num2 = (num2 * 10) + arr[i];
            }
        }

        return (num1 + num2);
    }
}
