// https://leetcode.com/problems/total-cost-to-hire-k-workers/description/?envType=study-plan-v2&envId=leetcode-75

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Total_Cost_to_Hire_K_Workers {
    public static void main(String[] args) {
        int[] costs = { 17, 12, 10, 2, 7, 2, 11, 20, 8 };
        int k = 3, candidates = 4;
        System.out.println(totalCost(costs, k, candidates));
        System.out.println(totalCost_2(costs, k, candidates));
    }

    // shows TLE.
    public static long totalCost(int[] costs, int k, int candidates) {
        long sum = 0;

        // make an list with all the elements of the costs array and we have
        // to delete the array elements.
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i : costs) {
            list.add(i);
        }

        for (int i = 0; i < k; i++) {

            // if the array size is less than or equal to the candidate then we have
            // search the whole array.
            if (list.size() <= candidates) {

                // minIndex returns the index of the min value from the list.
                int minCostIndex = minIndex(list, 0, list.size() - 1);
                sum += list.get(minCostIndex);

                // removing the value as we do not want that value again.
                list.remove(minCostIndex);
            }

            else {

                // taking the index of min value from left and right.
                // start and stop of the minIndex function is easy just take paper and
                // pen and try figuring it out.
                int minCostIndexLeft = minIndex(list, 0, candidates - 1);
                int minCostIndexRight = minIndex(list, list.size() - candidates, list.size() - 1);

                // taking the min index value from the above variables.
                int minCostIndex = list.get(minCostIndexRight) < list.get(minCostIndexLeft) ? minCostIndexRight
                        : minCostIndexLeft;

                sum += list.get(minCostIndex);

                // removing the value.
                list.remove(minCostIndex);
            }
        }

        return sum;
    }

    // gives the index of the min value in the list.
    public static int minIndex(ArrayList<Integer> list, int start, int stop) {
        int ans = start;
        for (int i = start; i <= stop; i++) {
            if (list.get(ans) > list.get(i)) {
                ans = i;
            }
        }

        return ans;
    }

    // -------------------------------------------------------------------------------------

    public static long totalCost_2(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();
        long ans = 0;
        int cnt = 0, i = 0, j = costs.length - 1;

        while (cnt < k) {

            // for i<=j watch the video provided in the notes
            while (pq1.size() < candidates && i <= j) {
                pq1.offer(costs[i++]);
            }

            // for j>=i watch the video provided in the notes
            while (pq2.size() < candidates && j >= i) {
                pq2.offer(costs[j--]);
            }

            int min1 = pq1.size() > 0 ? pq1.peek() : Integer.MAX_VALUE;
            int min2 = pq2.size() > 0 ? pq2.peek() : Integer.MAX_VALUE;

            if (min1 <= min2) {
                ans += min1;
                pq1.poll();
            } else {
                ans += min2;
                pq2.poll();
            }

            cnt++;
        }

        return ans;
    }
}
