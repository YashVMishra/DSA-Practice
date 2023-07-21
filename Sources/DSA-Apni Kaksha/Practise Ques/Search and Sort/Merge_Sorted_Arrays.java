//https://practice.geeksforgeeks.org/problems/merge-two-sorted-arrays-1587115620/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

import java.util.Arrays;

public class Merge_Sorted_Arrays {
    public static void main(String[] args) {
        int arr[] = { 1, 5, 9, 10, 15, 20 };
        int nums[] = { 2, 3, 8, 13 };

        merge_3(arr, nums, arr.length, nums.length);

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(nums));
    }

    // Normal code while using the extra space.
    public static void merge(int[] arr, int len_1, int[] nums, int len_2) {

        int[] temp = new int[len_1 + len_2];

        for (int i = 0; i < temp.length; i++) {
            if (i < len_1) {
                temp[i] = arr[i];
            }

            else {
                temp[i] = nums[i - len_1];
            }
        }

        Arrays.sort(temp);
        // System.out.println(Arrays.toString(temp));

        for (int i = 0; i < temp.length; i++) {
            if (i < len_1) {
                arr[i] = temp[i];
            }

            else {
                nums[i - len_1] = temp[i];
            }
        }
    }

    // using constant space and using a technique similar to insertion sort
    // comparing the first element of the first array with the first element of the
    // second array
    // and if the arr[i] > nums[0], we swap and then sort the nums array
    // repeat for all the elements of the arr.
    public static void merge_2(int[] arr, int len_1, int[] nums, int len_2) {

        for (int i = 0; i < len_1; i++) {
            if (arr[i] < nums[0]) {
                ;
            }

            else {
                swap(arr, nums, i, 0);

                for (int j = 0; j < len_2 - 1; j++) {
                    if (nums[j] < nums[j + 1]) {
                        ;
                    }

                    else {
                        swap(nums, j, j + 1);
                    }
                }
            }
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void swap(int[] arr, int[] nums, int a, int b) {
        int temp = arr[a];
        arr[a] = nums[b];
        nums[b] = temp;
    }

    public static int nextGap(int gap) {
        if (gap <= 1)
            return 0;
        return (gap / 2) + (gap % 2);
    }

    // refer to the striver video for explanantion and dry run for better
    // understanding.
    public static void merge_3(int[] arr, int[] nums, int len_1, int len_2) {

        int i, j, gap = len_1 + len_2;

        for (gap = nextGap(gap); gap > 0; gap = nextGap(gap)) {

            // comparing elements in the first
            // array.
            for (i = 0; i + gap < len_1; i++)
                if (arr[i] > arr[i + gap]) {
                    int temp = arr[i];
                    arr[i] = arr[i + gap];
                    arr[i + gap] = temp;
                }

            // comparing elements in both arrays.
            for (j = gap > len_1 ? gap - len_1 : 0; i < len_1 && j < len_2; i++, j++)
                if (arr[i] > nums[j]) {
                    int temp = arr[i];
                    arr[i] = nums[j];
                    nums[j] = temp;
                }

            if (j < len_2) {
                // comparing elements in the
                // second array.
                for (j = 0; j + gap < len_2; j++)
                    if (nums[j] > nums[j + gap]) {
                        int temp = nums[j];
                        nums[j] = nums[j + gap];
                        nums[j + gap] = temp;
                    }
            }
        }
    }
}
