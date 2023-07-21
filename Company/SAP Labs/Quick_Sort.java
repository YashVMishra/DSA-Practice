import java.util.Arrays;

public class Quick_Sort {
    public static void main(String[] args) {
        int[] arr = { 3, 2, 5, 7, 1, 9 };
        // sort(arr, 0, arr.length - 1);
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    // uses pivot as last element.

    // Function to sort an array using quick sort algorithm.
    public static void quickSort(int arr[], int low, int high) {
        // code here
        if (low < high) {
            int index = partition(arr, low, high);
            quickSort(arr, low, index - 1);
            quickSort(arr, index + 1, high);
        }
    }

    public static int partition(int arr[], int low, int high) {
        // your code here
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }

    // uses pivot element as middle element
    // done in only single function.

    public static void sort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }

        int i = low;
        int j = high;
        int pivot = arr[low + (high - low) / 2];

        while (arr[i] < pivot) {
            i++;
        }

        while (arr[j] > pivot) {
            j--;
        }

        if (i <= j) {
            swap(arr, i, j);
            i++;
            j--;
        }

        sort(arr, low, j);
        sort(arr, i, high);
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
