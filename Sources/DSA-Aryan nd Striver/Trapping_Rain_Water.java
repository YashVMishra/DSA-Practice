// https://leetcode.com/problems/trapping-rain-water/description/

public class Trapping_Rain_Water {
    public static void main(String[] args) {
        int[] height = { 4, 2, 0, 3, 2, 5 };
        System.out.println(trap(height));
    }

    public static int trap(int[] height) {

        // find the max height on the left and right of the current index.
        int[] left = new int[height.length];
        int[] right = new int[height.length];

        for (int i = 0; i < height.length; i++) {
            if (i == 0) {
                left[i] = height[i];
            } else {
                left[i] = Math.max(left[i - 1], height[i]);
            }
        }

        for (int i = height.length - 1; i >= 0; i--) {
            if (i == height.length - 1) {
                right[i] = height[i];
            } else {
                right[i] = Math.max(right[i + 1], height[i]);
            }
        }

        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            ans += Math.min(left[i], right[i]) - height[i];
        }

        return ans;
    }
}
