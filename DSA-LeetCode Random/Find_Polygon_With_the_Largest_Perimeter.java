// https://leetcode.com/problems/find-polygon-with-the-largest-perimeter/description/?envType=daily-question&envId=2024-02-15

import java.util.Arrays;

public class Find_Polygon_With_the_Largest_Perimeter {
    public static void main(String[] args) {
        int[] nums = { 1, 12, 1, 2, 5, 50, 3 };
        long result = largestPerimeter(nums);

        System.out.println(result);
    }

    public static long largestPerimeter(int[] nums) {
        Arrays.sort(nums);

        for (int i = nums.length - 1; i >= 2; i--) {
            if (nums[i] < sum(nums, 0, i - 1)) {
                return nums[i] + sum(nums, 0, i - 1);
            }
        }

        return -1;
    }

    public static long sum(int[] nums, int start, int end) {
        long sum = 0;

        for (int i = start; i <= end; i++) {
            sum += nums[i];
        }

        return sum;
    }
}
