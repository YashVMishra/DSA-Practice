//https://leetcode.com/problems/build-array-from-permutation/

import java.util.Arrays;

class Build_Array_From_Permutation {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(buildArray(new int[] { 0, 2, 1, 5, 3, 4 })));
    }

    public static int[] buildArray(int[] nums) {
        int[] arr = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[nums[i]];
        }

        return arr;
    }
}