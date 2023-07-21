//https://leetcode.com/problems/reverse-words-in-a-string/description/?envType=study-plan-v2&id=leetcode-75

public class Reverse_Words_in_a_String {
    public static void main(String[] args) {
        String s = " a good   example ";
        System.out.println(reverseWords(s));
    }

    public static String reverseWords(String s) {
        int i = 0;
        int j = 0;
        int len = s.length();
        String ans = "";

        while (i < len) {
            while (i < len && s.charAt(i) == ' ') {
                i++;
            }

            if (i >= len) {
                break;
            }

            j = i + 1;

            while (j < len && s.charAt(j) != ' ') {
                j++;
            }

            String subStr = s.substring(i, j);
            if (ans.length() == 0) {
                ans = subStr;
            }

            else {
                ans = subStr + " " + ans;
            }

            i = j + 1;
        }

        return ans;
    }
}
