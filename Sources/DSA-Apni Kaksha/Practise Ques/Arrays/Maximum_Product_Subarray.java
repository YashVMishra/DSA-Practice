//https://leetcode.com/problems/maximum-product-subarray/

class Maximum_Product_Subarray {
    public static void main(String[] args) {
        System.out.println(maxProduct(new int[] { 2, 3, -2, 4 }));
    }

    public static int maxProduct(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int max = 1;
        int min = 1;
        int ans = nums[0];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = max;
                max = min;
                min = temp;
            }

            max = Math.max(nums[i], nums[i] * max);
            min = Math.min(nums[i], nums[i] * min);

            ans = Math.max(max, ans);
        }

        return ans;
    }
}