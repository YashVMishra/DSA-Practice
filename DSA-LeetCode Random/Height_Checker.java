// https://leetcode.com/problems/height-checker/description/?envType=daily-question&envId=2024-06-10

import java.util.Arrays;

public class Height_Checker {
    public static void main(String[] args) {
        int[] heights = { 1, 1, 4, 2, 1, 3 };
        System.out.println(heightChecker(heights));
    }

    public static int heightChecker(int[] heights) {
        int[] expected = heights.clone();
        Arrays.sort(expected);
        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != expected[i])
                count++;
        }

        return count;
    }
}