//https://leetcode.com/problems/4sum/description/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Four_Sum {
    public static void main(String[] args) {
        int[] nums = { 2, 2, 2, 2, 2 };
        int target = 8;
        System.out.println(fourSum(nums, target));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        long tempTarget = target;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {

                int left = j + 1;
                int right = nums.length - 1;

                while (left < right) {
                    long diff = tempTarget - (long) (nums[i]) - (long) (nums[j]);
                    long x = nums[left];
                    long y = nums[right];
                    long sum = x + y;

                    if (sum < diff) {
                        left++;
                    } else if (sum > diff) {
                        right--;
                    } else {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        // if you compare nums[left]==x then atlast you dont have to
                        // write left++ as we are comparing direct to a value.
                        // same goes for right one.
                        while (left < right && nums[left] == x) {
                            left++;
                        }

                        while (left < right && nums[right] == y) {
                            right--;
                        }
                    }
                }

                while (j + 1 < nums.length && nums[j] == nums[j + 1]) {
                    j++;
                }
            }

            while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                i++;
            }
        }

        return ans;
    }
}
