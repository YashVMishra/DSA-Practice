//https://leetcode.com/problems/increasing-triplet-subsequence/description/

public class Increase_Triplet_Subsequence {
    public static void main(String[] args) {
        int[] nums = { 5, 4, 3, 2, 1 };
        System.out.println(increasingTriplet(nums));
    }

    // brute force method.
    // shows TLE
    public static boolean increasingTriplet(int[] nums) {

        int len = nums.length;

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                for (int k = j + 1; k < len; k++) {
                    if (nums[i] < nums[j] && nums[j] < nums[k]) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    // acceptable method.
    public static boolean increasingTriplet_2(int[] nums) {

        int num_1 = Integer.MAX_VALUE;
        int num_2 = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= num_1) {
                num_1 = nums[i];
            }

            else if (nums[i] <= num_2) {
                num_2 = nums[i];
            }

            else {
                return true;
            }
        }

        return false;
    }
}
