// https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/description/?envType=daily-question&envId=2023-09-18

import java.util.Arrays;
import java.util.PriorityQueue;

public class The_K_Weakest_Rows_in_a_Matrix {
    public static void main(String[] args) {
        int[][] mat = { { 1, 1, 0, 0, 0 },
                { 1, 1, 1, 1, 0 },
                { 1, 0, 0, 0, 0 },
                { 1, 1, 0, 0, 0 },
                { 1, 1, 1, 1, 1 } };
        int k = 3;
        System.out.println(Arrays.toString(kWeakestRows(mat, k)));
        System.out.println(Arrays.toString(kWeakestRows_2(mat, k)));
    }

    public static int[] kWeakestRows(int[][] mat, int k) {
        int[] ans = new int[k];
        int[][] strength = new int[mat.length][2];

        for (int i = 0; i < mat.length; i++) {
            strength[i][0] = i;
            strength[i][1] = count(mat[i]);
        }

        Arrays.sort(strength, (a, b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });

        for (int i = 0; i < k; i++) {
            ans[i] = strength[i][0];
        }

        return ans;
    }

    // you can use linear search as well
    // but we have used binary search.
    public static int count(int[] arr) {

        // always keep index as -1 coz atlast you are
        // returning index + 1, so if the count is 0
        // then also it will return 1.
        int index = -1;
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == 1) {
                index = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return index + 1;
    }

    // --------------------------------------------------------------------------------------

    public static int[] kWeakestRows_2(int[][] mat, int k) {

        // whenever we are finding smallest or minimum
        // then use max-heap
        // Rule : Take the opposite of the given ques.
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] != b[1] ? b[1] - a[1] : b[0] - a[0]);

        for (int i = 0; i < mat.length; i++) {
            pq.offer(new int[] { i, count(mat[i]) });

            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[] ans = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            ans[i] = pq.poll()[0];
        }

        return ans;
    }
}
