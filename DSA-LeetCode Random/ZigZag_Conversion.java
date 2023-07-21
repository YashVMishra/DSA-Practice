//https://leetcode.com/problems/zigzag-conversion/description/

public class ZigZag_Conversion {
    public static void main(String[] args) {
        String str = "PAYPALISHIRING";
        System.out.println(convert(str, 3));
    }

    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        int len = s.length();
        String ans = "";
        for (int i = 0; i < numRows; i++) {
            int increment = 2 * (numRows - 1);

            for (int j = i; j < len; j += increment) {
                ans += s.charAt(j);
                if ((i > 0) && (i < numRows - 1) && (j + increment - 2 * i < len)) {
                    ans = ans + s.charAt(j + increment - 2 * i);
                }
            }
        }

        return ans;
    }
}
