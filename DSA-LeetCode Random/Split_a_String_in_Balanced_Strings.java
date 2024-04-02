// https://leetcode.com/problems/split-a-string-in-balanced-strings/description/

public class Split_a_String_in_Balanced_Strings {
    public static void main(String[] args) {
        String s = "RLRRRLLRLL";
        System.out.println(balancedStringSplit(s));
    }

    public static int balancedStringSplit(String s) {
        int countL = 0;
        int countR = 0;
        int ans = 0;

        for (char ch : s.toCharArray()) {
            if ((ch == 'L')) {
                countL++;
            } else if ((ch == 'R')) {
                countR++;
            }

            if (countL == countR) {
                countL = 0;
                countR = 0;
                ans++;
            }
        }

        return ans;
    }
}
