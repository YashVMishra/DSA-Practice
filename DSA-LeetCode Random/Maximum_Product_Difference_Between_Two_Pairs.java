// https://leetcode.com/problems/maximum-product-difference-between-two-pairs/description/?envType=daily-question&envId=2023-12-18

import java.util.Arrays;

public class Maximum_Product_Difference_Between_Two_Pairs {
    public static void main(String[] args) {
        int[] nums = { 5, 6, 2, 7, 4 };
        System.out.println(maxProductDifference(nums));
    }

    // with sorting
    public static int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length - 1] * nums[nums.length - 2] - nums[0] * nums[1];
    }

    // --------------------------------------------------------------------------------------//

    // without sorting
    public static int maxProductDifference_2(int[] nums) {
        int largest = Integer.MIN_VALUE, secondLargest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE, secondSmallest = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest) {
                secondLargest = num;
            }

            if (num < smallest) {
                secondSmallest = smallest;
                smallest = num;
            } else if (num < secondSmallest) {
                secondSmallest = num;
            }
        }

        return largest * secondLargest - smallest * secondSmallest;
    }
}
