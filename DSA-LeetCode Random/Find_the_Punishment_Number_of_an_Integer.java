//https://leetcode.com/problems/find-the-punishment-number-of-an-integer/description/

public class Find_the_Punishment_Number_of_an_Integer {

    public static void main(String[] args) {
        int n = 37;
        System.out.println(punishmentNumber(n));
    }

    public static int punishmentNumber(int n) {
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            if (isValid(Integer.toString(i * i), i)) {
                sum += i * i;
            }
        }

        return sum;
    }

    public static boolean isValid(String str, int sum) {
        if (sum < 0) {
            return false;
        }

        if (str.length() == 0 && sum == 0) {
            return true;
        }

        boolean ans = false;
        for (int i = 0; i < str.length(); i++) {
            String subStr = str.substring(0, i + 1);
            int value = Integer.parseInt(subStr);
            ans = ans | isValid(str.substring(i + 1), sum - value);
        }

        return ans;
    }
}