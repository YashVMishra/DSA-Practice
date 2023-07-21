//https://leetcode.com/problems/find-pivot-index/description/?envType=study-plan&id=level-1?envType=study-plan&id=level-1

public class Pivot_Index {
    public static void main(String[] args) {
        int[] nums = { 1, 7, 3, 6, 5, 6 };
        System.out.println(pivotIndex(nums));
    }

    public static int pivotIndex(int[] nums) {
        int total_sum = 0;
        int left_sum = 0;

        for (int i : nums) {
            total_sum += i;
        }

        for (int i = 0; i < nums.length; i++) {
            if (total_sum - left_sum - nums[i] == left_sum) {
                return i;
            }

            else {
                left_sum += nums[i];
            }
        }

        return -1;
    }
}
