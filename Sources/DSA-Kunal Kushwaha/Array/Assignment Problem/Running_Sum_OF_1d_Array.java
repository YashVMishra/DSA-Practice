//https://leetcode.com/problems/running-sum-of-1d-array/

import java.util.Arrays;

public class Running_Sum_OF_1d_Array {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(runningSum(new int[] { 1, 2, 3, 4, 5 })));
    }

    public static int[] runningSum(int[] nums) {
        int[] arr = new int[nums.length];
        int start = 0;

        for (int i = 0; i < nums.length; i++) {
            start = start + nums[i];
            arr[i] = start;
        }

        return arr;
    }
}
