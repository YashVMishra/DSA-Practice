//https://leetcode.com/problems/jump-game-ii/description/

public class Jump_Game_2 {
    public static void main(String[] args) {
        int[] arr = { 2, 3, 0, 1, 4 };
        System.out.println(jump(arr));
    }

    public static int jump(int[] nums) {
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