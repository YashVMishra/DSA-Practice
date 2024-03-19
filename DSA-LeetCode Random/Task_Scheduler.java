// https://leetcode.com/problems/task-scheduler/description/?envType=daily-question&envId=2024-03-19

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Task_Scheduler {
    public static void main(String[] args) {
        char[] tasks = { 'A', 'A', 'A', 'B', 'B', 'B' };
        int n = 2;
        System.out.println(leastInterval(tasks, n));
    }

    public static int leastInterval(char[] tasks, int p) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : tasks) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // max heap
        // we want to finish the process which is most occurring (having highest
        // frequency)
        // so that we don't have to finish in the last with p gaps.
        int time = 0;

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            pq.add(entry.getValue());
        }

        while (!pq.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 1; i <= p + 1; i++) {
                // filling first p+1 characters
                if (!pq.isEmpty()) {
                    temp.add(pq.poll() - 1); // finishing one instance of each process
                }
            }

            for (int freq : temp) {
                if (freq > 0)
                    pq.add(freq);
            }

            if (pq.isEmpty()) // all processes finished
                time += temp.size();
            else
                time += (p + 1); // we finished p+1 tasks above in the loop

        }

        return time;
    }
}
