//https://leetcode.com/problems/increasing-triplet-subsequence/description/

public class Increase_Triplet_Subsequence {
    public static void main(String[] args) {
        int[] nums = { 2, 1, 5, 0, 4, 6 };
        System.out.println(increasingTriplet_3(nums));
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

    // method suggested by github co-pilot.
    // idea is to maintain two arrays, left and right.
    // left array stores the minimum element to the left of the current element.
    // right array stores the maximum element to the right of the current element.
    // and now compare the current element with the left and right array.
    public static boolean increasingTriplet_3(int[] nums) {
        int len = nums.length;
        int[] left = new int[len];
        int[] right = new int[len];

        left[0] = nums[0];
        right[len - 1] = nums[len - 1];

        for (int i = 1; i < len; i++) {
            left[i] = Math.min(left[i - 1], nums[i]);
        }

        for (int i = len - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], nums[i]);
        }

        for (int i = 0; i < len; i++) {
            if (nums[i] > left[i] && nums[i] < right[i]) {
                return true;
            }
        }

        return false;
    }

    // acceptable method.
    // for intuition see notes section.
    public static boolean increasingTriplet_2(int[] nums) {
        int max_1 = Integer.MAX_VALUE;
        int max_2 = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= max_1) {
                max_1 = nums[i];
            }

            else if (nums[i] <= max_2) {
                max_2 = nums[i];
            }

            else {
                return true;
            }
        }

        return false;
    }
}
