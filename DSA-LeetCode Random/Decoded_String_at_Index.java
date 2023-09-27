// https://leetcode.com/problems/decoded-string-at-index/description/?envType=daily-question&envId=2023-09-27

public class Decoded_String_at_Index {
    public static void main(String[] args) {
        String s = "leet2code3";
        int k = 10;
        System.out.println(decodeAtIndex(s, k));
    }

    public static String decodeAtIndex(String s, int k) {
        int n = s.length();
        long size = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                size *= (c - '0');
            } else {
                size += 1;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            k %= size;

            if (k == 0 && Character.isLetter(c)) {
                return String.valueOf(c);
            }

            if (Character.isDigit(c)) {
                size /= (c - '0');
            } else {
                size -= 1;
            }
        }

        return "";
    }
}
