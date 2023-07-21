//https://leetcode.com/problems/create-target-array-in-the-given-order/

import java.util.Arrays;

class Create_Target_In_The_Given_Order {
    public static void main(String[] args) {
        int[] nums = { 0, 1, 2, 3, 4 };
        int[] index = { 0, 1, 2, 2, 1 };

        System.out.println(Arrays.toString(createTargetArray(nums, index)));
    }

    public static int[] createTargetArray(int[] nums, int[] index) {
        int[] target = new int[nums.length];

        for (int i = 0; i < target.length; i++) {
            target[i] = Integer.MIN_VALUE;
        }

        for (int i = 0; i < nums.length; i++) {
            int index_target = index[i];
            if (target[index_target] != Integer.MIN_VALUE) {
                shift(target, i, index_target);
                target[index_target] = nums[i];
            }

            else {
                target[index_target] = nums[i];
            }
        }

        return target;
    }

    static void shift(int[] arr, int start, int end) {
        for (int i = start; i > end; i--) {
            arr[i] = arr[i - 1];
        }
    }
}