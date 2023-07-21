import java.util.Arrays;

public class Bubble_Sort {
    public static void main(String[] args) {
        int[] arr = { 4, 3, 2, 1 };
        sort(arr, arr.length - 1, 0);
        System.out.println(Arrays.toString(arr));
    }

    static void sort(int[] arr, int row, int column) {
        if (row == 0) {
            return;
        }

        if (column < row) {
            if (arr[column] > arr[column + 1]) {
                swap(arr, (column + 1), column);
            }
            sort(arr, row, column + 1);
        }

        else {
            sort(arr, row - 1, 0);
        }
    }

    static void swap(int[] arr, int i, int column) {
        int temp = arr[i];
        arr[i] = arr[column];
        arr[column] = temp;
        // return;
    }
}
