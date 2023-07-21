//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

public class Find_Minimum_in_Rotated_Sorted_Array {
    public static void main(String[] args) {
        System.out.println(findMin(new int[] { 4, 5, 6, 7, 0, 1, 2 }));
    }

    public static int findMin(int[] nums) {
        int min = nums[0];

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                ;
            }

            else {
                min = nums[i + 1];
            }
        }

        return min;
    }
}
