/*
Problem Statement: Rearrange the array such that the first half is arranged in increasing order, 
and the second half is arranged in decreasing order

Examples:

Example 1:
Input: 8 7 1 6 5 9
Output: 1 5 6 9 8 7
Explanation: First three elements are in the ascending order and next three elements are in the 
descending order.

Example 2:
Input: 4 2 8 6 15 5 9 20
Output: 2 4 5 6 20 15 9 8
 */

import java.util.Arrays;

public class Inc_Dec_Array {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        inc_dec(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void inc_dec(int[] arr) {
        Arrays.sort(arr);
        int len = arr.length;
        int start = len / 2;
        int end = len - 1;

        // important as how to reverse half of an array.
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            end--;
            start++;
        }
    }
}
