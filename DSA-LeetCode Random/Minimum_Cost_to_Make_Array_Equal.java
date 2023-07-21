//https://leetcode.com/problems/minimum-cost-to-make-array-equal/description/

public class Minimum_Cost_to_Make_Array_Equal {

    static int ELEMENT_COUNT = 1000002;

    public static void main(String[] args) {
        int[] nums = { 1, 3, 5, 2 };
        int[] cost = { 2, 3, 1, 14 };
        System.out.println(minCost(nums, cost));
    }

    public static long minCost(int[] nums, int[] cost) {
        long[] costOfNos = new long[ELEMENT_COUNT];

        for (int i = 0; i < nums.length; i++) {
            costOfNos[nums[i]] += cost[i];
        }

        long[] prefSum = new long[ELEMENT_COUNT];
        long[] suffSum = new long[ELEMENT_COUNT];
        long ans = Long.MAX_VALUE;
        long sum = 0;

        for (int i = 1; i < ELEMENT_COUNT; i++) {
            prefSum[i] = prefSum[i - 1] + sum;
            sum += costOfNos[i];
        }

        sum = 0;
        for (int i = ELEMENT_COUNT - 2; i >= 0; i--) {
            suffSum[i] = suffSum[i + 1] + sum;
            sum += costOfNos[i];
            ans = Math.min(ans, suffSum[i] + prefSum[i]);
        }

        return ans;
    }
}
