//https://leetcode.com/problems/count-subarrays-with-fixed-bounds/description/

public class Subarray_Fixed_Bounds {
    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 1 };
        int minK = 1;
        int maxK = 1;
        System.out.println(countSubarrays(nums, minK, maxK));
        System.out.println(countSubarrays_2(nums, minK, maxK));
    }

    // shows TLE.
    public static long countSubarrays(int[] nums, int minK, int maxK) {
        long count = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int[] temp = min_max(nums, i, j);
                if (temp[0] == maxK && temp[1] == minK) {
                    count++;
                }
            }
        }

        return count;
    }

    public static int[] min_max(int[] nums, int start, int end) {
        int[] ans = new int[2];
        ans[0] = Integer.MIN_VALUE;
        ans[1] = Integer.MAX_VALUE;

        for (int i = start; i <= end; i++) {
            ans[0] = Math.max(ans[0], nums[i]);
            ans[1] = Math.min(ans[1], nums[i]);
        }

        return ans;
    }

    public static long countSubarrays_2(int[] nums, int minK, int maxK) {
        int backB = -1;
        int minB = -1;
        int maxB = -1;
        long count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < minK || nums[i] > maxK) {
                backB = i;
            }

            if (nums[i] == minK) {
                minB = i;
            }

            if (nums[i] == maxK) {
                maxB = i;
            }

            count += Math.max(0, Math.min(minB, maxB) - backB);
        }

        return count;
    }
}