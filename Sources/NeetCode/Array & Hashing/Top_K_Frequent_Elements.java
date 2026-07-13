import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Top_K_Frequent_Elements {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 1, 2, 1, 2, 3, 1, 3, 2 };
        int k = 2;

        System.out.println(Arrays.toString(topKFrequent(nums, k)));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[] {};
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[k];

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // using Min Heap here because, the element with the lowest
        // frequency is always at the top. Popping it ensures that
        // lower-frequency elements are discarded, leaving only the
        // K highest-frequency elements in the heap at the end.
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));

        for (int key : map.keySet()) {
            minHeap.add(key);

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // since we are making sure minHeap is always
        // of size k, so we dont have to check for
        // minHeap.isEmpty()
        for (int i = 0; i < k; i++) {
            ans[i] = minHeap.poll();
        }

        return ans;
    }
}
