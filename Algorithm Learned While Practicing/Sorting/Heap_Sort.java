import java.util.Arrays;

public class Heap_Sort {
    public static void main(String[] args) {
        int[] arr = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void heapSort(int[] arr) {
        buildHeap(arr, arr.length);

        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, i, 0);
            heapify(arr, i, 0);
        }
    }

    public static void buildHeap(int[] arr, int length) {
        for (int i = length / 2 - 1; i >= 0; i--) {
            heapify(arr, length, i);
        }
    }

    public static void heapify(int[] arr, int length, int index) {
        int largest = index;
        int left = index * 2 + 1;
        int right = index * 2 + 2;

        if (left < length && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < length && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != index) {
            swap(arr, index, largest);
            heapify(arr, length, largest);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
