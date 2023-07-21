//https://leetcode.com/problems/task-scheduler/description/?envType=study-plan&id=level-2

import java.util.Arrays;

public class Task_Scheduler {
    public static void main(String[] args) {
        char[] tasks = { 'A', 'A', 'A', 'B', 'B', 'B' };
        int n = 2;
        System.out.println(leastInterval(tasks, n));
    }

    public static int leastInterval(char[] tasks, int n) {
        int[] char_counts = new int[26];

        for (char ch : tasks) {
            char_counts[ch - 'A']++;
        }

        Arrays.sort(char_counts);
        int max_value = char_counts[25] - 1;
        int idle_slots = max_value * n;

        for (int i = 24; i >= 0; i--) {
            idle_slots -= Math.min(char_counts[i], max_value);
        }

        return idle_slots > 0 ? idle_slots + tasks.length : tasks.length;
    }
}
