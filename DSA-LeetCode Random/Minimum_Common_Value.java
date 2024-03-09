// https://leetcode.com/problems/minimum-common-value/description/?envType=daily-question&envId=2024-03-09

import java.util.HashSet;

public class Minimum_Common_Value {
    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 3, 4, 5 };
        int[] nums2 = { 2, 7, 8, 9, 10 };
        System.out.println(getCommon(nums1, nums2));
    }

    // using set approach.
    public static int getCommon(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums1) {
            set.add(num);
        }

        for (int num : nums2) {
            if (set.contains(num)) {
                return num;
            }
        }

        return -1;
    }

    // -------------------------------------------------------------------------------

    // using two pointers approach.
    public static int getCommon_2(int[] nums1, int[] nums2) {
        int i = 0, j = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                return nums1[i];
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        return -1;
    }
}