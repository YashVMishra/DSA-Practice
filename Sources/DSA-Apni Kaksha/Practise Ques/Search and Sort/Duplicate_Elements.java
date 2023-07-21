//https://www.geeksforgeeks.org/find-duplicates-in-on-time-and-constant-extra-space/

import java.util.Arrays;

public class Duplicate_Elements {
    public static void main(String[] args) {
        duplicates(new int[] { 0, 2, 1, 5, 2, 6, 0 });
        duplicates_2(new int[] { 0, 2, 1, 5, 2, 6, 0 });
    }

    // uses nlogn complexity.
    public static void duplicates(int[] arr) {
        Arrays.sort(arr);

        int count = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                count++;
            }

            else {
                if (count >= 1) {
                    System.out.print(arr[i] + "     ");
                    count = 0;
                }
            }
        }

        if (count >= 1) {
            System.out.println(arr[arr.length - 1]);
        }
    }

    // uses O(n) complexity i.e uses cyclic sort coz numbers are from 0 to n-1.
    public static void duplicates_2(int[] arr) {
        sort(arr);
        // System.out.println(Arrays.toString(arr));

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i) {
                System.out.print(arr[i] + "     ");
            }
        }
    }

    // cyclic sort code.
    public static void sort(int[] arr) {
        int i = 0;

        while (i < arr.length) {
            int correct = arr[i];
            if (arr[i] != arr[correct]) {
                swap(arr, i, correct);
            }

            else {
                i++;
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
