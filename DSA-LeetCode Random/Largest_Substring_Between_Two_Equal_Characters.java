// https://leetcode.com/problems/largest-substring-between-two-equal-characters/description/?envType=daily-question&envId=2023-12-31

public class Largest_Substring_Between_Two_Equal_Characters {
    public static void main(String[] args) {
        String s = "aa";
        System.out.println(maxLengthBetweenEqualCharacters(s));
    }

    public static int maxLengthBetweenEqualCharacters(String s) {
        int result = -1;
        int n = s.length();

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    result = Math.max(result, j - i - 1);
                }
            }
        }

        return result;
    }
}
