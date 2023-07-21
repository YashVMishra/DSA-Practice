//https://leetcode.com/problems/maximum-or/description/

public class Maximum_OR {
    public static void main(String[] args) {
        int[] nums = { 8, 1, 2 };
        int k = 2;
        System.out.println(maximumOr(nums, k));
    }

    public static long maximumOr(int[] nums, int k) {
        long ans = 0;
        int len = nums.length;
        long[] prefix = new long[len];
        long[] suffix = new long[len];

        prefix[0] = 0;
        suffix[len - 1] = 0;

        for (int i = 1; i < len; i++) {
            prefix[i] = prefix[i - 1] | nums[i - 1];
        }

        for (int i = len - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] | nums[i + 1];
        }

        long curr_ans = 0;
        for (int i = 0; i < len; i++) {

            // here 1 will be of long not int thats why its written 1l.
            curr_ans = prefix[i] | suffix[i] | ((1l << k) * nums[i]);
            ans = Math.max(ans, curr_ans);
        }

        return ans;
    }
}
