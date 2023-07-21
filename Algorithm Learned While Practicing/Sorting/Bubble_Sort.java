import java.util.Arrays;

public class Bubble_Sort {
    public static void main(String[] args) {
        int[] arr = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean swapped = false;

            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j - 1] > arr[j]) {
                    swapped = true;
                    swap(arr, j - 1, j);
                }
            }

            if (!swapped) {
                break;
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
