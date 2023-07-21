//https://www.geeksforgeeks.org/check-reversing-sub-array-make-array-sorted/

import java.util.Arrays;

public class Reverse_SubArray {
    public static void main(String[] args) {
        System.out.println(reverseSubarray(new int[] { 1, 2, 4, 5, 3 }));
    }

    public static boolean reverseSubarray(int[] arr) {
        int len = arr.length;

        int first_index = -1;
        int last_index = -1;

        for (int i = 0; i < len - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                ;
            }

            else {
                first_index = i;
                break;
            }
        }

        if (first_index == -1) {
            return true;
        }

        for (int j = first_index; j < len - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                last_index = j + 1;
            }
        }

        // System.out.println(first_index);
        // System.out.println(last_index);

        int[] temp = Arrays.copyOfRange(arr, first_index, last_index + 1);
        // System.out.println(Arrays.toString(temp));
        reverse(temp);
        // System.out.println(Arrays.toString(temp));

        int index = 0;
        for (int i = first_index; i <= last_index; i++) {
            arr[i] = temp[index];
            index++;
        }

        for (int i = 0; i < len - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                ;
            }

            else {
                return false;
            }
        }

        return true;
    }

    public static void reverse(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            swap(arr, i, arr.length - 1 - i);
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
