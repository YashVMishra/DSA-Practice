// https://leetcode.com/problems/largest-3-same-digit-number-in-string/description/?envType=daily-question&envId=2023-12-04

public class Largest_3_Same_Digit_Number_in_String {
    public static void main(String[] args) {
        String num = "6777133339";
        System.out.println(largestGoodInteger(num));
    }

    public static String largestGoodInteger(String num) {
        String ans = "";

        for (int i = 0; i < num.length() - 3; i++) {
            String temp = num.substring(i, i + 3);
            if (temp.charAt(0) == temp.charAt(1) && temp.charAt(1) == temp.charAt(2)) {
                if (ans.isEmpty()) {
                    ans = temp;
                } else {
                    ans = ans.compareTo(temp) > 0 ? ans : temp;
                }
            }
        }

        return ans;
    }
}
