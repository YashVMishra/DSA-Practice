//https://leetcode.com/problems/find-the-duplicate-number/description/

public class Find_the_Duplicate_Number {
    public static void main(String[] args) {
        int[] nums = { 1, 3, 4, 2, 2 };
        System.out.println(findDuplicate(nums));
    }

    public static int findDuplicate(int[] nums) {
        sort(nums);
        return nums[nums.length - 1];
    }

    // uses Count sort to sort the array.
    public static void sort(int[] nums) {
        int index = 0;
        while (index < nums.length) {
            int correctIndex = nums[index] - 1;

            if (nums[index] != nums[correctIndex]) {
                swap(nums, index, correctIndex);
            } else {
                index++;
            }
        }
    }

    public static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
