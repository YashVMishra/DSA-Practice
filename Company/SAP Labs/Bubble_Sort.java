// https://practice.geeksforgeeks.org/problems/bubble-sort/1?page=1&company[]=SAP%20Labs&sortBy=submissions

import java.util.Arrays;

public class Bubble_Sort {
    public static void main(String[] args) {
        int[] arr = { 4, 1, 3, 9, 7 };
        bubbleSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int arr[], int n) {
        // code here
        boolean swapped = false;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j - 1] > arr[j]) {
                    swap(j - 1, j, arr);
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }

    public static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
