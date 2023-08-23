// https://leetcode.com/problems/reorganize-string/description/

public class Reorganize_String {
    public static void main(String[] args) {
        String s = "aaaabbbcc";
        System.out.println(reorganizeString(s));
    }

    public static String reorganizeString(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {

            // count the frequency of each character
            count[s.charAt(i) - 'a']++;
        }

        // find the most frequent character and character also.
        int max = 0, letter = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > max) {
                max = count[i];
                letter = i;
            }
        }

        // if the most frequent character is more than half of the string length, then
        // return empty string.
        if (max > (s.length() + 1) / 2) {
            return "";
        }

        // now create ans array to fill the characters.
        // and fill the most frequent character at even index.
        char[] ans = new char[s.length()];
        int index = 0;
        while (max > 0) {
            ans[index] = (char) (letter + 'a');
            index += 2;
            max--;
        }

        // make the count of the most frequent character as zero.
        count[letter] = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {

                // after we have filled the most frequent character at even index and
                // we have reached the end of the array then we change the index to 1
                // and after that we dont have to think about changing the index
                // cause we have already filled the most frequent character at even index.
                // and now the index will not exceed ans array limit.
                index = index >= ans.length ? 1 : index;
                ans[index] = (char) (i + 'a');
                index += 2;
                count[i]--;
            }
        }

        return String.valueOf(ans);
    }
}