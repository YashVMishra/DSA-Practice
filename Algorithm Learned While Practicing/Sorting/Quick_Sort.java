// when taking pivot as mid then see the notes or KK video
// when taking pivot as last element then see GFG article on quick sort

import java.util.Arrays;

public class Quick_Sort {
    public static void main(String[] args) {
        int[] arr = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        sort_2(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    // taking mid as pivot.
    public static void sort_1(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }

        int start = low;
        int end = high;
        int mid = start + (end - start) / 2;
        int pivot = arr[mid];

        while (arr[start] < pivot) {
            start++;
        }

        while (arr[end] > pivot) {
            end--;
        }

        if (start <= end) {
            swap(arr, start, end);
            start++;
            end--;
        }

        sort_1(arr, low, end);
        sort_1(arr, start, high);
    }

    public static void sort_2(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            sort_2(arr, low, pi - 1);
            sort_2(arr, pi + 1, high);
        }
    }

    // we are doing partition in the above method but there might be sometimes that
    // you need to implement the partition method so in that case take pivot as last
    // element.
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int index = low - 1;

        for (int i = low; i < high; i++) {
            if (arr[i] < pivot) {
                index++;

                swap(arr, index, i);
            }
        }

        swap(arr, index + 1, high);

        return (index + 1);
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
