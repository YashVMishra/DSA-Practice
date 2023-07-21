//reverse of an array by using both iterative and recursive technique.

import java.util.Arrays;

public class Reverse_Array {
    public static void main(String[] args) {
        int[] arr = { 5, 2, 1, 6, 8, 9, 1 };
        // reverse_iter(arr);
        reverse_recur(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void reverse_iter(int[] arr) {

        for (int i = 0; i < arr.length / 2; i++) {
            swap(arr, i, arr.length - i - 1);
        }
    }

    public static void reverse_recur(int[] arr, int i, int j) {
        if (i > arr.length / 2) {
            return;
        }
        swap(arr, i, j);
        reverse_recur(arr, i + 1, j - 1);
    }
}
