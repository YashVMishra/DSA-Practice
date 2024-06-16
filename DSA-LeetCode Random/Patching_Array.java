// https://leetcode.com/problems/patching-array/description/?envType=daily-question&envId=2024-06-16

public class Patching_Array {
    public static void main(String[] args) {
        int[] nums = { 1, 3 };
        int n = 6;
        System.out.println(minPatches(nums, n));
    }

    public static int minPatches(int[] nums, int n) {
        long maxReach = 0;
        int patch = 0;
        int i = 0;

        while (maxReach < n) {
            if (i < nums.length && nums[i] <= maxReach + 1) {
                maxReach += nums[i];
                i++;
            } else {
                maxReach += (maxReach + 1);
                patch++;
            }
        }

        return patch;
    }
}
