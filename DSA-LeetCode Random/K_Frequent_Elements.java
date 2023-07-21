//https://leetcode.com/problems/top-k-frequent-elements/description/

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class K_Frequent_Elements {
    public static void main(String[] args) {
        int[] arr = { 1, 1, 1, 2, 2, 3 };
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent(arr, k)));
    }

    // not using O(n log n) TC.
    public static int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];

        Map<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            }

            else {
                map.put(i, 1);
            }
        }

        int index = 0;
        while (k > 0) {
            int maxValueInMap = (Collections.max(map.values()));

            for (int i : nums) {
                if (map.get(i) == maxValueInMap) {
                    ans[index] = i;
                    index++;
                    map.put(i, 0);
                    k--;
                    break;
                }
            }

        }

        return ans;
    }

    // using HashMap and Priority Queue.
    public static int[] topKFrequent_2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            }

            else {
                map.put(i, 1);
            }
        }

        // given lambda function ensures that the elements with least frequency appear
        // at the top of the PQ.
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));

        // adding the elements in the PQ and as soon as it reaches size k
        // we remove the element at the top and that element will be the one
        // with least frequency.
        for (int key : map.keySet()) {
            pq.add(key);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[] ans = new int[k];
        int index = 0;

        while (!pq.isEmpty()) {
            ans[index] = pq.poll();
            index++;
        }

        return ans;
    }
}
