// https://leetcode.com/problems/subarray-product-less-than-k/description/?envType=daily-question&envId=2024-03-27

public class Subarray_Product_Less_Than_K {
    public static void main(String[] args) {
        int[] nums = { 10, 2, 1, 199 };
        int k = 50;
        System.out.println(numSubarrayProductLessThanK(nums, k));
    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0;
        int i = 0;
        int j = 0;
        int product = 1;

        while (j < nums.length) {
            product *= nums[j];

            while (product >= k && i <= j) {
                product /= nums[i];
                i++;
            }

            count += j - i + 1;
            j++;
        }

        return count;
    }
}
