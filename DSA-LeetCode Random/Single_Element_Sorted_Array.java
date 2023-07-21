//https://leetcode.com/problems/single-element-in-a-sorted-array/description/

public class Single_Element_Sorted_Array {
    public static void main(String[] args) {
        int[] nums = { 1, 1, 2, 2, 3, 3, 4, 5, 5 };
        System.out.println(singleNonDuplicate(nums));
        System.out.println(singleNonDuplicate_2(nums));
    }

    // uses O(n) TC.
    // fact that the XOR of a number with itself gives zero is being
    // used here.
    public static int singleNonDuplicate(int[] nums) {
        int ans = 0;

        for (int i : nums) {
            ans = ans ^ i;
        }

        return ans;
    }

    // uses O(log n) TC.
    // for logic go and find in the Notes folder.
    public static int singleNonDuplicate_2(int[] nums) {
        int low = 0;
        int high = nums.length - 2;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == nums[mid ^ 1]) {
                low = mid + 1;
            }

            else {
                high = mid - 1;
            }
        }

        return nums[low];
    }
}
