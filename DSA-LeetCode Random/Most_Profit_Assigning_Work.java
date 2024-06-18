// https://leetcode.com/problems/most-profit-assigning-work/description/?envType=daily-question&envId=2024-06-18

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Most_Profit_Assigning_Work {
    public static void main(String[] args) {
        int[] difficulty = { 2, 4, 6, 8, 10 };
        int[] profit = { 10, 20, 30, 40, 50 };
        int[] worker = { 4, 5, 6, 7 };

        System.out.println(maxProfitAssignment(difficulty, profit, worker));
        System.out.println(maxProfitAssignment_2(difficulty, profit, worker));
        System.out.println(maxProfitAssignment_3(difficulty, profit, worker));
    }

    public static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int m = worker.length;

        // Create a max-heap using a priority queue
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]); // Max-heap by profit

        for (int i = 0; i < n; i++) {
            int diff = difficulty[i];
            int prof = profit[i];

            pq.offer(new int[] { prof, diff });
        }

        // Sort worker array in descending order
        Arrays.sort(worker);
        for (int i = 0; i < worker.length / 2; i++) {
            int temp = worker[i];
            worker[i] = worker[worker.length - 1 - i];
            worker[worker.length - 1 - i] = temp;
        }

        int i = 0;
        int totalProfit = 0;
        while (i < m && !pq.isEmpty()) {
            if (pq.peek()[1] > worker[i]) {
                pq.poll();
            } else {
                totalProfit += pq.peek()[0];
                i++;
            }
        }

        return totalProfit;
    }

    public static int maxProfitAssignment_2(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int m = worker.length;

        List<int[]> vec = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            vec.add(new int[] { difficulty[i], profit[i] });
        }

        // Sort the vector based on difficulty
        Collections.sort(vec, (a, b) -> Integer.compare(a[0], b[0]));

        // Pre-processing to find the maximum profit till index i at constant time
        for (int i = 1; i < vec.size(); i++) {
            vec.get(i)[1] = Math.max(vec.get(i)[1], vec.get(i - 1)[1]);
        }

        int totalProfit = 0;
        for (int i = 0; i < m; i++) {
            int workerDiffLevel = worker[i];

            // Apply binary search on vec
            int l = 0, r = vec.size() - 1;
            int maxProfit = 0;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (vec.get(mid)[0] <= workerDiffLevel) {
                    maxProfit = Math.max(maxProfit, vec.get(mid)[1]);
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }

            totalProfit += maxProfit;
        }

        return totalProfit;
    }

    public static int maxProfitAssignment_3(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int m = worker.length;

        // Create an array of pairs to hold difficulty and profit
        int[][] vec = new int[n][2];
        for (int i = 0; i < n; i++) {
            vec[i][0] = difficulty[i];
            vec[i][1] = profit[i];
        }

        // Sort the array based on difficulty
        Arrays.sort(vec, (a, b) -> Integer.compare(a[0], b[0]));

        // Sort the worker array
        Arrays.sort(worker);

        int totalProfit = 0;
        int j = 0; // Pointer to vec array
        int maxProfit = 0;

        for (int i = 0; i < m; i++) {
            while (j < n && worker[i] >= vec[j][0]) {
                maxProfit = Math.max(maxProfit, vec[j][1]);
                j++;
            }
            totalProfit += maxProfit;
        }

        return totalProfit;
    }
}
