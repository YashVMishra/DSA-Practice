// https://leetcode.com/problems/product-of-array-except-self/description/?envType=study-plan-v2&envId=leetcode-75

import java.util.Arrays;

public class Product_of_Array_Except_Self {
    public static void main(String[] args) {
        int[] nums = { -1, 1, 0, -3, 3 };
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }

    // maintain two arrays, left and right.
    // left keeps the product of all the elements to the left of the current
    // element and same with right.
    public static int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        left[0] = 1;
        right[nums.length - 1] = 1;

        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        for (int i = nums.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < nums.length; i++) {
            ans[i] = left[i] * right[i];
        }

        return ans;
    }

    // just remove the right array and use a variable instead.
    public static int[] productExceptSelf_2(int[] nums) {
        int[] ans = new int[nums.length];
        int[] left = new int[nums.length];
        left[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            ans[i] = left[i] * right;
            right *= nums[i];
        }

        return ans;
    }

    // just consider the array that have to be returned as the
    // left array and use a variable instead of the right array.
    public static int[] productExceptSelf_3(int[] nums) {
        int[] ans = new int[nums.length];
        ans[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }

        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            ans[i] = ans[i] * right;
            right *= nums[i];
        }

        return ans;
    }
}
