// https://leetcode.com/problems/monotonic-array/description/?envType=daily-question&envId=2023-09-29

public class Monotonic_Array {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 2, 3 };
        System.out.println(isMonotonic(nums));
    }

    public static boolean isMonotonic(int[] nums) {
        boolean isIncreasing = true;
        boolean isDecreasing = true;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                isIncreasing = false;
            }

            if (nums[i] < nums[i + 1]) {
                isDecreasing = false;
            }
        }

        return isIncreasing || isDecreasing;
    }
}
