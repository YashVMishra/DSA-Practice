// https://leetcode.com/problems/search-in-rotated-sorted-array/description/

// do on your own.

public class Search_in_Rotated_Sorted_Array {
    public static void main(String[] args) {
        int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
        int target = 0;
        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }

        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                index = i;
                break;
            }
        }

        int ans1 = binarySearch(nums, index, nums.length - 1, target);
        if (ans1 != -1) {
            return ans1;
        }

        int ans2 = binarySearch(nums, 0, index - 1, target);
        if (ans2 != -1) {
            return ans2;
        }

        return -1;
    }

    public static int binarySearch(int[] nums, int start, int end, int target) {
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
