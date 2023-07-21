//https://leetcode.com/problems/check-if-the-sentence-is-pangram/

public class Pangram_Sentence {
    public static void main(String[] args) {
        System.out.println(checkIfPangram("thequickbrownfoxjumpsoverthelazydog"));
    }

    public static boolean checkIfPangram(String sentence) {
        if (sentence.length() < 26) {
            return false;
        }

        else {
            int[] alphabet = new int[26];
            int ascii_index = 97;

            for (int i = 0; i < alphabet.length; i++) {
                alphabet[i] = ascii_index;
                ascii_index++;
            }

            for (int i = 0; i < sentence.length(); i++) {
                char ch = sentence.charAt(i);

                for (int j = 0; j < alphabet.length; j++) {
                    if (alphabet[j] == ch) {
                        alphabet[j] = 0;
                    }
                }
            }

            for (int i : alphabet) {
                if (i == 0) {
                    ;
                }

                else {
                    return false;
                }
            }

            return true;
        }
    }
}
