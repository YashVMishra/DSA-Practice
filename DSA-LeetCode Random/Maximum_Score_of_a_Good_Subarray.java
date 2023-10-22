// https://leetcode.com/problems/maximum-score-of-a-good-subarray/?envType=daily-question&envId=2023-10-22

public class Maximum_Score_of_a_Good_Subarray {
    public static void main(String[] args) {
        int[] nums = { 1, 4, 3, 7, 4, 5 };
        int k = 3;
        System.out.println(maximumScore(nums, k));
    }

    public static int maximumScore(int[] nums, int k) {
        int n = nums.length;
        int i = k;
        int j = k;
        int curMin = nums[k];
        int result = nums[k];

        while (i > 0 || j < n - 1) {
            int leftValue = (i > 0) ? nums[i - 1] : 0;
            int rightValue = (j < n - 1) ? nums[j + 1] : 0;

            if (leftValue < rightValue) {
                j++;
                curMin = Math.min(curMin, nums[j]);
            } else {
                i--;
                curMin = Math.min(curMin, nums[i]);
            }

            result = Math.max(result, curMin * (j - i + 1));
        }

        return result;
    }
}
