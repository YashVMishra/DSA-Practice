// https://leetcode.com/problems/sliding-window-maximum/description/

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.PriorityQueue;

public class Sliding_Window_Maximum {
    public static void main(String[] args) {
        int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;
        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
        System.out.println(Arrays.toString(maxSlidingWindow_2(nums, k)));
    }

    // shows TLE.
    public static int[] maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            list.add(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            int element = max(list);
            temp.add(element);
            list.remove(0);
            list.add(nums[i]);
        }

        temp.add(max(list));

        int[] ans = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            ans[i] = temp.get(i);
        }

        return ans;
    }

    public static int max(ArrayList<Integer> list) {
        int max = Integer.MIN_VALUE;

        for (int i : list) {
            max = Math.max(i, max);
        }

        return max;
    }

    public static int[] maxSlidingWindow_2(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        ArrayList<Integer> temp = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            pq.add(nums[i]);
        }

        int start = 0;
        int end = k;

        while (end < nums.length) {
            temp.add(pq.peek());
            pq.remove(nums[start]);
            pq.add(nums[end]);
            end++;
            start++;
        }

        temp.add(pq.peek());

        int[] ans = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            ans[i] = temp.get(i);
        }

        return ans;
    }

    public static int[] maxSlidingWindow_3(int[] nums, int k) {
        Deque<Integer> q = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            while (!q.isEmpty() && nums[q.peekLast()] <= nums[i]) {
                q.pollLast();
            }

            q.offerLast(i);

            if (q.peekFirst() == i - k) {
                q.pollFirst();
            }

            if (i >= k - 1) {
                res.add(nums[q.peekFirst()]);
            }
        }

        int[] resultArray = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            resultArray[i] = res.get(i);
        }

        return resultArray;
    }
}
