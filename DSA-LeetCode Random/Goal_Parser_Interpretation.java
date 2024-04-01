// https://leetcode.com/problems/goal-parser-interpretation/description/

public class Goal_Parser_Interpretation {
    public static void main(String[] args) {
        String command = "(al)G(al)()()G";

        System.out.println(interpret(command));
    }

    public static String interpret(String command) {
        StringBuilder sb = new StringBuilder();
        String temp = "";

        for (char ch : command.toCharArray()) {
            temp = temp + ch;

            if (temp.equals("G")) {
                sb.append("G");
                temp = "";
            } else if (temp.equals("()")) {
                sb.append("o");
                temp = "";
            } else if (temp.equals("(al)")) {
                sb.append("al");
                temp = "";
            }
        }

        return sb.toString();
    }

    // --------------------------------------------------------------------------------

    // using String functions.
    public static String interpret_2(String command) {
        return command.replace("()", "o").replace("(al)", "al");
    }
}
