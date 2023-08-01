// https://leetcode.com/problems/permutations/description/

// for approach - 1 see the video
// https://www.youtube.com/watch?v=YK78FU5Ffjw

// for approach - 2 see the video
// https://www.youtube.com/watch?v=f2ic2Rsc9pU

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        System.out.println(permute(nums));
        System.out.println(permute_2(nums));
    }

    // uses extra space and takes n * n! TC.
    // SC O(n) + O(n).
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        boolean[] freq = new boolean[nums.length];

        recurPermute(nums, ans, ds, freq);
        return ans;
    }

    public static void recurPermute(int[] nums, List<List<Integer>> ans, List<Integer> ds, boolean[] freq) {
        if (ds.size() == nums.length) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (freq[i] == false) {
                freq[i] = true;
                ds.add(nums[i]);
                recurPermute(nums, ans, ds, freq);

                // backtracking.
                ds.remove(ds.size() - 1);
                freq[i] = false;
            }
        }
    }

    // uses TC of n * n! and no extra space.
    public static List<List<Integer>> permute_2(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        recurPermute_2(nums, ans, 0);
        return ans;
    }

    public static void recurPermute_2(int[] nums, List<List<Integer>> ans, int index) {
        if (index == nums.length) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                list.add(nums[i]);
            }

            ans.add(list);
        }

        for (int i = index; i < nums.length; i++) {
            swap(nums, index, i);
            recurPermute_2(nums, ans, index + 1);
            swap(nums, index, i);
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
