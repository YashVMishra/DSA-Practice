//https://leetcode.com/problems/4sum/description/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum_4 {
    public static void main(String[] args) {
        int[] arr = { 1000000000, 1000000000, 1000000000, 1000000000 };
        System.out.println(fourSum(arr, -294967296));
        System.out.println(fourSum_2(arr, -294967296));
    }

    // simple approach is to use 4 loops
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        long temp_target = target;

        Arrays.sort(nums);

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    for (int l = k + 1; l < nums.length; l++) {
                        long curr_sum = (long) (nums[i]) + (long) (nums[j]) + (long) (nums[k]) + (long) (nums[l]);
                        if (curr_sum == temp_target) {
                            List<Integer> temp = new ArrayList<>();
                            temp.addAll(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));

                            if (!list.contains(temp)) {
                                list.add(temp);
                            }
                        }
                    }
                }
            }
        }

        return list;
    }

    // using two loops and pointer method.
    public static List<List<Integer>> fourSum_2(int[] nums, int target) {
        long temp_target = target;

        Arrays.sort(nums);

        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {

            for (int j = i + 1; j < nums.length; j++) {

                int left = j + 1;
                int right = nums.length - 1;

                while (left < right) {
                    long left_target = temp_target - (long) nums[i] - (long) nums[j];
                    long x = nums[left];
                    long y = nums[right];

                    if (x + y < left_target) {
                        left++;
                    }

                    if (x + y > left_target) {
                        right--;
                    }

                    if (x + y == left_target) {

                        System.out.println(left_target);
                        list.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == x) {
                            left++;
                        }

                        while (left < right && nums[right] == y) {
                            right--;
                        }

                    }
                }

                while (j + 1 < nums.length && nums[j + 1] == nums[j]) {
                    j++;
                }
            }

            while (i + 1 < nums.length && nums[i + 1] == nums[i]) {
                i++;
            }
        }

        return list;
    }

}
