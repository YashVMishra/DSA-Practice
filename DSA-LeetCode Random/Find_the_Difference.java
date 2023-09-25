// https://leetcode.com/problems/find-the-difference/description/?envType=daily-question&envId=2023-09-25

public class Find_the_Difference {
    public static void main(String[] args) {
        System.out.println(findTheDifference("abcd", "abdce"));
        System.out.println(findTheDifference_2("abcd", "abdce"));
        System.out.println(findTheDifference_3("abcd", "abdce"));
    }

    // its simple just count the frequency of elements from the first string
    // then subtract the frequency of elements from the second string
    // whichever element has non-zero frequency is the answer
    public static char findTheDifference(String s, String t) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            count[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                return (char) ('a' + i);
            }
        }

        return 'a';
    }

    // since both the strings have only one element different
    // then find the sum and return the difference of them.
    public static char findTheDifference_2(String s, String t) {
        int sSum = 0, tSum = 0;
        for (int i = 0; i < s.length(); i++) {
            sSum += s.charAt(i);
        }

        for (int i = 0; i < t.length(); i++) {
            tSum += t.charAt(i);
        }

        return (char) (tSum - sSum);
    }

    // we can find the XOR of the elements of both the strings
    public static char findTheDifference_3(String s, String t) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            ans ^= s.charAt(i);
        }

        for (int i = 0; i < t.length(); i++) {
            ans ^= t.charAt(i);
        }

        return (char) ans;
    }
}
