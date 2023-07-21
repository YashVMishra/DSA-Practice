import java.util.Arrays;

public class Quick_Sort {
    public static void main(String[] args) {
        int[] arr = { 5, 4, 3, 2, 1, 8, 1, 9, 3, 6, 2, 9, 5, 1, };
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    static void sort(int[] arr, int low, int high) {
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

            // important lines.
            start++;
            end--;
        }

        // very important (partition of array).
        sort(arr, low, end);
        sort(arr, start, high);
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
