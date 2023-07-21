//https://leetcode.com/problems/string-to-integer-atoi/description/

public class String_to_Integer_atoi {

    public static void main(String[] args) {
        String s = "  -42";
        System.out.println(myAtoi(s));
    }

    // keep in mind the test cases, there quite a few tough ones.
    // maintain result as long as to check for out of bound condition.
    public static int myAtoi(String s) {
        String str = s.trim();

        if (str.length() == 0 || str == null) {
            return 0;
        }

        long result = 0;
        long sign = 1;
        int index = 0;

        if (str.charAt(index) == '-') {
            index = 1;
            sign = -1;
        }

        else if (str.charAt(index) == '+') {
            index = 1;
            sign = 1;
        }

        for (int j = index; j < str.length(); j++) {
            int temp = str.charAt(j) - '0';

            if (temp >= 0 && temp <= 9) {
                result = (result * 10) + temp;

                // checking in the loop as it might go over the
                // long datatype range.
                if (result * sign > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }

                if (result * sign < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
            }

            else {
                break;
            }
        }

        result *= sign;

        return (int) (result);

    }
}
