//https://leetcode.com/problems/find-k-pairs-with-smallest-sums/description/

import java.util.*;

public class Find_K_Pairs_with_Smallest_Sums {
    public static void main(String[] args) {
        int[] nums1 = { 1, 7, 11 };
        int[] nums2 = { 2, 4, 6 };
        int k = 3;
        System.out.println(kSmallestPairs(nums1, nums2, k));
    }

    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        Comparator<List<Integer>> compare = (a, b) -> (a.get(0) + a.get(1)) - (b.get(0) + b.get(1));
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>(compare);
        List<List<Integer>> res = new ArrayList<>();

        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return res;
        }

        for (int i = 0; i < nums1.length && i < k; i++) {
            pq.offer(Arrays.asList(nums1[i], nums2[0], 0));
        }

        while (k-- > 0 && !pq.isEmpty()) {
            List<Integer> cur = pq.poll();
            res.add(Arrays.asList(cur.get(0), cur.get(1)));

            if (cur.get(2) == nums2.length - 1) {
                continue;
            }

            pq.offer(Arrays.asList(cur.get(0), nums2[cur.get(2) + 1], cur.get(2) + 1));
        }

        return res;
    }

}
