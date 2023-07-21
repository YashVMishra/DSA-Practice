//https://leetcode.com/problems/jump-game/description/

public class Jump_Game {
    public static void main(String[] args) {
        int[] arr = { 1, 0, 1, 0 };
        System.out.println(canJump(arr));
    }

    public static boolean canJump(int[] nums) {

        if (nums.length == 1) {
            return true;
        }

        // if the first index is zero then you cannot make any jump
        if (nums[0] == 0) {
            return false;
        }

        // if any element is not zero then you can definitely reach the last index.
        int check = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                ;
            }

            else {
                check = 1;
            }
        }

        if (check == 0) {
            return true;
        }

        // to find out the max reaching index
        int max_reach = 0;
        for (int i = 0; i < nums.length - 1; i++) {

            // as we cannot go over the max_reach(imp condition)
            if (i <= max_reach) {
                max_reach = Math.max(max_reach, i + nums[i]);
            }

            else {
                return false;
            }
        }

        if (max_reach >= nums.length - 1) {
            return true;
        }

        return false;
    }
}
