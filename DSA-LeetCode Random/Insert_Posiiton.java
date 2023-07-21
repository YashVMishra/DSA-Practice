//https://leetcode.com/problems/search-insert-position/description/

public class Insert_Posiiton {
    public static void main(String[] args) {
        int[] nums = { 1 };
        int target = 1;
        System.out.println(searchInsert(nums, target));
    }

    // the solution is just the extended version or application of binary
    // search that is after the while loop is terminated the start and end points to
    // the immediate right and immediate left respectively of the target
    public static int searchInsert(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            System.out.println(mid);

            if (nums[mid] == target) {
                System.out.println("hello");
                return mid;
            }

            if (nums[mid] > target) {
                end = mid - 1;
            }

            else {
                start = mid + 1;
            }
        }

        return end + 1;
    }
}
