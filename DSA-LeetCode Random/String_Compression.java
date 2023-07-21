//https://leetcode.com/problems/string-compression/description/

public class String_Compression {
    public static void main(String[] args) {
        char[] chars = { 'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b' };
        System.out.println(compress(chars));
    }

    public static int compress(char[] chars) {
        int count = 0;
        String ans = "";

        for (int i = 0; i < chars.length; i += count) {
            char ch = chars[i];
            count = 1;

            // second loop to find the count of each character.
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[j] == ch) {
                    count++;
                }

                // used break as we want the count of the
                // consecutive same character.
                // break usefull when dealing with input as
                // char[] chars={'a','a', 'b', 'b', 'b','a','a'}
                // here 'a' occurs two times in a different positions.
                else {
                    break;
                }
            }

            if (count == 1) {
                ans = ans + ch;
            }

            else {
                ans = ans + ch + Integer.toString(count);
            }
        }

        for (int i = 0; i < ans.length(); i++) {
            chars[i] = ans.charAt(i);
        }

        return count;
    }
}
