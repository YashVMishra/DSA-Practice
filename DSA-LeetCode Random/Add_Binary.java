//https://leetcode.com/problems/add-binary/description/

public class Add_Binary {
    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";
        System.out.println(addBinary(a, b));
    }

    // simulating the real addition process of two Binary numbers.
    public static String addBinary(String a, String b) {
        int carry = 0;
        String ans = "";

        int a_len = a.length() - 1;
        int b_len = b.length() - 1;

        while (a_len >= 0 || b_len >= 0) {
            int num_1 = 0;
            int num_2 = 0;

            if (a_len >= 0) {
                num_1 = a.charAt(a_len) == '1' ? 1 : 0;
            }

            if (b_len >= 0) {
                num_2 = b.charAt(b_len) == '1' ? 1 : 0;
            }

            int temp = num_1 + num_2 + carry;

            if (temp % 2 == 0) {
                ans = "0" + ans;
            }

            else {
                ans = "1" + ans;
            }

            carry = temp / 2;
            a_len--;
            b_len--;
        }

        // checking for carry to be 1 as last bits might have produced a carry.
        if (carry == 1) {
            ans = "1" + ans;
        }

        return ans;
    }
}
