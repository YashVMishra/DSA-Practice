// https://leetcode.com/problems/constrained-subsequence-sum/?envType=daily-question&envId=2023-10-21

import java.util.PriorityQueue;

class Pair {
    int first;
    int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class Constrained_Subsequence_Sum {
    public static void main(String[] args) {
        int[] nums = { 10, 2, -10, 5, 20 };
        int k = 2;

        System.out.println(constrainedSubsetSum(nums, k));
    }

    public static int constrainedSubsetSum(int[] nums, int k) {
        int n = nums.length;
        int[] t = new int[n];

        System.arraycopy(nums, 0, t, 0, n);
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(b.first, a.first));
        pq.offer(new Pair(t[0], 0));

        int maxR = t[0];

        for (int i = 1; i < n; i++) {
            while (!pq.isEmpty() && pq.peek().second < i - k) {
                pq.poll();
            }

            t[i] = Math.max(t[i], nums[i] + pq.peek().first);
            pq.offer(new Pair(t[i], i));

            maxR = Math.max(maxR, t[i]);
        }

        return maxR;
    }
}
