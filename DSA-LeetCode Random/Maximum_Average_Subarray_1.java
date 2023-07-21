//https://leetcode.com/problems/maximum-average-subarray-i/description/?envType=study-plan-v2&id=leetcode-75

public class Maximum_Average_Subarray_1 {
    public static void main(String[] args) {
        int[] nums = { -1 };
        int k = 1;
        System.out.println(findMaxAverage(nums, k));
        System.out.println(findMaxAverage_2(nums, k));
    }

    // shows TLE.
    public static double findMaxAverage(int[] nums, int k) {
        double average = -10000;

        for (int i = 0; i <= nums.length - k; i++) {
            int index = i;
            int count = k;
            int sum = 0;

            while (count > 0) {
                sum += nums[index];
                index++;
                count--;
            }

            double curr_avg = (double) (sum) / k;

            average = Math.max(average, curr_avg);
        }

        return average;
    }

    // cumulative sum approach.
    public static double findMaxAverage_2(int[] nums, int k) {
        int sum = 0;

        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        double average = (double) (sum) / k;

        for (int i = k; i < nums.length; i++) {

            // simultaneously adding the ith index element and subtracting the
            // element from the starting.
            sum += nums[i] - nums[i - k];
            double curr_avg = (double) (sum) / (k);
            average = Math.max(average, curr_avg);
        }

        return average;
    }
}
