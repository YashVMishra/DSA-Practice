//https://leetcode.com/problems/merge-sorted-array/description/

import java.util.Arrays;

public class Merge_Sorted_Array {
    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 3, 0, 0, 0 };
        int[] nums2 = { 2, 5, 6 };
        merge(nums1, nums1.length - nums2.length, nums2, nums2.length);
        System.out.println(Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int firstIndex = m - 1;
        int secondIndex = n - 1;
        int extraIndex = m + n - 1;

        while (firstIndex >= 0 && secondIndex >= 0) {
            if (nums1[firstIndex] > nums2[secondIndex]) {
                nums1[extraIndex] = nums1[firstIndex];
                extraIndex--;
                firstIndex--;
            } else {
                nums1[extraIndex] = nums2[secondIndex];
                extraIndex--;
                secondIndex--;
            }
        }

        while (firstIndex >= 0) {
            nums1[extraIndex] = nums1[firstIndex];
            extraIndex--;
            firstIndex--;
        }

        while (secondIndex >= 0) {
            nums1[extraIndex] = nums2[secondIndex];
            extraIndex--;
            secondIndex--;
        }
    }
}
