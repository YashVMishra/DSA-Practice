// https://leetcode.com/problems/redistribute-characters-to-make-all-strings-equal/description/?envType=daily-question&envId=2023-12-30

public class Redistribute_Characters_to_Make_All_Strings_Equal {
    public static void main(String[] args) {
        System.out.println(makeEqual(new String[] { "abc", "aabc", "bc" }));
    }

    // logic is simple, to make all strings equal, the frequency of each character
    // should be divisible by the number of strings
    // so we can just count the frequency of each character and check if it is
    // divisible by the number of strings
    // if not, return false
    public static boolean makeEqual(String[] words) {
        int[] freq = new int[26];
        for (String word : words) {
            for (char c : word.toCharArray()) {
                freq[c - 'a']++;
            }
        }

        for (int f : freq) {
            if (f % words.length != 0) {
                return false;
            }
        }

        return true;
    }
}
