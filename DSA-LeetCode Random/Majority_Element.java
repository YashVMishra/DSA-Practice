// https://leetcode.com/problems/majority-element/description/

import java.util.HashMap;
import java.util.Set;

public class Majority_Element {
    public static void main(String[] args) {
        int[] nums = { 2, 2, 1, 1, 1, 2, 2 };
        System.out.println(majorityElement(nums));
    }

    // uses map to store the frequency of each element.
    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int value = (int) (Math.floor(nums.length / 2));

        for (int i : nums) {
            map.put(i, (map.getOrDefault(i, 0) + 1));
        }

        Set<Integer> keySet = map.keySet();
        int ans = 0;

        for (int i : keySet) {
            if (map.get(i) > value) {
                ans = i;
            }
        }

        return ans;
    }

    // using banking voting algorithm. (Boyer Moore's Voting Algorithm)
    // see the video from the notes section.
    public static int majorityElement_2(int[] nums) {
        int count = 1;
        int candidate = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                candidate = nums[i];
                count = 1;
            } else if (candidate == nums[i]) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }
}
