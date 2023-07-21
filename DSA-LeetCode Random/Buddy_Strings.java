//https://leetcode.com/problems/buddy-strings/description/

public class Buddy_Strings {
    public static void main(String[] args) {
        String s = "ab", goal = "ba";
        System.out.println(buddyStrings(s, goal));
    }

    public static boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }

        // when the two strings are same then if only one characters appears twice
        // then only they can be buddy strings.
        // checking for the condition in which any one character appears twice
        // then in that case they will be buddy strings as we can swap these two
        // characters
        if (s.equals(goal)) {
            int[] freq = new int[26];
            for (int i = 0; i < s.length(); i++) {
                freq[s.charAt(i) - 'a']++;

                if (freq[s.charAt(i) - 'a'] == 2) {
                    return false;
                }
            }

            return false;
        }

        // now we will find two indices such that we can swap these two indices.
        int firstIndex = -1;
        int secondIndex = -1;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                if (firstIndex == -1) {
                    firstIndex = i;
                } else if (secondIndex == -1) {
                    secondIndex = i;
                } else {

                    // here we are returning false as
                    // there is a third index which do not match
                    // but we can make only two swaps.
                    return false;
                }
            }
        }

        // only one character is different.
        if (secondIndex == -1) {
            return false;
        }

        // if only two characters are in not in order then character at first index of s
        // should be
        // equal to character at second index in goal string and same for the other.
        if (s.charAt(firstIndex) == goal.charAt(secondIndex) && s.charAt(secondIndex) == goal.charAt(firstIndex)) {
            return true;
        }

        return false;
    }
}
