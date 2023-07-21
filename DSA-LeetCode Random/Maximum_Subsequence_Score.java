//https://leetcode.com/problems/maximum-subsequence-score/description/

import java.util.Arrays;
import java.util.PriorityQueue;

public class Maximum_Subsequence_Score {
    public static void main(String[] args) {
        int[] nums1 = { 1, 3, 3, 2 };
        int[] nums2 = { 2, 1, 3, 4 };
        int k = 3;

        System.out.println(maxScore(nums1, nums2, k));
    }

    public static long maxScore(int[] nums1, int[] nums2, int k) {
        int[][] vec = new int[nums1.length][2];

        for (int i = 0; i < nums1.length; i++) {
            vec[i][0] = nums2[i];
            vec[i][1] = nums1[i];
        }

        // sort according to the second value in vec and that too is descending order
        Arrays.sort(vec, (a, b) -> b[0] - a[0]);

        long ans = 0;
        long curr_sum = 0;

        // pq for deleting the smallest element everytime.
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < k - 1; i++) {
            curr_sum += vec[i][1];
            pq.offer(vec[i][1]);
        }

        for (int i = k - 1; i < nums1.length; i++) {
            curr_sum += vec[i][1];
            pq.offer(vec[i][1]);

            ans = Math.max(ans, curr_sum * vec[i][0]);

            curr_sum -= pq.poll();
        }

        return ans;
    }
}
