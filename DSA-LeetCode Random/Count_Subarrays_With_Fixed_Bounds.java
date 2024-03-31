// https://leetcode.com/problems/count-subarrays-with-fixed-bounds/description/?envType=daily-question&envId=2024-03-31

public class Count_Subarrays_With_Fixed_Bounds {
    public static void main(String[] args) {
        int[] nums = { 1, 3, 5, 2, 7, 5 };
        int minK = 1;
        int maxK = 5;

        System.out.println(countSubarrays(nums, minK, maxK));
        System.out.println(countSubarrays_2(nums, minK, maxK));
    }

    // shows TLE
    // basic solution of checking every subarray
    public static long countSubarrays(int[] nums, int minK, int maxK) {
        long count = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {

                int[] minMax = minMax(nums, i, j);
                if (minMax[0] == minK && minMax[1] == maxK) {
                    count++;
                }
            }
        }

        return count;
    }

    private static int[] minMax(int[] nums, int start, int end) {
        int[] result = new int[2];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = start; i <= end; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);

        }

        result[0] = min;
        result[1] = max;
        return result;
    }

    // --------------------------------------------------------------------------------

    public static long countSubarrays_2(int[] nums, int minK, int maxK) {
        long count = 0;
        int maxPosition = -1;
        int minPosition = -1;
        int culpritIndex = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < minK || nums[i] > maxK) {
                culpritIndex = i;
            }

            if (nums[i] == minK) {
                minPosition = i;
            }

            if (nums[i] == maxK) {
                maxPosition = i;
            }

            int temp = Math.min(minPosition, maxPosition) - culpritIndex;
            count += temp <= 0 ? 0 : temp;
        }

        return count;
    }
}