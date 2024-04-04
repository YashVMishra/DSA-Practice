// https://leetcode.com/problems/count-pairs-whose-sum-is-less-than-target/description/

import java.util.Collections;
import java.util.List;

public class Count_Pairs_Whose_Sum_is_Less_than_Target {
    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        int target = 10;

        System.out.println(countPairs(nums, target));
    }

    // brute force - checking every pairs
    public static int countPairs(List<Integer> nums, int target) {
        int pairs = 0;

        for (int i = 0; i < nums.size(); i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                if (nums.get(i) + nums.get(j) < target) {
                    pairs++;
                }
            }
        }

        return pairs;
    }

    // --------------------------------------------------------------------------------

    // using two pointers approach
    public static int countPairs_2(List<Integer> nums, int target) {
        Collections.sort(nums);
        int pairs = 0;
        int left = 0;
        int right = nums.size() - 1;

        while (left < right) {
            if (nums.get(left) + nums.get(right) < target) {
                pairs += right - left;
                left++;
            } else {
                right--;
            }
        }

        return pairs;
    }
}
