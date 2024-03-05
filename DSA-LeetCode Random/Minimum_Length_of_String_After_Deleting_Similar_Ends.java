// https://leetcode.com/problems/minimum-length-of-string-after-deleting-similar-ends/description/?envType=daily-question&envId=2024-03-05

public class Minimum_Length_of_String_After_Deleting_Similar_Ends {
    public static void main(String[] args) {
        System.out.println(minimumLength("aabccabba"));
    }

    public static int minimumLength(String s) {
        int n = s.length();
        int i = 0, j = n - 1;

        while (i < j && s.charAt(i) == s.charAt(j)) {
            char ch = s.charAt(i);

            while (i < j && s.charAt(i) == ch) {
                i++;
            }

            while (j >= i && s.charAt(j) == ch) {
                j--;
            }
        }

        return j - i + 1;
    }
}
