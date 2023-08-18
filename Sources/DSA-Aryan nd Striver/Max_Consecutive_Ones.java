// https://leetcode.com/problems/max-consecutive-ones/description/

public class Max_Consecutive_Ones {
    public static void main(String[] args) {
        int[] nums = { 1, 0, 1, 1, 0, 1 };
        System.out.println(findMaxConsecutiveOnes(nums));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0;
        int count = 0;

        for (int i : nums) {
            if (i == 1) {
                count++;
            } else {
                ans = Math.max(ans, count);
                count = 0;
            }
        }

        // for consecutive 1s at the end of the array.
        ans = Math.max(ans, count);

        return ans;
    }
}
