//https://leetcode.com/problems/find-the-difference-of-two-arrays/description/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class Find_the_Difference_of_Two_Arrays {
    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 3, 3 };
        int[] nums2 = { 1, 1, 2, 2 };
        System.out.println(findDifference(nums1, nums2));
    }

    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(helper(nums1, nums2));
        ans.add(helper(nums2, nums1));

        return ans;
    }

    public static List<Integer> helper(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();

        for (int i : nums1) {
            set.add(i);
        }

        for (int i : nums2) {
            if (set.contains(i)) {
                set.remove(i);
            }
        }

        Iterator<Integer> it = set.iterator();

        while (it.hasNext()) {
            list.add(it.next());
        }

        return list;

        // You can also return this
        // return new ArrayList<>(set);

    }
}
