// https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/?envType=daily-question&envId=2023-12-01

public class Check_If_Two_String_Arrays_are_Equivalent {
    public static void main(String[] args) {
        String[] word1 = { "ab", "c" };
        String[] word2 = { "a", "bc" };

        System.out.println(arrayStringsAreEqual(word1, word2));
        System.out.println(arrayStringsAreEqual_2(word1, word2));
    }

    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        for (String s : word1) {
            sb1.append(s);
        }

        for (String s : word2) {
            sb2.append(s);
        }

        return sb1.toString().equals(sb2.toString());
    }

    public static boolean arrayStringsAreEqual_2(String[] word1, String[] word2) {
        int i = 0, j = 0; // word pointers
        int w1 = 0, w2 = 0; // char pointers

        while (i < word1.length && j < word2.length) {

            // we have to do w1++ and w2++ here because we have to check the next char
            // if we do it in the if condition, we will be checking the current char
            // and then incrementing the pointer

            // dry run for better understanding.
            if (word1[i].charAt(w1++) != word2[j].charAt(w2++)) {
                return false;
            }

            if (w1 >= word1[i].length()) {
                i++;
                w1 = 0;
            }

            if (w2 >= word2[j].length()) {
                j++;
                w2 = 0;
            }
        }

        return i == word1.length && j == word2.length;
    }
}
