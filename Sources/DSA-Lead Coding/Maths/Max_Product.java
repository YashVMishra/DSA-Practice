//https://leetcode.com/problems/maximum-product-of-three-numbers/description/

import java.util.Arrays;

public class Max_Product {
    public static void main(String[] args) {
        System.out.println(maximumProduct(new int[] { -8, -7, -2, 10, 20 }));
    }

    public static int maximumProduct(int[] nums) {
        if (nums.length == 3) {
            return nums[0] * nums[1] * nums[2];
        }

        Arrays.sort(nums);
        int len = nums.length - 1;

        int first_two = nums[0] * nums[1];
        int last_two = nums[len] * nums[len - 1];

        if (first_two > 0) {
            return Math.max((nums[len] * nums[len - 1] * nums[len - 2]), first_two * nums[len]);
        }

        else {
            return Math.max((nums[len] * nums[len - 1] * nums[len - 2]), last_two * nums[len - 2]);
        }
    }
}
