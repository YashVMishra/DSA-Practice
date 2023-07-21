/*
Problem Statement: You are given an array. The task is to reverse the array and print it. 

Examples:

Example 1:
Input: N = 5, arr[] = {5,4,3,2,1}
Output: {1,2,3,4,5}
Explanation: Since the order of elements gets reversed the first element will occupy the fifth 
position, the second element occupies the fourth position and so on.

Example 2:
Input: N=4 arr[] = {10,20,30,40}
Output: {40,30,20,10}
 */

import java.util.Arrays;

public class Reverse_Array {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        reverse(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void reverse(int[] arr) {
        int len = arr.length;

        for (int i = 0; i < len / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[len - 1 - i];
            arr[len - i - 1] = temp;
        }

    }
}
