// https://leetcode.com/problems/find-pivot-index/description/?envType=study-plan-v2&envId=leetcode-75

public class Find_Pivot_Index {
    public static void main(String[] args) {
        int[] nums = { 1, 7, 3, 6, 5, 6 };
        System.out.println(pivotIndex(nums));
    }

    public static int pivotIndex(int[] nums) {
        int totalSum = 0;
        int leftSum = 0;

        for (int i : nums) {
            totalSum += i;
        }

        for (int i = 0; i < nums.length; i++) {
            if (totalSum - nums[i] - leftSum == leftSum) {
                return i;
            } else {
                leftSum += nums[i];
            }
        }

        return -1;
    }
}
