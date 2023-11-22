// https://leetcode.com/problems/diagonal-traverse-ii/description/?envType=daily-question&envId=2023-11-22

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Diagonal_Traverse_2 {
    public static void main(String[] args) {
        List<List<Integer>> nums = new ArrayList<>();
        nums.add(Arrays.asList(1, 2, 3, 4, 5));
        nums.add(Arrays.asList(6, 7));
        nums.add(Arrays.asList(8));
        nums.add(Arrays.asList(9, 10, 11));
        nums.add(Arrays.asList(12, 13, 14, 15, 16));

        System.out.println(Arrays.toString(findDiagonalOrder(nums)));
    }

    public static int[] findDiagonalOrder(List<List<Integer>> nums) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int size = 0;

        // we have started from the last row as we want the elements
        // in the order of the diagonal and the last row will have the
        // elements which are at the bottom of the diagonal and we want
        // them first in the answer.

        // using the fact that the sum of row and col
        // is same for the elements in the diagonal.
        for (int i = nums.size() - 1; i >= 0; i--) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                int key = i + j;

                map.putIfAbsent(key, new ArrayList<>());
                map.get(key).add(nums.get(i).get(j));
                size++;
            }
        }

        int[] ans = new int[size];
        int index = 0;

        for (int i = 0; i < map.size(); i++) {
            for (int val : map.get(i)) {
                ans[index++] = val;
            }
        }

        return ans;
    }

    public static int[] findDiagonalOrder_2(List<List<Integer>> nums) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { 0, 0 });
        List<Integer> list = new ArrayList<>();

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int row = temp[0];
            int col = temp[1];

            list.add(nums.get(row).get(col));

            if (col == 0 && row + 1 < nums.size()) {
                queue.add(new int[] { row + 1, col });
            }

            if (col + 1 < nums.get(row).size()) {
                queue.add(new int[] { row, col + 1 });
            }
        }

        int[] result = new int[list.size()];
        int i = 0;

        for (int num : list) {
            result[i] = num;
            i++;
        }

        return result;
    }
}
