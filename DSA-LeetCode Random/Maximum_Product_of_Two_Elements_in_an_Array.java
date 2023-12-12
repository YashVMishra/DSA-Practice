// https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/description/?envType=daily-question&envId=2023-12-12

import java.util.Arrays;

public class Maximum_Product_of_Two_Elements_in_an_Array {
    public static void main(String[] args) {
        int[] nums = { 1, 5, 4, 5 };
        int result = maxProduct(nums);
        System.out.println(result);
    }

    // simple brute force.
    public static int maxProduct(int[] nums) {
        int maxProduct = 1;

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int product = (nums[i] - 1) * (nums[j] - 1);
                if (product > maxProduct) {
                    maxProduct = product;
                }
            }
        }

        return maxProduct;
    }

    // -----------------------------------------------------------------------------------

    public static int maxProduct_2(int[] nums) {
        Arrays.sort(nums);
        return (nums[nums.length - 1] - 1) * (nums[nums.length - 2] - 1);
    }
}