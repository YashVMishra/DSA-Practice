import java.util.Arrays;

public class Selection_Sort {
    public static void main(String[] args) {
        int[] arr = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        int end = arr.length - 1;

        while (end >= 0) {
            int maxIndex = max(arr, 0, end);
            swap(arr, maxIndex, end);
            end--;
        }

        // same loop as above just using for.

        // for (int i = 0; i < arr.length; i++) {
        // int last = arr.length - i - 1;
        // int maxIndex = max(arr, 0, last);
        // swap(arr, last, maxIndex);
        // }
    }

    public static int max(int[] arr, int start, int end) {
        int index = 0;

        for (int i = start; i <= end; i++) {
            if (arr[i] > arr[index]) {
                index = i;
            }
        }

        return index;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
