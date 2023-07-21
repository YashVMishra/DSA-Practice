//https://leetcode.com/problems/search-in-rotated-sorted-array/description/?envType=study-plan&id=level-2

public class Search_in_Rotated_Sorted_Array {
    public static void main(String[] args) {
        int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
        int targte = 0;
        System.out.println(search(nums, targte));
    }

    public static int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }

        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                index = i;
            }
        }

        int ans1 = bin_search(nums, index, nums.length - 1, target);
        if (ans1 != -1) {
            return ans1;
        }

        int ans2 = bin_search(nums, 0, index - 1, target);
        if (ans2 != -1) {
            return ans2;
        }

        return -1;
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
