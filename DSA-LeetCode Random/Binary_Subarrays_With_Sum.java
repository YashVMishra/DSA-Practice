// https://leetcode.com/problems/binary-subarrays-with-sum/description/?envType=daily-question&envId=2024-03-14

import java.util.HashMap;

public class Binary_Subarrays_With_Sum {
    public static void main(String[] args) {
        System.out.println(numSubarraysWithSum(new int[] { 1, 0, 1, 0, 1 }, 2));
    }

    public static int numSubarraysWithSum(int[] nums, int goal) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;

            for (int j = i; j < nums.length; j++) {
                sum += nums[j];

                if (sum == goal) {
                    count++;
                }
            }
        }

        return count;
    }

    // ---------------------------------------------------

    public int numSubarraysWithSum_2(int[] nums, int goal) {

        // HashMap to store cumulative sums and their frequencies
        HashMap<Integer, Integer> mp = new HashMap<>();

        int count = 0;
        int currSum = 0;
        mp.put(0, 1);
        for (int num : nums) {
            currSum += num;

            // If there is a previous sum such that (current sum - previous sum) equals
            // goal, increment count by the frequency of that previous sum
            if (mp.containsKey(currSum - goal)) {
                count += mp.get(currSum - goal);
            }

            // Increment the frequency of current sum in the map
            mp.put(currSum, mp.getOrDefault(currSum, 0) + 1);
        }

        return count;
    }
}
