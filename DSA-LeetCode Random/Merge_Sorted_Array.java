// https://leetcode.com/problems/merge-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150

import java.util.Arrays;

public class Merge_Sorted_Array {
    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 3, 0, 0, 0 };
        int[] nums2 = { 2, 5, 6 };
        merge_2(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }

    // using extra space.
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[nums1.length];

        int i = 0;
        int j = 0;
        int index = 0;

        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                temp[index] = nums1[i];
                i++;
            } else {
                temp[index] = nums2[j];
                j++;
            }

            index++;
        }

        while (i < m) {
            temp[index] = nums1[i];
            i++;
            index++;
        }

        while (j < n) {
            temp[index] = nums2[j];
            j++;
            index++;
        }

        for (int k = 0; k < temp.length; k++) {
            nums1[k] = temp[k];
        }
    }

    // ---------------------------------------------------------------------------------

    // using O(1) space.
    // just the reverse simulation of the merging in merge sort.
    // merge from the back.
    public static void merge_2(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int index = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[index] = nums1[i];
                i--;
            } else {
                nums1[index] = nums2[j];
                j--;
            }

            index--;
        }

        while (i >= 0) {
            nums1[index] = nums1[i];
            i--;
            index--;
        }

        while (j >= 0) {
            nums1[index] = nums2[j];
            j--;
            index--;
        }
    }
}
