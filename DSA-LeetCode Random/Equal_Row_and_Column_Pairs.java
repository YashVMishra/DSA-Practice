//https://leetcode.com/problems/equal-row-and-column-pairs/description/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Equal_Row_and_Column_Pairs {
    public static void main(String[] args) {
        int[][] grid = { { 3, 1, 2, 2 }, { 1, 4, 4, 5 }, { 2, 4, 2, 2 }, { 2, 4, 2, 2 } };
        System.out.println(equalPairs(grid));
    }

    // brute force
    // comparing each row and each column elements.
    public static int equalPairs(int[][] grid) {
        int count = 0;
        int len = grid.length;

        // TC - O(n ^3)
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                boolean match = true;

                for (int k = 0; k < len; k++) {
                    if (grid[i][k] != grid[k][j]) {
                        match = false;
                        break;
                    }
                }

                count += match ? 1 : 0;
            }
        }

        return count;
    }

    // make the transpose of the matrix and then compare each row of the
    // two grids.
    public static int equalPairs_2(int[][] grid) {
        int count = 0;
        int[][] temp = new int[grid.length][grid[0].length];

        // making transpose of the given grid.
        for (int i = 0; i < grid[0].length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                temp[i][j] = grid[j][i];
            }
        }

        // comparing the two 2-D arrays.
        for (int[] arr1 : grid) {
            for (int[] arr2 : temp) {
                if (Arrays.equals(arr1, arr2)) {
                    count++;
                }
            }
        }

        return count;
    }

    // using HashMap
    // Both second and third method gives the same TC.
    /*
     * Algorithm
     * Create an empty hash map row_counter and set count to 0.
     * 
     * For each row row in the grid, convert it into an equivalent hashable object
     * and use it as a key to the row_counter. Increment the value of the
     * corresponding key by 1.
     * 
     * For each column in the grid, convert it into the same type of hashable object
     * and check if it appears in the row_counter. If it does, increment count by
     * the frequency.
     * 
     * Return the answer count.
     */
    public static int equalPairs_3(int[][] grid) {
        int count = 0;
        int len = grid.length;
        Map<String, Integer> map = new HashMap<>();

        for (int[] arr : grid) {
            String rowString = Arrays.toString(arr);

            map.put(rowString, 1 + map.getOrDefault(rowString, 0));
        }

        for (int col = 0; col < len; col++) {
            int[] colArr = new int[len];

            for (int row = 0; row < len; row++) {
                colArr[row] = grid[row][col];
            }

            count += map.getOrDefault(Arrays.toString(colArr), 0);
        }

        return count;
    }
}
