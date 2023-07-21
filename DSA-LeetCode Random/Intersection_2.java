//https://leetcode.com/problems/intersection-of-two-arrays-ii/description/

import java.util.ArrayList;
import java.util.Arrays;

public class Intersection_2 {
    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 2, 1 };
        int[] nums2 = { 2, 2 };
        System.out.println(Arrays.toString(intersect(nums1, nums2)));
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    list.add(nums1[i]);
                    nums2[j] = Integer.MIN_VALUE;
                    break;
                }
            }
        }

        int[] ans = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }

        return ans;
    }
}
