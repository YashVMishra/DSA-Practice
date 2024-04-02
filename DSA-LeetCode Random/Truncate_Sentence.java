// https://leetcode.com/problems/truncate-sentence/description/

public class Truncate_Sentence {
    public static void main(String[] args) {
        String s = "Hello how are you Contestant";
        int k = 4;
        System.out.println(truncateSentence(s, k));
    }

    public static String truncateSentence(String s, int k) {
        StringBuilder sb = new StringBuilder();
        s.trim();
        s = s + ' ';
        String word = "";

        for (char ch : s.toCharArray()) {
            if (ch != ' ') {
                word += ch;
            } else {
                if (k > 0) {
                    sb.append(word + ' ');
                    k--;
                    word = "";
                } else {
                    break;
                }
            }
        }

        return sb.toString().trim();
    }

    // ------------------------------------------------------------------------------------------------------------------

    public static String truncateSentence_2(String s, int k) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < k; i++) {
            sb.append(words[i] + " ");
        }

        return sb.toString().trim();
    }
}
