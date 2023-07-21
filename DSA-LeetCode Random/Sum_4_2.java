//https://leetcode.com/problems/4sum-ii/description/

import java.util.Map;
import java.util.HashMap;

public class Sum_4_2 {
    public static void main(String[] args) {
        int[] nums1 = { 1, 2 };
        int[] nums2 = { -2, -1 };
        int[] nums3 = { -1, 2 };
        int[] nums4 = { 0, 2 };

        System.out.println(fourSumCount(nums1, nums2, nums3, nums4));
        System.out.println(fourSumCount_2(nums1, nums2, nums3, nums4));
        System.out.println(fourSumCount_3(nums1, nums2, nums3, nums4));
    }

    // brute force approach to use 4 loops.
    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {

        int count = 0;

        for (int i : nums1) {
            for (int j : nums2) {
                for (int k : nums3) {
                    for (int l : nums4) {
                        if (i + j + k + l == 0) {
                            count++;
                        }
                    }
                }
            }
        }

        return count;
    }

    // using an HashMap we can reduce the time to O(n^3)
    // as searching in an unordered HashMap is of O(1) TC.
    public static int fourSumCount_2(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int i : nums4) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            }

            else {
                map.put(i, 1);
            }
        }

        for (int i : nums1) {
            for (int j : nums2) {
                for (int k : nums3) {
                    if (map.containsKey(0 - i - j - k)) {
                        count += map.get(0 - i - j - k);
                    }
                }
            }
        }

        return count;
    }

    // using an HashMap we can reduce the time to O(n^2)
    // As the key in the hashmap, store the sum of nums3 and nums4 as pair
    // Doing this the TC reduces to O(n^2).
    // as searching in an unordered HashMap is of O(1) TC.
    public static int fourSumCount_3(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int i : nums3) {
            for (int j : nums4) {
                if (map.containsKey(i + j)) {
                    map.put(i + j, map.get(i + j) + 1);
                }

                else {
                    map.put(i + j, 1);
                }
            }
        }

        for (int i : nums1) {
            for (int j : nums2) {
                if (map.containsKey(0 - i - j)) {
                    count += map.get(0 - i - j);
                }
            }
        }

        return count;
    }
}
