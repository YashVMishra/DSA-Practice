// https://leetcode.com/problems/maximum-subsequence-score/description/?envType=study-plan-v2&envId=leetcode-75

import java.util.Arrays;
import java.util.PriorityQueue;

public class Maximum_Subsequence_Score {
    public static void main(String[] args) {
        int[] nums1 = { 4, 2, 3, 1, 1 };
        int[] nums2 = { 7, 5, 10, 9, 6 };
        int k = 1;

        System.out.println(maxScore(nums1, nums2, k));
    }

    public static long maxScore(int[] nums1, int[] nums2, int k) {
        int[][] temp = new int[nums1.length][2];
        for (int i = 0; i < nums1.length; i++) {
            temp[i][0] = nums1[i];
            temp[i][1] = nums2[i];
        }

        // sorting the array acc to nums2 elements in descending order.
        Arrays.sort(temp, (a, b) -> Integer.compare(b[1], a[1]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long kSum = 0;

        // finding the result of first k elements of temp array.
        for (int i = 0; i < k; i++) {
            kSum += temp[i][0];
            pq.add(temp[i][0]);
        }

        long result = kSum * temp[k - 1][1];

        for (int i = k; i < temp.length; i++) {
            kSum += temp[i][0] - pq.poll();
            pq.add(temp[i][0]);

            result = Math.max(result, kSum * temp[i][1]);
        }

        return result;
    }
}
