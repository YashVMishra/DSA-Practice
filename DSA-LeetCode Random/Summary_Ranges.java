//https://leetcode.com/problems/summary-ranges/description/

import java.util.List;
import java.util.ArrayList;

public class Summary_Ranges {
    public static void main(String[] args) {
        int[] nums = { 0, 1, 2, 4, 5, 7 };
        System.out.println(summaryRanges(nums));
    }

    public static List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();

        // imp edge case.
        if (nums.length == 0) {
            return ans;
        }

        int start = nums[0];
        int end = nums[0];
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] + 1 == nums[i + 1]) {
                end = nums[i + 1];
            }

            else {

                if (start == end) {
                    ans.add(Integer.toString(end));
                } else {
                    ans.add(start + "->" + end);
                }

                start = nums[i + 1];
                end = nums[i + 1];
            }
        }

        // this if-else is for the last range.
        if (start == end) {
            ans.add(Integer.toString(end));
        } else {
            ans.add(start + "->" + end);
        }

        return ans;
    }

    // logic same as above but smaller code.
    public static List<String> summaryRanges_2(int[] nums) {
        List<String> ranges = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int start = nums[i];

            // Keep iterating until the next element is one more than the current element.
            while (i + 1 < nums.length && nums[i] + 1 == nums[i + 1]) {
                i++;
            }

            if (start != nums[i]) {
                ranges.add(start + "->" + nums[i]);
            } else {
                ranges.add(String.valueOf(start));
            }
        }

        return ranges;
    }
}
