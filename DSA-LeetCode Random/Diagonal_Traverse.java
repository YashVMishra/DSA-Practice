// https://leetcode.com/problems/diagonal-traverse/description/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Diagonal_Traverse {
    public static void main(String[] args) {
        int[][] mat = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

        System.out.println(Arrays.toString(findDiagonalOrder(mat)));
    }

    public static int[] findDiagonalOrder(int[][] mat) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int size = 0;

        // we can start from first row or last row, it doesn't matter
        // if the sum of row and col is even we have to add the
        // element at the end of the list and if it is odd
        // we have to add the element at the start of the list.
        // this is due to the direction of the diagonal.
        for (int i = mat.length - 1; i >= 0; i--) {
            for (int j = 0; j < mat[i].length; j++) {
                int key = i + j;

                map.putIfAbsent(key, new ArrayList<>());

                if (key % 2 == 0) {
                    map.get(key).add(mat[i][j]);
                } else {
                    map.get(key).add(0, mat[i][j]);
                }

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
}
