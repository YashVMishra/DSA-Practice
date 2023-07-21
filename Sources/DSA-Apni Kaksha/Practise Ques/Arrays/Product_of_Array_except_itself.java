//https://leetcode.com/problems/product-of-array-except-self/

import java.util.Arrays;

public class Product_of_Array_except_itself {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[] { 7, 8, 6, 4, 6, 7, 3, 10, 2, 3, 8, 1, 10, 4, 7,
                1, 7, 3, 7, 2, 9, 8, 10, 3, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1 })));
        System.out.println(Arrays.toString(productExceptSelf_2(new int[] { 1, 2, 3, 4 })));
    }

    // using constant space
    public static long[] productExceptSelf(int[] nums) {
        int size = nums.length;

        long[] ans_arr = new long[size];
        // int[] left_arr=new int[size];
        // int[] right_arr=new int[size];
        long[] temp = new long[size];

        for (int i = 0; i < size; i++) {
            temp[i] = nums[i];
        }

        ans_arr[0] = 1;
        // right_arr[size-1]=1;

        for (int i = 1; i < size; i++) {
            ans_arr[i] = temp[i - 1] * ans_arr[i - 1];
        }

        long right_product = 1;
        for (int i = size - 1; i >= 0; i--) {
            ans_arr[i] = ans_arr[i] * right_product;
            right_product = right_product * temp[i];
        }

        return ans_arr;
    }

    // using extra space
    public static int[] productExceptSelf_2(int[] nums) {
        int size = nums.length;

        int[] ans_arr = new int[size];
        int[] left_arr = new int[size];
        int[] right_arr = new int[size];

        left_arr[0] = 1;
        right_arr[size - 1] = 1;

        for (int i = 1; i < size; i++) {
            left_arr[i] = nums[i - 1] * left_arr[i - 1];
        }

        for (int i = size - 2; i >= 0; i--) {
            right_arr[i] = nums[i + 1] * right_arr[i + 1];
        }

        // int right_product=1;
        for (int i = 0; i < size; i++) {
            ans_arr[i] = left_arr[i] * right_arr[i];
            // right_product=right_product*nums[i];
        }

        return ans_arr;
    }
}
