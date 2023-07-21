//https://leetcode.com/problems/jump-game-ii/description/

public class Jump_Game_2 {
    public static void main(String[] args) {
        int[] arr = { 2, 3, 1, 1, 4 };
        System.out.println(jump_2(arr));
    }

    // using recursion, but it gives TLE error.
    public static int jump(int[] nums, int index) {
        if (index >= nums.length - 1) {
            return 0;
        }

        if (nums[index] == 0) {
            return nums.length - 1;
        }

        int count = nums.length - 1;
        for (int i = 1; i <= nums[index]; i++) {
            count = Math.min(count, 1 + jump(nums, index + i));
        }

        return count;
    }

    // using a single loop.
    public static int jump_2(int[] nums) {

        int farthest = 0;
        int jump = 0;
        int current = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, nums[i] + i);

            if (i == current) {
                jump++;
                current = farthest;
            }
        }

        return jump;
    }
}
