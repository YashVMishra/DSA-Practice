//https://practice.geeksforgeeks.org/problems/move-all-zeroes-to-end-of-array0751/1?page=1&company[]=SAP%20Labs&sortBy=submissions

import java.util.Arrays;

public class Move_all_zeroes_to_end_of_array {
    public static void main(String[] args) {
        int arr[] = { 3, 5, 0, 0, 4 };
        pushZerosToEnd(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    public static void pushZerosToEnd(int[] arr, int n) {
        // code here
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[count] = arr[i];
                count++;
            }
        }

        for (int i = count; i < arr.length; i++) {
            arr[i] = 0;
        }
    }
}
