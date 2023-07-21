//https://leetcode.com/problems/3sum-closest/description/

import java.util.Arrays;

public class Three_Sum_Closest {
    public static void main(String[] args) {
        int target = 1;
        int[] nums = { -1, 2, 1, -4 };
        System.out.println(threeSumClosest(nums, target));
        System.out.println(threeSumClosest_2(nums, target));
    }

    public static int threeSumClosest(int[] nums, int target) {
        int sum = 0;
        int ans = 0;
        int difference = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    sum = nums[i] + nums[j] + nums[k];

                    if (sum == target) {
                        return sum;
                    }

                    else {
                        if (Math.abs(target - sum) < difference) {
                            ans = sum;
                            difference = Math.abs(target - sum);
                        }
                    }
                }
            }
        }

        return ans;
    }

    // different version of 3 Sum problem.
    public static int threeSumClosest_2(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = 0;
        int difference = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int start = i + 1;
            int end = nums.length - 1;

            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];

                if (sum == target) {
                    return sum;
                }

                else {
                    if (Math.abs(target - sum) < difference) {
                        difference = Math.abs(target - sum);
                        ans = sum;
                    }
                }

                if (sum < target) {
                    start++;
                }

                else {
                    end--;
                }
            }
        }

        return ans;
    }
}