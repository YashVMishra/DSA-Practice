// https://leetcode.com/problems/count-elements-with-maximum-frequency/description/?envType=daily-question&envId=2024-03-08

import java.util.HashMap;

public class Count_Elements_With_Maximum_Frequency {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5 };
        System.out.println(maxFrequencyElements_2(nums));
    }

    // two pass solution.
    public static int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxFrequency = 0;

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            maxFrequency = Math.max(map.get(num), maxFrequency);
        }

        int ans = 0;
        for (int key : map.keySet()) {
            if (map.get(key) == maxFrequency) {
                ans += maxFrequency;
            }
        }

        return ans;
    }

    // -------------------------------------------------------------------------------

    // two pass solution.
    public static int maxFrequencyElements_2(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxFrequency = 0;
        int count = 0;

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);

            if (map.get(num) > maxFrequency) {
                count = 1;
                maxFrequency = map.get(num);
            } else if (map.get(num) == maxFrequency) {
                count++;
            }
        }

        return count * maxFrequency;
    }
}
