//https://leetcode.com/problems/add-to-array-form-of-integer/description/

import java.util.ArrayList;
import java.util.List;

public class Array_Form_Integer {
    public static void main(String[] args) {
        int[] num = { 2, 1, 5 };
        int k = 806;
        System.out.println(addToArrayForm(num, k));
    }

    // simulating the traditional addition technique.
    public static List<Integer> addToArrayForm(int[] num, int k) {

        List<Integer> list = new ArrayList<>();
        String add = Integer.toString(k);
        String str = "";
        String ans = "";

        // converting the array to String.
        for (int i : num) {
            str = str + Integer.toString(i);
        }

        int add_len = add.length() - 1;
        int str_len = str.length() - 1;
        int carry = 0;

        // run the loop till either string is empty.
        while (add_len >= 0 || str_len >= 0) {
            int temp_1 = 0;
            int temp_2 = 0;

            if (add_len >= 0) {
                temp_1 = add.charAt(add_len) - '0';
                add_len--;
            }

            if (str_len >= 0) {
                temp_2 = str.charAt(str_len) - '0';
                str_len--;
            }

            // examine the res var and add the modulo in the ans String.
            int res = temp_1 + temp_2 + carry;

            // this step holds good for every digit but not for the last digit
            // so at last we have to check the carry.
            ans = Integer.toString(res % 10) + ans;
            carry = res / 10;
        }

        // if the carry is not equal to 0 then you have to add the carry in the list.
        if (carry != 0) {
            list.add(carry);
        }

        for (int i = 0; i < ans.length(); i++) {
            list.add(ans.charAt(i) - '0');
        }

        return list;

    }
}
