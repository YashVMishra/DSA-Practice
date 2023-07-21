//https://leetcode.com/problems/integer-to-roman/description/

public class Integer_Roman {
    public static void main(String[] args) {
        System.out.println(intToRoman(1994));
    }

    public static String intToRoman(int num) {
        String ans = "";

        int[] temp_1 = { 1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000 };
        String[] temp_2 = { "I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M" };

        for (int i = temp_1.length - 1; i >= 0; i--) {
            while (num >= temp_1[i]) {
                num -= temp_1[i];
                ans = ans + temp_2[i];
            }
        }

        return ans;
    }
}
