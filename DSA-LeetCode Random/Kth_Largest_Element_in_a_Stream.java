//https://leetcode.com/problems/kth-largest-element-in-a-stream/description/

import java.util.PriorityQueue;

public class Kth_Largest_Element_in_a_Stream {
    public static void main(String[] args) {
        int k = 3;
        int[] nums = { 4, 5, 8, 2 };
        KthLargest ob = new KthLargest(k, nums);
        System.out.println(ob.add(3));
        System.out.println(ob.add(5));
        System.out.println(ob.add(10));
        System.out.println(ob.add(9));
        System.out.println(ob.add(4));
    }
}

class KthLargest {
    int k;
    PriorityQueue<Integer> heap;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        heap = new PriorityQueue<Integer>();

        for (int num : nums) {
            heap.offer(num);
        }

        while (heap.size() > k) {
            heap.poll();
        }
    }

    public int add(int val) {
        heap.offer(val);

        // we have written a while loop cause if the nums.length==0
        // then the peek method will return an exception.
        while (heap.size() > k) {
            heap.poll();
        }

        return heap.peek();
    }
}