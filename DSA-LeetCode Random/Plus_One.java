//https://leetcode.com/problems/plus-one/description/

import java.util.Arrays;

public class Plus_One {
    public static void main(String[] args) {
        int[] arr = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
        System.out.println(Arrays.toString(plusOne(arr)));
    }

    public static int[] plusOne(int[] digits) {

        int carry = 1;

        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] = digits[i] + carry;

            if (digits[i] == 10) {
                digits[i] = 0;
                carry = 1;
            }

            else {
                carry = 0;
            }
        }

        if (carry == 1) {
            int[] ans = new int[digits.length + 1];

            ans[0] = 1;
            for (int i = 1; i < ans.length; i++) {
                ans[i] = digits[i - 1];
            }

            return ans;
        }

        return digits;
    }
}
