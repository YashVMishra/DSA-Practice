//https://leetcode.com/problems/maximum-sum-circular-subarray/s

public class Max_Sum_Circular_Subarray {
    public static void main(String[] args) {
        System.out.println(maxSubarraySumCircular(new int[] { 5, -3, 5 }));
    }

    public static int maxSubarraySumCircular(int[] nums) {

        // maintaining five variables
        // temp_min for temp min sum
        // temp_max for temp max sum
        // total_sum for total sum of th array
        // max_sum and min_sum for max sum and min sum
        // main part is when temp_min is greater than 0 make it zero
        // main part is whne the temp_max is less than 0 make it zero.
        int max_sum = Integer.MIN_VALUE;
        int curr_max_sum = 0;

        int total_sum = 0;

        int min_sum = Integer.MAX_VALUE;
        int curr_min_sum = 0;

        for (int i = 0; i < nums.length; i++) {
            curr_max_sum += nums[i];
            curr_min_sum += nums[i];

            total_sum += nums[i];

            max_sum = Math.max(max_sum, curr_max_sum);
            min_sum = Math.min(min_sum, curr_min_sum);

            // very important.
            if (curr_min_sum > 0) {
                curr_min_sum = 0;
            }

            // very important.
            if (curr_max_sum < 0) {
                curr_max_sum = 0;
            }
        }

        if (total_sum == min_sum) {
            return max_sum;
        }

        return Math.max(total_sum - min_sum, max_sum);
    }
}
