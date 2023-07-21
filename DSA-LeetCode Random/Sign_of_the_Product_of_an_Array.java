//https://leetcode.com/problems/sign-of-the-product-of-an-array/description/

public class Sign_of_the_Product_of_an_Array {
    public static void main(String[] args) {
        int[] nums = { 41, 65, 14, 80, 20, 10, 55, 58, 24, 56, 28, 86, 96, 10, 3, 84, 4, 41, 13, 32, 42, 43, 83, 78, 82,
                70, 15, -41 };
        System.out.println(arraySign(nums));
        System.out.println(arraySign_2(nums));
    }

    // here we can calculate product but there might be a chance that
    // the product overflows so just keep the count of the negative numbers
    // if the count is even then return 1 else return -1;
    public static int arraySign(int[] nums) {
        int negative_count = 0;

        for (int i : nums) {
            if (i == 0) {
                return 0;
            }

            else if (i < 0) {
                negative_count++;
            }
        }

        if (negative_count % 2 != 0) {
            return -1;
        }

        return 1;
    }

    // Do avoid overflow we can just mutiply 1 to the product when the
    // nums[i] is positive and -1 when its negative, this way
    // we can avoid the overflow problem.
    public static int arraySign_2(int[] nums) {
        int product = 1;

        for (int i : nums) {
            if (i == 0) {
                return 0;
            }

            else if (i < 0) {
                product *= -1;
            }

            else {
                product *= 1;
            }
        }

        return product < 0 ? -1 : 1;
    }
}
