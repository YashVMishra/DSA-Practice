import java.util.Arrays;

public class Selection_Sort {
    public static void main(String[] args) {
        int[] arr = { 4, 3, 2, 1 };
        sort2(arr, arr.length - 1, 0, 0);
        System.out.println(Arrays.toString(arr));
    }

    static void sort(int[] arr, int i, int j, int max) {
        if (i == 0) {
            return;
        }

        if (j < i) {
            if (arr[j] < arr[j + 1]) {
                max = j + 1;
            }
            sort(arr, i, j + 1, max);
        }

        else {
            swap(arr, i, max);
            sort(arr, i - 1, 0, 0);
        }
    }

    static void swap(int[] arr, int i, int column) {
        int temp = arr[i];
        arr[i] = arr[column];
        arr[column] = temp;
        // return;
    }

    static void sort2(int[] arr, int i, int j, int max) {
        if (i == 0) {
            return;
        }

        if (j < i) {
            if (arr[j] > arr[max]) {
                sort(arr, i, j + 1, j);
            }

            else {
                sort(arr, i, j + 1, max);
            }
        }

        else {
            swap(arr, i, max);
            sort(arr, i - 1, 0, 0);
        }
    }
}
