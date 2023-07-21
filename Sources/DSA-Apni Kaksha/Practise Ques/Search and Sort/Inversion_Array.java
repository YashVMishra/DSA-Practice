//https://practice.geeksforgeeks.org/problems/inversion-of-array-1587115620/1

import java.util.Arrays;

public class Inversion_Array {
    public static void main(String[] args) {
        long[] arr = { 2, 3, 4, 5, 6 };
        System.out.println(inversionsCount(arr));

        // be cautious of the datatype while pasting this code as instead of int, long
        // might be used.
        System.out.println(mergeSortAndCount(arr, 0, arr.length - 1));
    }

    // uses O(n^2) complexity.
    public static long inversionsCount(long[] arr) {
        int size = arr.length;
        long count = 0;

        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (arr[i] > arr[j] && i < j) {
                    count++;
                }
            }
        }

        return count;
    }

    // uses enhanced merge sort so the complexity is O(nlogn)
    public static int mergeSortAndCount(long[] arr, int l, int r) {

        // Keeps track of the inversion count at a
        // particular node of the recursion tree
        int count = 0;

        if (l < r) {
            int m = (l + r) / 2;

            // Total inversion count = left subarray count
            // + right subarray count + merge count

            // Left subarray count
            count += mergeSortAndCount(arr, l, m);

            // Right subarray count
            count += mergeSortAndCount(arr, m + 1, r);

            // Merge count
            count += mergeAndCount(arr, l, m, r);
        }

        return count;
    }

    public static int mergeAndCount(long[] arr, int l, int m, int r) {

        // Left subarray
        long[] left = Arrays.copyOfRange(arr, l, m + 1);

        // Right subarray
        long[] right = Arrays.copyOfRange(arr, m + 1, r + 1);

        int i = 0, j = 0, k = l, swaps = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            }

            else {
                arr[k++] = right[j++];
                swaps += (m + 1) - (l + i);
            }
        }

        while (i < left.length)
            arr[k++] = left[i++];

        while (j < right.length)
            arr[k++] = right[j++];

        return swaps;
    }

}
