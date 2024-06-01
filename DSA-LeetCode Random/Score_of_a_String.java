// https://leetcode.com/problems/score-of-a-string/description/

public class Score_of_a_String {
    public static void main(String[] args) {
        System.out.println(scoreOfString("aba"));
        System.out.println(scoreOfString("abc"));
        System.out.println(scoreOfString("aaa"));
    }

    public static int scoreOfString(String s) {
        int score = 0;

        for (int i = 1; i < s.length(); i++) {
            score += Math.abs(s.charAt(i - 1) - s.charAt(i));
        }

        return score;
    }
}
