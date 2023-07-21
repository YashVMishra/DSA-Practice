//https://leetcode.com/problems/minimize-maximum-of-array/description/

import java.util.Arrays;

public class Minimize_Maximum_of_Array {
    public static void main(String[] args) {
        int[] nums = { 3, 7, 1, 6 };
        System.out.println(minimizeArrayValue(nums));
    }

    public static boolean valid(int mid, int[] nums) {
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (sum > (long) mid * (i + 1)) {
                return false;
            }
        }

        return true;
    }

    public static int minimizeArrayValue(int[] nums) {
        int left = 0, right = Arrays.stream(nums).max().getAsInt();
        int ans = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (valid(mid, nums)) {
                ans = mid;
                right = mid - 1;
            }

            else {
                left = mid + 1;
            }

        }

        return ans;
    }
}
