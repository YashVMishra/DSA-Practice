// https://leetcode.com/problems/largest-submatrix-with-rearrangements/description/?envType=daily-question&envId=2023-11-26

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Largest_Submatrix_With_Rearrangements {
    public static void main(String[] args) {
        int[][] matrix = { { 0, 0, 1 }, { 1, 1, 1 }, { 1, 0, 1 } };
        System.out.println(largestSubmatrix(matrix));
        System.out.println(largestSubmatrix_2(matrix));
        System.out.println(largestSubmatrix_3(matrix));
    }

    public static int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int result = 0;

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (matrix[row][col] != 0 && row > 0) {
                    matrix[row][col] += matrix[row - 1][col];
                }
            }

            int[] currRow = matrix[row].clone();
            Arrays.sort(currRow);
            for (int col = 0; col < n; col++) {
                int base = (n - col);
                int height = currRow[col];
                result = Math.max(result, base * height);
            }
        }

        return result;
    }

    // ---------------------------------------------------------------------------------

    public static int largestSubmatrix_2(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] prevRow = new int[n];
        int result = 0;

        for (int row = 0; row < m; row++) {
            int[] currRow = matrix[row].clone();
            for (int col = 0; col < n; col++) {
                if (currRow[col] != 0) {
                    currRow[col] += prevRow[col];
                }
            }

            int[] sortedRow = currRow.clone();
            Arrays.sort(sortedRow);
            for (int i = 0; i < n; i++) {
                int base = (n - i);
                int height = sortedRow[i];
                result = Math.max(result, base * height);
            }

            prevRow = currRow;
        }

        return result;
    }

    // ---------------------------------------------------------------------------------

    static class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    public static int largestSubmatrix_3(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Pair<Integer, Integer>> prevHeights = new ArrayList<>();
        int result = 0;

        for (int row = 0; row < m; row++) {
            List<Pair<Integer, Integer>> heights = new ArrayList<>();
            boolean[] seen = new boolean[n];

            for (Pair<Integer, Integer> entry : prevHeights) {
                int height = entry.getKey();
                int col = entry.getValue();
                if (matrix[row][col] == 1) {
                    heights.add(new Pair<>(height + 1, col));
                    seen[col] = true;
                }
            }

            for (int col = 0; col < n; col++) {
                if (!seen[col] && matrix[row][col] == 1) {
                    heights.add(new Pair<>(1, col));
                }
            }

            for (int i = 0; i < heights.size(); i++) {
                int base = i + 1;
                int height = heights.get(i).getKey();
                result = Math.max(result, base * height);
            }

            prevHeights = heights;
        }

        return result;
    }
}
