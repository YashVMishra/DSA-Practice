//https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/

import java.util.Arrays;

public class How_many_Numbers_Are_Smaller_Than_The_Given_Number {
    public static void main(String[] args) {
        int[] arr = { 8, 1, 2, 2, 3 };
        System.out.println(Arrays.toString(smallerNumbersThanCurrent(arr)));
    }

    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] ans = new int[nums.length];
        int index = 0;

        for (int i : nums) {
            int count = 0;
            for (int j : nums) {
                if (j < i) {
                    count++;
                }
            }

            ans[index] = count;
            index++;
        }

        return ans;
    }
}
