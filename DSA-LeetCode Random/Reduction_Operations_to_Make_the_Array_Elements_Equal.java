import java.util.Arrays;

public class Reduction_Operations_to_Make_the_Array_Elements_Equal {
    public static void main(String[] args) {
        reductionOperations(new int[] { 5, 1, 3 });
    }

    public static int reductionOperations(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int count = 0;

        for (int i = n - 1; i > 0; i--) {
            if (nums[i] == nums[i - 1]) {
                continue;
            }

            count += n - i;
        }

        return count;
    }
}
