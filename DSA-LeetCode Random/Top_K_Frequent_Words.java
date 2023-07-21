//https://leetcode.com/problems/top-k-frequent-words/description/?envType=study-plan&id=level-1

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Top_K_Frequent_Words {
    public static void main(String[] args) {
        String[] words = { "i", "love", "leetcode", "i", "love", "coding" };
        int k = 2;
        System.out.println(topKFrequent(words, k));
    }

    public static List<String> topKFrequent(String[] words, int k) {

        // add th the HashMap.
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        // very imp
        // learn about comparator.
        Queue<String> q = new PriorityQueue<>(
                (w1, w2) -> map.get(w1).equals(map.get(w2)) ? w2.compareTo(w1) : map.get(w1) - map.get(w2));

        // adding to the heap.
        for (String word : map.keySet()) {
            q.add(word);
            if (q.size() > k) {
                q.poll();
            }
        }

        // add to the result
        List<String> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            ans.add(q.poll());
        }

        Collections.reverse(ans);
        return ans;

    }
}
