//https://leetcode.com/problems/kth-largest-element-in-an-array/

import java.util.PriorityQueue;

public class Kth_Largest_Element_in_an_Array {
    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[] { 3, 2, 1, 5, 6, 4 }, 2));
    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < k; i++) {
            pq.add(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            if (pq.peek() < nums[i]) {
                pq.poll();
                pq.add(nums[i]);
            }
        }

        return pq.peek();
    }
}
