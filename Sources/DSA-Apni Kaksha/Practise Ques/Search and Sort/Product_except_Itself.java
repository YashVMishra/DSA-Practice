import java.util.Arrays;

//https://practice.geeksforgeeks.org/problems/product-array-puzzle4525/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

public class Product_except_Itself {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[] { 3, 1, 5, 2, 6, 3, 8 })));
    }

    public static long[] productExceptSelf(int nums[]) {
        // code here
        int size = nums.length;

        long[] ans_arr = new long[size];
        // int[] left_arr=new int[size];
        // int[] right_arr=new int[size];
        long[] temp = new long[size];

        for (int i = 0; i < size; i++) {
            temp[i] = nums[i];
        }

        ans_arr[0] = 1;
        // right_arr[size-1]=1;

        for (int i = 1; i < size; i++) {
            ans_arr[i] = temp[i - 1] * ans_arr[i - 1];
        }

        long right_product = 1;
        for (int i = size - 1; i >= 0; i--) {
            ans_arr[i] = ans_arr[i] * right_product;
            right_product = right_product * temp[i];
        }

        return ans_arr;
    }
}
