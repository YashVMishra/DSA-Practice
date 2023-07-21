//https://leetcode.com/problems/decode-string/description/?envType=study-plan&id=level-1

import java.util.Stack;

public class Decode_String {
    public static void main(String[] args) {
        String s = "3[a2[c]]";
        System.out.println(decodeString(s));
    }

    public static String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();

        StringBuilder str = new StringBuilder();
        int num = 0;

        for (char ch : s.toCharArray()) {

            // four types of characters in s
            // letter, digit, opening and closing brackets.

            // forms the numbers.
            if (ch >= '0' && ch <= '9') {
                num = num * 10 + (ch - '0');
            }

            // as you find the opening brackets then push the str and make it empty
            // then push num as well and make it 0 as well.
            else if (ch == '[') {
                strStack.add(str);
                str = new StringBuilder();

                numStack.push(num);
                num = 0;
            }

            // this is imp, as you find the closing bracket
            // in str you have the current string that you have to append to the
            // previous string.
            // So pop form both the stack and perform the below tasks.
            else if (ch == ']') {
                int count = numStack.pop();
                StringBuilder temp = str;
                str = strStack.pop();

                while (count > 0) {
                    str.append(temp);
                    count--;
                }
            }

            else {
                str.append(ch);
            }
        }

        return str.toString();
    }
}
