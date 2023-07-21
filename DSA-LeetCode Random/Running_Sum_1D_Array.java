//https://leetcode.com/problems/running-sum-of-1d-array/?envType=study-plan&id=level-1

import java.util.Arrays;

public class Running_Sum_1D_Array {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4 };
        System.out.println(Arrays.toString(runningSum(arr)));
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
