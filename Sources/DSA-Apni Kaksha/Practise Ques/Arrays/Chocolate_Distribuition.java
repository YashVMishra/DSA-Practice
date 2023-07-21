//https://www.geeksforgeeks.org/chocolate-distribution-problem/

import java.util.Arrays;

public class Chocolate_Distribuition {
    public static void main(String[] args) {
        System.out.println(minDiff(new int[] { 7, 3, 2, 4, 9, 12, 56 }, 3));
    }

    public static int minDiff(int[] arr, int m) {
        Arrays.sort(arr);

        int min_diff = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length - m - 1; i++) {
            min_diff = Math.min(min_diff, arr[i + m - 1] - arr[i]);
        }

        return min_diff;
    }
}
