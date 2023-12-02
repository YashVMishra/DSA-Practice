// https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/description/?envType=daily-question&envId=2023-12-02

public class Find_Words_That_Can_Be_Formed_by_Characters {
    public static void main(String[] args) {
        String[] words = { "cat", "bt", "hat", "tree" };
        String chars = "atach";
        System.out.println(countCharacters(words, chars));
    }

    // logic is very simple just count the frequency of each character in the
    // chars string and then compare it with the frequency of each character in
    // the words string.
    // if the frequncy of each character in the words string is less than or
    // equal to the frequency of each character in the chars string then add the
    // length of the word in the ans.

    // the questions wants that how many elements in the words array can be formed
    // from the letters in the chars string, not every element in the words array
    // can be compared independently with the chars string.

    // for example: if the chars string is "atach" and the words array is
    // ["cat","bt","hat","tree"] then the answer is 6 because "cat" and "hat" can
    // we do not have to eliminate the frequency of letters pf the word "cat" from
    // the count array, we have to compare each word as an independent entity.
    public static int countCharacters(String[] words, String chars) {
        int[] count = new int[26];
        int ans = 0;

        for (int i = 0; i < chars.length(); i++) {
            count[chars.charAt(i) - 'a']++;
        }

        for (String word : words) {
            int[] temp = new int[26];
            boolean flag = true;

            for (int i = 0; i < word.length(); i++) {
                temp[word.charAt(i) - 'a']++;
            }

            for (int i = 0; i < 26; i++) {
                if (temp[i] > count[i]) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                ans += word.length();
            }
        }

        return ans;
    }
}