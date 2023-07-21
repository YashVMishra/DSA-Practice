//https://leetcode.com/problems/add-binary/description/

public class Add_Binary {
    public static void main(String[] args) {
        System.out.println(addBinary(
                "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101",
                "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"));
    }

    public static String addBinary(String a, String b) {

        // initially taking carry as zero.
        int carry = 0;
        String ans = "";

        int a_len = a.length() - 1;
        int b_len = b.length() - 1;

        // iterating till one string is left
        while (a_len >= 0 || b_len >= 0) {

            // initializing as zero as there might be a case that
            // one string finishes before other.
            int num1 = 0;
            int num2 = 0;

            if (a_len >= 0) {
                num1 = a.charAt(a_len) == '1' ? 1 : 0;
            }

            if (b_len >= 0) {
                num2 = b.charAt(b_len) == '1' ? 1 : 0;
            }

            int temp = num1 + num2 + carry;

            // gives the result
            if (temp % 2 == 0) {
                ans = ans + "0";
            }

            else {
                ans = ans + "1";
            }

            // gives the carry
            carry = temp / 2;
            a_len--;
            b_len--;

        }

        // very important as in the last bit there might be a carry that the
        // loop will not consider.
        if (carry == 1) {
            ans = ans + "1";
        }

        // reverse the string.
        return reverse(ans);
    }

    public static String reverse(String str) {
        String ans = "";

        for (int i = str.length() - 1; i >= 0; i--) {
            ans = ans + str.charAt(i);
        }

        return ans;
    }
}
