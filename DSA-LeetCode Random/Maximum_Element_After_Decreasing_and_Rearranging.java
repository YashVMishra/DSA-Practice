// https://leetcode.com/problems/maximum-element-after-decreasing-and-rearranging/description/?envType=daily-question&envId=2023-11-15

import java.util.Arrays;

public class Maximum_Element_After_Decreasing_and_Rearranging {
    public static void main(String[] args) {
        System.out.println(maximumElementAfterDecrementingAndRearranging(new int[] { 2, 2, 1, 2, 1 }));
    }

    public static int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                arr[i] = 1;
            } else if (Math.abs(arr[i] - arr[i - 1]) > 1) {
                arr[i] = arr[i - 1] + 1;
            }

            // you have to write this outside as
            // there may be the case the array given to us is
            // satisfying the conditions of the questions.
            max = Math.max(max, arr[i]);
        }

        return max;
    }
}
