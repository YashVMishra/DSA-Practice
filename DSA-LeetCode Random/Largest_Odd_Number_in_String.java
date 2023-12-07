// https://leetcode.com/problems/largest-odd-number-in-string/description/?envType=daily-question&envId=2023-12-07

public class Largest_Odd_Number_in_String {
    public static void main(String[] args) {
        String num = "35427";
        System.out.println(largestOddNumber(num));
    }

    public static String largestOddNumber(String num) {
        int i = num.length() - 1;
        while (i >= 0) {
            int digit = num.charAt(i) - '0';
            if (digit % 2 == 1) {
                break;
            }

            i--;
        }

        if (i == -1) {
            return "";
        }

        return num.substring(0, i + 1);
    }
}