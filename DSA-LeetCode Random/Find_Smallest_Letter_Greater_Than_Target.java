//https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/

public class Find_Smallest_Letter_Greater_Than_Target {
    public static void main(String[] args) {
        char[] letters = { 'x', 'x', 'y' };
        char target = 'z';
        System.out.println(nextGreatestLetter(letters, target));
    }

    public static char nextGreatestLetter(char[] letters, char target) {
        char ans = letters[0];

        for (int i = letters.length - 1; i >= 0; i--) {
            if (letters[i] > target) {
                ans = letters[i];
            }
        }

        return ans;
    }
}
