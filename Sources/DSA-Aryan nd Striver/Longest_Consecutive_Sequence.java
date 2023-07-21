//https://leetcode.com/problems/longest-consecutive-sequence/description/

import java.util.HashMap;
import java.util.HashSet;

public class Longest_Consecutive_Sequence {
    public static void main(String[] args) {
        int[] nums = { 100, 4, 200, 1, 3, 2 };
        System.out.println(longestConsecutive(nums));
        System.out.println(longestConsecutive_2(nums));
    }

    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int i : nums) {
            set.add(i);
        }

        int maxLength = 0;

        for (int i : nums) {
            if (!set.contains(i - 1)) {
                int currLength = 1;
                int currNum = i;

                while (set.contains(currNum + 1)) {
                    currLength++;
                    currNum++;
                }

                maxLength = Math.max(currLength, maxLength);
            }
        }

        return maxLength;
    }

    public static int longestConsecutive_2(int[] nums) {
        HashMap<Integer, Boolean> map = new HashMap<>();

        for (int i : nums) {
            map.put(i, true);
        }

        for (int i : nums) {
            if (map.containsKey(i - 1)) {
                map.put(i, false);
            }
        }

        int maxLength = 0;

        for (int i : nums) {
            if (map.get(i) == true) {
                int currLength = 1;
                int currNum = i;

                while (map.containsKey(currNum + 1)) {
                    currLength++;
                    currNum++;
                }

                maxLength = Math.max(currLength, maxLength);
            }
        }

        return maxLength;
    }
}
