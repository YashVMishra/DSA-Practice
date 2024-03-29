// https://leetcode.com/problems/count-subarrays-where-max-element-appears-at-least-k-times/description/?envType=daily-question&envId=2024-03-29

import java.util.ArrayList;
import java.util.List;

public class Count_Subarrays_Where_Max_Element_Appears_at_Least_K_Times {
    public static void main(String[] args) {
        int[] nums = { 1, 3, 2, 3, 3 };
        int k = 2;

        System.out.println(countSubarrays(nums, k));
        System.out.println(countSubarrays_2(nums, k));
        System.out.println(countSubarrays_3(nums, k));
    }

    // using two loops to check all the subarrays.
    public static long countSubarrays(int[] nums, int k) {
        int maxElement = Integer.MIN_VALUE;
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            maxElement = Math.max(maxElement, nums[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (count(nums, i, j, maxElement) >= k) {
                    ans++;
                }
            }
        }

        return ans;
    }

    private static int count(int[] nums, int start, int end, int element) {
        int count = 0;

        for (int i = start; i <= end; i++) {
            if (nums[i] == element) {
                count++;
            }
        }

        return count;
    }

    // --------------------------------------------------------------------------------

    // using siding window technique
    public static long countSubarrays_2(int[] nums, int k) {
        int maxElement = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            maxElement = Math.max(maxElement, nums[i]);
        }

        int n = nums.length;
        int i = 0, j = 0;

        long result = 0;
        int countMax = 0;

        while (j < n) {
            if (nums[j] == maxElement) {
                countMax++;
            }

            while (countMax >= k) {
                result += n - j;

                if (nums[i] == maxElement) {
                    countMax--;
                }

                i++;
            }

            j++;
        }

        return result;
    }

    // --------------------------------------------------------------------------------

    // without using sliding window technique
    public static long countSubarrays_3(int[] nums, int k) {
        int maxElement = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            maxElement = Math.max(maxElement, nums[i]);
        }

        int n = nums.length;
        long result = 0;

        List<Integer> maxIndices = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (nums[i] == maxElement) {
                maxIndices.add(i);
            }

            int size = maxIndices.size();
            if (size >= k) {
                int last_i = maxIndices.get(size - k);
                result += last_i + 1;
            }
        }

        return result;
    }
}
