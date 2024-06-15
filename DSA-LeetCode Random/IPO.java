//https://leetcode.com/problems/ipo/description/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
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

    // ---------------------------------------------------------------------------------------

    public static int findMaximizedCapital_2(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;

        List<int[]> projects = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            projects.add(new int[] { capital[i], profits[i] });
        }

        projects.sort(Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> maxProfitHeap = new PriorityQueue<>(Collections.reverseOrder());
        int i = 0;

        while (k-- > 0) {
            while (i < n && projects.get(i)[0] <= w) {
                maxProfitHeap.add(projects.get(i)[1]);
                i++;
            }

            if (maxProfitHeap.isEmpty()) {
                break;
            }

            w += maxProfitHeap.poll();
        }

        return w;
    }
}
