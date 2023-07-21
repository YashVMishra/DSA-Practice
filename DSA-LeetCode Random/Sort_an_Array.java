//https://leetcode.com/problems/sort-an-array/description/

import java.util.Arrays;

public class Sort_an_Array {
    public static void main(String[] args) {
        int[] arr = { 5, 2, 3, 1 };
        System.out.println(Arrays.toString(sortArray(arr)));
    }

    public static int[] sortArray(int[] arr) {
        if (arr.length == 1) {
            return arr;
        }

        int mid = arr.length / 2;

        int[] left = sortArray(Arrays.copyOfRange(arr, 0, mid));
        int[] right = sortArray(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(left, right);
    }

    public static int[] merge(int[] first, int[] second) {
        int i = 0;
        int j = 0;
        int k = 0;

        int[] arr = new int[first.length + second.length];

        while (i < first.length && j < second.length) {
            if (first[i] < second[j]) {
                arr[k] = first[i];
                i++;
                k++;
            }

            else {
                arr[k] = second[j];
                j++;
                k++;
            }
        }

        while (i < first.length) {
            arr[k] = first[i];
            k++;
            i++;
        }

        while (j < second.length) {
            arr[k] = second[j];
            k++;
            j++;
        }

        return arr;

    }
}
