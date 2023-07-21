//https://leetcode.com/problems/multiply-strings/description/

import java.util.Arrays;

public class Multiply_String {
    public static void main(String[] args) {
        System.out.println(multiply("200", "6"));
    }

    public static String multiply(String num1, String num2) {
        int len_1 = num1.length();
        int len_2 = num2.length();

        char[] temp_1 = num1.toCharArray();
        char[] temp_2 = num2.toCharArray();
        char[] result = new char[len_1 + len_2];
        Arrays.fill(result, '0');

        // logic here is all the simulation of traditional way of multiplying
        for (int i = len_1 - 1; i >= 0; i--) {
            for (int j = len_2 - 1; j >= 0; j--) {
                int product = (temp_1[i] - '0') * (temp_2[j] - '0');

                int temp_sum = (result[i + j + 1] - '0') + product;

                result[i + j + 1] = (char) (temp_sum % 10 + '0');
                result[i + j] = (char) ((result[i + j] - '0') + (temp_sum / 10 + '0'));
            }
        }

        String ans = "";

        // used for finding the first non-zero character.
        boolean isZero = false;

        for (int i = 0; i < result.length; i++) {
            if (result[i] == '0' && !isZero) {
                continue;
            }

            ans = ans + result[i];
            isZero = true;
        }

        return ans.length() == 0 ? "0" : ans;
    }
}
