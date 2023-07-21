//https://leetcode.com/problems/search-in-rotated-sorted-array/
//https://practice.geeksforgeeks.org/problems/search-in-a-rotated-array4618/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

class Search_in_Rotated_Sorted_Array {
    public static void main(String[] args) {
        System.out.println(search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 1));
    }

    public static int search(int[] nums, int target) {
        int index = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                ;
            }

            else {
                index = i;// index of the greatest element
            }
        }
        // System.out.println(index);
        int ans_1 = bin_search(nums, target, 0, index);
        if (ans_1 != -1) {
            return ans_1;
        }

        int ans_2 = bin_search(nums, target, index + 1, nums.length - 1);
        if (ans_2 != -1) {
            return ans_2;
        }

        return -1;

    }

    public static int bin_search(int[] arr, int target, int s, int e) {
        if (arr.length == 0)
            return -1;
        int start = s;
        int end = e;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target)
                return mid;
            else if (arr[mid] < target)
                start = mid + 1;
            else
                end = mid - 1;
        }

        return -1;
    }

}