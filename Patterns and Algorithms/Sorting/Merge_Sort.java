// for implementation see KK video or Notes.

import java.util.Arrays;

public class Merge_Sort {
    public static void main(String[] args) {
        int[] arr = { 3, 5, 1, 8, 3, 9, 11, 0 };
        System.out.println(Arrays.toString(mergeSort(arr)));
    }

    public static int[] mergeSort(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }

        int mid = arr.length / 2;

        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(left, right);
    }

    public static int[] merge(int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        int[] ans = new int[left.length + right.length];

        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                ans[k] = left[i];
                i++;
                k++;
            } else {
                ans[k] = right[j];
                k++;
                j++;
            }
        }

        while (i < left.length) {
            ans[k] = left[i];
            i++;
            k++;
        }

        while (j < right.length) {
            ans[k] = right[j];
            j++;
            k++;
        }

        return ans;
    }
}
