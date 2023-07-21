//https://leetcode.com/problems/ipo/description/

import java.util.PriorityQueue;

public class IPO {
    public static void main(String[] args) {
        int k = 2;
        int w = 0;
        int[] profits = { 1, 2, 3 };
        int[] capital = { 0, 1, 1 };
        System.out.println(findMaximizedCapital(k, w, profits, capital));
    }

    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;

        // profit, capital
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        for (int i = 0; i < n; i++) {
            pq.add(new int[] { profits[i], capital[i] });
        }

        // maintaining maxpq for selection of projects which can be taken
        // form current capital w.
        PriorityQueue<int[]> maxpq = new PriorityQueue<>((a, b) -> (b[0] - a[0]));

        while ((!pq.isEmpty() || !maxpq.isEmpty()) && k > 0) {
            if (!pq.isEmpty() && pq.peek()[1] <= w) {
                maxpq.add(pq.poll());
            }

            else {
                if (!maxpq.isEmpty()) {
                    w += maxpq.poll()[0];
                    k--;
                }

                else {
                    break;
                }
            }
        }

        return w;
    }
}
