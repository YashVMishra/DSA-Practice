//https://leetcode.com/problems/jump-game-iv/description/

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;

public class Jump_Game_4 {
    public static void main(String[] args) {
        int[] arr = { 100, -23, -23, 404, 100, 23, 23, 23, 3, 404 };
        System.out.println(minJumps(arr));
    }

    public static int minJumps(int[] arr) {
        int len = arr.length;

        if (len == 1) {
            return 0;
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        int steps = 0;

        // fill the map
        for (int i = 0; i < len; i++) {
            if (map.containsKey(arr[i])) {
                map.get(arr[i]).add(i);
            }

            else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(arr[i], list);
            }
        }

        // System.out.println(map);

        Queue<Integer> q = new LinkedList<>();
        q.offer(0);

        while (!q.isEmpty()) {
            steps++;
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int j = q.poll();

                // jumping to j-1.s
                if (j - 1 >= 0 && map.containsKey(arr[j - 1])) {
                    q.offer(j - 1);
                }

                // jumping to j+1.
                if (j + 1 < len && map.containsKey(arr[j + 1])) {
                    if (j + 1 == len - 1) {
                        return steps;
                    }

                    q.offer(j + 1);
                }

                // jumping to index where arr[i]==arr[j] & i!=j
                if (map.containsKey(arr[j])) {
                    for (int k : map.get(arr[j])) {
                        if (k != j) {
                            if (k == len - 1) {
                                return steps;
                            }

                            q.offer(k);
                        }
                    }
                }

                // very imp line.
                map.remove(arr[j]);
            }
        }

        return steps;
    }
}
