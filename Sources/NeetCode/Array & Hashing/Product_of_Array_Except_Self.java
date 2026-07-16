import java.util.Arrays;

public class Product_of_Array_Except_Self {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4 };
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }

    // using 2 separate arrays for left and right product
    public static int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[] {};
        }

        int[] leftProduct = new int[nums.length];
        int[] rightProduct = new int[nums.length];
        leftProduct[0] = 1;
        rightProduct[nums.length - 1] = 1;

        for (int i = 1; i < nums.length; i++) {
            leftProduct[i] = leftProduct[i - 1] * nums[i - 1];
            rightProduct[nums.length - i - 1] = rightProduct[nums.length - i] * nums[nums.length - i];
        }

        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = leftProduct[i] * rightProduct[i];
        }

        return ans;
    }

    // using 1 array and 1 variable
    public static int[] productExceptSelf_2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[] {};
        }

        int[] leftProduct = new int[nums.length];
        int rightProduct = 1;
        leftProduct[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            leftProduct[i] = leftProduct[i - 1] * nums[i - 1];
        }

        int[] ans = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            ans[i] = leftProduct[i] * rightProduct;
            rightProduct = rightProduct * nums[i];
        }

        return ans;
    }
}
