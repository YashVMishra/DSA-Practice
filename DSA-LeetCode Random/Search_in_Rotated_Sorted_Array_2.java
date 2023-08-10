// https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/

public class Search_in_Rotated_Sorted_Array_2 {
    public static void main(String[] args) {
        int[] nums = { 2, 5, 6, 0, 0, 1, 2 };
        int target = 0;
        System.out.println(search(nums, target));
    }

    public static boolean search(int[] nums, int target) {
        if (nums.length == 0) {
            return false;
        }

        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                index = i;
            }
        }

        int ans1 = bin_search(nums, index, nums.length - 1, target);
        if (ans1 != -1) {
            return true;
        }

        int ans2 = bin_search(nums, 0, index - 1, target);
        if (ans2 != -1) {
            return true;
        }

        return false;
    }

    public static int bin_search(int[] nums, int i, int j, int target) {
        int start = i;
        int end = j;

        while (start <= end) {
            int mid = (start) + (end - start) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            else if (target > nums[mid]) {
                start = mid + 1;
            }

            else {
                end = mid - 1;
            }
        }

        return -1;
    }
}
