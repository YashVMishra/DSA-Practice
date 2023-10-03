// https://leetcode.com/problems/find-peak-element/description/?envType=study-plan-v2&envId=leetcode-75

public class Find_Peak_Element {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 1, 3, 5, 6, 4 };
        System.out.println(findPeakElement(nums));
    }

    // linear search.
    public static int findPeakElement(int[] nums) {
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            if ((i == 0 || nums[i] > nums[i - 1]) && (i == nums.length - 1 || nums[i] > nums[i + 1])) {
                index = i;
            }
        }

        return index;
    }

    // -----------------------------------------------------------------------------------

    // binary search.
    public static int findPeakElement_2(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }

        if (nums[0] > nums[1]) {
            return 0;
        }

        if (nums[nums.length - 1] > nums[nums.length - 2]) {
            return nums.length - 1;
        }

        int low = 1, high = nums.length - 2;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (nums[mid] > nums[mid - 1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }
}
