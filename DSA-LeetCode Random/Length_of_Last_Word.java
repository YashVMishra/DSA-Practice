// https://leetcode.com/problems/length-of-last-word/description/?envType=study-plan-v2&envId=top-interview-150

public class Length_of_Last_Word {
    public static void main(String[] args) {
        String s = "   fly me   to   the moon  ";
        System.out.println(lengthOfLastWord(s));
    }

    public static int lengthOfLastWord(String s) {
        s = s.trim();
        int len = 0;

        // no need to add space at the beginning
        // of the string for a single word as
        // the loop will automatcially break
        // when the string length is traversed as
        // a whole.
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                len++;
            } else {
                break;
            }
        }

        return len;
    }
}