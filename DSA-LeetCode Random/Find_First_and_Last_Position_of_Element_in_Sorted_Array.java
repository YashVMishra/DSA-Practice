// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/?envType=daily-question&envId=2023-10-09

import java.util.Arrays;

public class Find_First_and_Last_Position_of_Element_in_Sorted_Array {
    public static void main(String[] args) {
        int[] nums = { 5, 7, 7, 8, 8, 10 };
        int target = 8;

        int[] ans = searchRange_3(nums, target);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] = ans[1] = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                ans[0] = i;

                while (i < nums.length && nums[i] == target) {
                    i++;
                }

                ans[1] = i - 1;
            }
        }

        return ans;
    }

    // ------------------------------------------------------------------------------------

    // this may also run in O(n) time
    public static int[] searchRange_2(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] = binarySearch(nums, target);

        // now by running the binary search, we have found the first position of the
        // target element. Now we need to find the last position of the target element.
        // that is always be greater than or equal to the first position.
        if (ans[0] == -1) {
            ans[1] = -1;
        } else {
            int i = ans[0];
            while (i < nums.length && nums[i] == target) {
                i++;
            }

            ans[1] = i - 1;
        }

        return ans;
    }

    private static int binarySearch(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int ans = -1;

        // find first position using binary search
        while (start <= end) {
            int mid = start + (end - start) / 2;

            // if target is found, store the index and search in the left half
            // for lower index.
            if (target == nums[mid]) {
                ans = mid;
                end = mid - 1;
            } else if (target < nums[mid]) {
                end = mid - 1;
            } else if (target > nums[mid]) {
                start = mid + 1;
            }
        }

        return ans;
    }

    // ------------------------------------------------------------------------------------

    public static int[] searchRange_3(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] = ans[1] = -1;

        int start = 0;
        int end = nums.length - 1;

        // find first position using binary search
        while (start <= end) {
            int mid = start + (end - start) / 2;

            // if target is found, store the index and search in the left half
            // for lower index.
            if (target == nums[mid]) {
                ans[0] = mid;
                end = mid - 1;
            } else if (target < nums[mid]) {
                end = mid - 1;
            } else if (target > nums[mid]) {
                start = mid + 1;
            }
        }

        // now by running the binary search, we have found the first position of the
        // target element. Now we need to find the last position of the target element.
        // that is always be greater than or equal to the first position.
        if (ans[0] == -1) {
            ans[1] = -1;
        } else {
            start = 0;
            end = nums.length - 1;

            // find last position using binary search
            while (start <= end) {
                int mid = start + (end - start) / 2;

                // if target is found, store the index and search in the right half
                // for greater index.
                if (target == nums[mid]) {
                    ans[1] = mid;
                    start = mid + 1;
                } else if (target < nums[mid]) {
                    end = mid - 1;
                } else if (target > nums[mid]) {
                    start = mid + 1;
                }
            }
        }

        return ans;
    }
}
