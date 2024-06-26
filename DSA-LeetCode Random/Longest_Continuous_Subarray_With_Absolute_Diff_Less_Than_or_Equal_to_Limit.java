// https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/description/?envType=daily-question&envId=2024-06-23

import java.util.PriorityQueue;
import java.util.TreeMap;

public class Longest_Continuous_Subarray_With_Absolute_Diff_Less_Than_or_Equal_to_Limit {
    public static void main(String[] args) {
        int[] nums = { 8, 2, 4, 7 };
        int limit = 4;
        System.out.println(longestSubarray(nums, limit));
        System.out.println(longestSubarray_2(nums, limit));
    }

    // Approach-1 (Using sliding window + heap)
    // T.C : O(nlogn)
    // S.C : O(n)
    public static int longestSubarray(int[] nums, int limit) {
        int n = nums.length;
        PriorityQueue<int[]> maxPq = new PriorityQueue<>((a, b) -> b[0] - a[0]); // max-heap
        PriorityQueue<int[]> minPq = new PriorityQueue<>((a, b) -> a[0] - b[0]); // min-heap

        int i = 0; // Left boundary of the sliding window
        int j = 0; // Right boundary of the sliding window
        int maxLength = 0;

        while (j < n) {
            maxPq.offer(new int[] { nums[j], j });
            minPq.offer(new int[] { nums[j], j });

            while (maxPq.peek()[0] - minPq.peek()[0] > limit) {
                i = Math.min(maxPq.peek()[1], minPq.peek()[1]) + 1;

                while (maxPq.peek()[1] < i) {
                    maxPq.poll();
                }

                while (minPq.peek()[1] < i) {
                    minPq.poll();
                }
            }

            // Update maxLength with the length of the current valid window
            maxLength = Math.max(maxLength, j - i + 1);
            j++;
        }

        return maxLength;
    }

    // Approach-2 (Using sliding window + multiset)
    // T.C : O(nlogn)
    // S.C : O(n)
    public static int longestSubarray_2(int[] nums, int limit) {
        int n = nums.length;

        TreeMap<Integer, Integer> st = new TreeMap<>();
        int i = 0;
        int j = 0;
        int maxLength = 0;

        while (j < n) {
            st.put(nums[j], st.getOrDefault(nums[j], 0) + 1);

            while (st.lastKey() - st.firstKey() > limit) {
                st.put(nums[i], st.get(nums[i]) - 1);
                if (st.get(nums[i]) == 0) {
                    st.remove(nums[i]);
                }

                i++;
            }

            maxLength = Math.max(maxLength, j - i + 1);
            j++;
        }

        return maxLength;
    }
}
