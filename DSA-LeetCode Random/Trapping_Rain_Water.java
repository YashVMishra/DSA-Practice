// https://leetcode.com/problems/trapping-rain-water/description/?envType=daily-question&envId=2024-04-12

public class Trapping_Rain_Water {
    public static void main(String[] args) {
        System.out.println(trap(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }));
    }

    public static int trap(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        int waterTrapped = 0;

        left[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            left[i] = Math.max(left[i - 1], height[i]);
        }

        right[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i]);
        }

        for (int i = 0; i < height.length; i++) {
            waterTrapped += Math.min(left[i], right[i]) - height[i];
        }

        return waterTrapped;
    }
}