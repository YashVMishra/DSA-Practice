// https://leetcode.com/problems/restore-the-array-from-adjacent-pairs/description/?envType=daily-question&envId=2023-11-10

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Restore_the_Array_From_Adjacent_Pairs {
    public static void main(String[] args) {
        int[][] adjacentPairs = { { 2, 1 }, { 3, 4 }, { 3, 2 } };
        int[] result = restoreArray(adjacentPairs);

        System.out.println(Arrays.toString(result));
    }

    public static int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int[] pair : adjacentPairs) {
            map.putIfAbsent(pair[0], new ArrayList<>());
            map.putIfAbsent(pair[1], new ArrayList<>());

            map.get(pair[0]).add(pair[1]);
            map.get(pair[1]).add(pair[0]);
        }

        // iterate over the map to find the starting point.
        int root = 0;
        for (int num : map.keySet()) {
            if (map.get(num).size() == 1) {
                root = num;
                break;
            }
        }

        int[] result = new int[map.size()];
        dfs(root, result, map, Integer.MAX_VALUE, 0);
        return result;
    }

    private static void dfs(int root, int[] result, Map<Integer, List<Integer>> map, int prev, int index) {
        result[index] = root;

        for (int num : map.get(root)) {
            if (num != prev) {
                dfs(num, result, map, root, index + 1);
            }
        }
    }
}
