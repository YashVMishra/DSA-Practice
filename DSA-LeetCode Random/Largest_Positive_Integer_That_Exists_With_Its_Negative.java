// https://leetcode.com/problems/largest-positive-integer-that-exists-with-its-negative/description/?envType=daily-question&envId=2024-05-02

import java.util.HashSet;

public class Largest_Positive_Integer_That_Exists_With_Its_Negative {
    public static void main(String[] args) {

    }

    public static int findMaxK(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int ans = Integer.MIN_VALUE;

        for (int num : nums) {
            if (set.contains(-num)) {
                ans = Math.max(ans, Math.abs(num));
            }

            set.add(num);
        }

        return ans == Integer.MIN_VALUE ? -1 : ans;
    }
}
