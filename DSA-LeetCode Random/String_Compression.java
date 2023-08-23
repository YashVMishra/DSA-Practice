// https://leetcode.com/problems/string-compression/description/?envType=study-plan-v2&envId=leetcode-75

import java.util.Arrays;

public class String_Compression {
    public static void main(String[] args) {
        char[] chars = { 'a', 'a', 'b', 'b', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c', 'c' };
        System.out.println(compress(chars));
        System.out.println(Arrays.toString(chars));
    }

    public static int compress(char[] chars) {
        StringBuilder ans = new StringBuilder();
        int count = 0;

        for (int i = 0; i < chars.length; i += count) {
            char ch = chars[i];
            count = 1;

            for (int j = i + 1; j < chars.length; j++) {
                if (chars[j] == ch) {
                    count++;
                } else {

                    // break will be useful for the test cases like
                    // { 'a', 'a', 'a', 'b', 'b', 'b', 'b', 'a', 'a'}
                    break;
                }
            }

            if (count == 1) {
                ans.append(ch);
            } else {
                ans.append(ch);
                ans.append(count);
            }
        }

        for (int i = 0; i < ans.length(); i++) {
            chars[i] = ans.charAt(i);
        }

        return ans.length();
    }
}
