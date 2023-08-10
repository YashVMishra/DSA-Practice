// https://leetcode.com/problems/minimize-the-maximum-difference-of-pairs/

import java.util.Arrays;

public class Minimize_the_Maximum_Difference_of_Pairs {
    public static void main(String[] args) {
        int[] nums = { 10, 1, 2, 7, 1, 3 };
        int p = 2;
        System.out.println(minimizeMax(nums, p));
    }

    public static int minimizeMax(int[] nums, int p) {
        int n = nums.length;
        Arrays.sort(nums);
        int left = 0;
        int right = nums[n - 1] - nums[0];
        int ans = right;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (isPossible(nums, p, mid)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    public static boolean isPossible(int[] nums, int p, int diff) {
        int n = nums.length;

        for (int i = 1; i < n; i++) {
            if (nums[i] - nums[i - 1] <= diff) {
                p--;
                i++;
            }
        }

        return p <= 0;
    }
}
