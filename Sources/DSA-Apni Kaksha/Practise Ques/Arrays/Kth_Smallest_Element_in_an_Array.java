//https://practice.geeksforgeeks.org/problems/kth-smallest-element5635/1

import java.util.Collections;
import java.util.PriorityQueue;

class Kth_Smallest_Element_in_an_Array {
    public static void main(String[] args) {
        System.out.println(findKthSmallest(new int[] { 3, 2, 1, 5, 6, 4 }, 3));
    }

    public static int findKthSmallest(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < k; i++) {
            pq.add(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            if (pq.peek() > nums[i]) {
                pq.poll();
                pq.add(nums[i]);
            }
        }

        return pq.peek();
    }
}