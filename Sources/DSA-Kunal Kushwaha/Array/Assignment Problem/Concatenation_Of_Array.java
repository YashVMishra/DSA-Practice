//https://leetcode.com/problems/concatenation-of-array/

import java.util.Arrays;

public class Concatenation_Of_Array {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getConcatenation(new int[] { 1, 2, 1 })));
    }

    public static int[] getConcatenation(int[] nums) {
        int[] arr = new int[nums.length * 2];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = nums[i % nums.length];
        }

        return arr;
    }
}
