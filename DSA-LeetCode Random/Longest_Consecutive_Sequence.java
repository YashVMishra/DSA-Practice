//https://leetcode.com/problems/longest-consecutive-sequence/description/

import java.util.Map;
import java.util.HashMap;

public class Longest_Consecutive_Sequence {
    public static void main(String[] args) {
        int[] nums = { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 };
        System.out.println(longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();

        for (int i : nums) {
            map.put(i, true);
        }

        for (int i : nums) {
            if (map.containsKey(i - 1)) {
                map.put(i, false);
            }
        }

        int max_length = 0;

        for (int i : nums) {
            int curr_length = 0;
            if (map.get(i)) {
                curr_length++;
                while (true) {
                    if (map.containsKey(++i)) {
                        curr_length++;
                    }

                    else {
                        break;
                    }
                }
            }

            max_length = Math.max(max_length, curr_length);
        }

        return max_length;
    }
}
