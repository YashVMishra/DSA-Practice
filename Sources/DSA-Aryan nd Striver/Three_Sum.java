//https://leetcode.com/problems/3sum/description/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Three_Sum {
    public static void main(String[] args) {
        int[] nums = { 0, 0, 0 };
        System.out.println(threeSum(nums));
        System.out.println(threeSum_2(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {

            int left = i + 1;
            int right = nums.length - 1;

            int sum = 0 - nums[i];

            while (left < right) {
                int curr_sum = nums[left] + nums[right];
                if (curr_sum == sum) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }

                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                } else if (curr_sum > sum) {
                    right--;
                } else {
                    left++;
                }
            }

            while (i < nums.length - 2 && nums[i] == nums[i + 1]) {
                i++;
            }
        }

        return res;
    }

    // both the function are almost same just iterating the pointer i is different.
    public static List<List<Integer>> threeSum_2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {

            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int left = i + 1;
                int right = nums.length - 1;

                int sum = 0 - nums[i];

                while (left < right) {
                    int curr_sum = nums[left] + nums[right];
                    if (curr_sum == sum) {
                        res.add(Arrays.asList(nums[i], nums[left], nums[right]));

                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }

                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }

                        left++;
                        right--;
                    } else if (curr_sum > sum) {
                        right--;
                    } else {
                        left++;
                    }
                }

                while (i < nums.length - 2 && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
        }

        return res;
    }
}

//
