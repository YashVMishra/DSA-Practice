// https://leetcode.com/problems/divide-array-into-arrays-with-max-difference/description/?envType=daily-question&envId=2024-02-01

import java.util.Arrays;

public class Divide_Array_Into_Arrays_With_Max_Difference {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4 };
        int k = 1;

        System.out.println(divideArray(nums, k));
    }

    public static int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);

        int[][] result = new int[n / 3][3];
        int index = 0;

        for (int i = 0; i <= n - 3; i += 3) {
            if (nums[i + 2] - nums[i] > k) {
                return new int[0][0];
            }

            result[index++] = new int[] { nums[i], nums[i + 1], nums[i + 2] };
        }

        return result;
    }
}