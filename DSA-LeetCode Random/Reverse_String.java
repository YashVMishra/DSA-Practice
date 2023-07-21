//https://leetcode.com/problems/reverse-string/description/

import java.util.Arrays;

public class Reverse_String {
    public static void main(String[] args) {
        char[] arr = { 'Y', 'A', 'S', 'H' };
        reverseString(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void reverseString(char[] s) {
        int len = s.length;

        for (int i = 0; i < len / 2; i++) {
            char ch = s[i];
            s[i] = s[len - 1 - i];
            s[len - i - 1] = ch;
        }
    }
}
