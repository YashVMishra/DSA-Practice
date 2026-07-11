import java.util.Arrays;

public class Concatenation_of_Array {
    public static void main(String[] args) {
        int[] nums = { 1, 3, 2, 1 };
        System.out.println(Arrays.toString(getConcatenation(nums)));
    }

    public static int[] getConcatenation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[] {};
        }

        int length = nums.length;
        int[] ans = new int[length * 2];

        for (int i = 0; i < ans.length; i++) {
            ans[i] = nums[i % length];
        }

        return ans;
    }
}
